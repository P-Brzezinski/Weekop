package pl.brzezinski.weekop.dao;

import pl.brzezinski.weekop.model.Vote;

public interface VoteDAO extends GenericDAO<Vote, Long> {

    public Vote getVoteByUserIdDiscovery(long userId, long discoveryId);
}
