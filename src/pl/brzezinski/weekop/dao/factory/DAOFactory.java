package pl.brzezinski.weekop.dao.factory;

import pl.brzezinski.weekop.dao.DiscoveryDAO;
import pl.brzezinski.weekop.dao.UserDAO;
import pl.brzezinski.weekop.dao.VoteDAO;

public abstract class DAOFactory {

    public abstract DiscoveryDAO getDiscoveryDAO();

    public abstract UserDAO getUserDAO();

    public abstract VoteDAO getVoteDAO();

}