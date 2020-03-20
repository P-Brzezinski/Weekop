package pl.brzezinski.weekop.dao.impl;

import pl.brzezinski.weekop.dao.VoteDAO;
import pl.brzezinski.weekop.model.Vote;

import java.util.List;

public class VoteDAOImpl implements VoteDAO {

    @Override
    public Vote getVoteByUserIdDiscovery(long userId, long discoveryId) {
        return null;
    }

    @Override
    public Vote create(Vote newObject) {
        return null;
    }

    @Override
    public Vote read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(Vote updateObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    @Override
    public List<Vote> getAll() {
        return null;
    }
}
