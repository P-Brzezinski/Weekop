package pl.brzezinski.weekop.controller;

import pl.brzezinski.weekop.model.Discovery;
import pl.brzezinski.weekop.service.DiscoveryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        saveDiscoveriesInRequest(req);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    private void saveDiscoveriesInRequest(HttpServletRequest request) {
        DiscoveryService discoveryService = new DiscoveryService();
        List<Discovery> allDiscoveries = discoveryService.getAllDiscoveries(new Comparator<Discovery>() {
            //more votes = higher
            @Override
            public int compare(Discovery d1, Discovery d2) {
                int d1Vote = d1.getUpVote() - d1.getDownVote();
                int d2Vote = d2.getUpVote() - d2.getDownVote();
                if (d1Vote < d2Vote) {
                    return 1;
                } else if (d1Vote > d2Vote) {
                    return -1;
                }
                return 0;
            }
        });
        request.setAttribute("discoveries", allDiscoveries);
    }
}
