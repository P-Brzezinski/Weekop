package pl.brzezinski.weekop.dao;

import pl.brzezinski.weekop.model.Discovery;

import java.util.List;

public interface DiscoveryDAO extends GenericDAO<Discovery, Long> {

    List<Discovery> getAll();
}
