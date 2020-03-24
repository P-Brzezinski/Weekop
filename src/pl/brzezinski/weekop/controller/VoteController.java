package pl.brzezinski.weekop.controller;

import pl.brzezinski.weekop.model.Discovery;
import pl.brzezinski.weekop.model.User;
import pl.brzezinski.weekop.model.Vote;
import pl.brzezinski.weekop.model.VoteType;
import pl.brzezinski.weekop.service.DiscoveryService;
import pl.brzezinski.weekop.service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vote")
public class VoteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loggedUser = (User) req.getSession().getAttribute("user");
        if (loggedUser != null) {
            VoteType voteType = VoteType.valueOf(req.getParameter("vote"));
            long userId = loggedUser.getId();
            long discoveryId = Long.parseLong(req.getParameter("discovery_id"));
            updateVote(userId, discoveryId, voteType);
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }

    private void updateVote(long userId, long discoveryId, VoteType voteType) {
        VoteService voteService = new VoteService();
        Vote existingVote = voteService.getVoteByDiscoveryUserId(discoveryId, userId);
        Vote updateVoted = voteService.addOrUpdateVote(discoveryId, userId, voteType);
        if (existingVote != updateVoted || !updateVoted.equals(existingVote)) {
            updateDiscovery(discoveryId, existingVote, updateVoted);
        }
    }

    private void updateDiscovery(long discoveryId, Vote oldVote, Vote newVote) {
        DiscoveryService discoveryService = new DiscoveryService();
        Discovery discoveryById = discoveryService.getDiscoveryById(discoveryId);
        Discovery updatedDiscovery = null;
        if (oldVote == null & newVote != null) {
            updatedDiscovery = addDiscoveryVote(discoveryById, newVote.getVoteType());
        } else if (oldVote != null && newVote != null) {
            updatedDiscovery = removeDiscoveryVote(discoveryById, oldVote.getVoteType());
            updatedDiscovery = addDiscoveryVote(updatedDiscovery, newVote.getVoteType());
        }
        discoveryService.updateDiscovery(updatedDiscovery);
    }

    private Discovery addDiscoveryVote(Discovery discovery, VoteType voteType) {
        Discovery discoveryCopy = new Discovery(discovery);
        if (voteType == VoteType.VOTE_UP) {
            discoveryCopy.setUpVote(discoveryCopy.getUpVote() + 1);
        } else if (voteType == VoteType.VOTE_DOWN) {
            discoveryCopy.setDownVote(discoveryCopy.getDownVote() + 1);
        }
        return discoveryCopy;
    }

    private Discovery removeDiscoveryVote(Discovery discovery, VoteType voteType) {
        Discovery discoveryCopy = new Discovery(discovery);
        if (voteType == VoteType.VOTE_UP) {
            discoveryCopy.setUpVote(discoveryCopy.getUpVote() - 1);
        } else if (voteType == VoteType.VOTE_DOWN) {
            discoveryCopy.setDownVote(discoveryCopy.getDownVote() - 1);
        }
        return discoveryCopy;
    }
}
