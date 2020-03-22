package pl.brzezinski.weekop.dao.factory;

import pl.brzezinski.weekop.dao.DiscoveryDAO;
import pl.brzezinski.weekop.dao.UserDAO;
import pl.brzezinski.weekop.dao.VoteDAO;
import pl.brzezinski.weekop.dao.impl.DiscoveryDAOImpl;
import pl.brzezinski.weekop.dao.impl.UserDAOImpl;
import pl.brzezinski.weekop.dao.impl.VoteDAOImpl;

public class MysqlDAOFactory extends DAOFactory {

    @Override
    public DiscoveryDAO getDiscoveryDAO() {
        return new DiscoveryDAOImpl();
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public VoteDAO getVoteDAO() {
        return new VoteDAOImpl();
    }
}
