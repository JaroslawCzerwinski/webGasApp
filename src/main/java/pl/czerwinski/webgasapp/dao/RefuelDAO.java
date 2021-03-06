package pl.czerwinski.webgasapp.dao;

import java.util.List;

import pl.czerwinski.webgasapp.model.Refuel;

public interface RefuelDAO extends GenericDAO<Refuel, Long> {

	List<Refuel> getAll();
	List<Refuel> getRefuelByUsername(String username);
	void deleteRefuelById(long refuelId);
}