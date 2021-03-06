package pl.czerwinski.webgasapp.service;

import java.util.Comparator;
import java.util.List;

import pl.czerwinski.webgasapp.dao.DAOFactory;
import pl.czerwinski.webgasapp.dao.RefuelDAO;
import pl.czerwinski.webgasapp.model.Refuel;
import pl.czerwinski.webgasapp.model.User;

public class RefuelService {
	public void addRefuel(int distance, String date, double lpgAmount, double lpgPrice, double petrolAmount,
			double petrolPrice, double gasEfficiency, User user) {
		Refuel refuel = createRefuelObject(distance, date, lpgAmount, lpgPrice, petrolAmount, petrolPrice,
				gasEfficiency, user);
		DAOFactory factory = DAOFactory.getDAOFactory();
		RefuelDAO refuelDao = factory.getRefuelDAO();
		refuelDao.create(refuel);
	}

	private Refuel createRefuelObject(int distance, String date, double lpgAmount, double lpgPrice, double petrolAmount,
			double petrolPrice, double gasEfficiency, User user) {
		Refuel refuel = new Refuel();
		User userCopy = new User(user);
		Double calculatePaid = calculatePaid(lpgAmount, lpgPrice, petrolAmount, petrolPrice);
		Double calculateSaiving = calculateSaiving(lpgAmount, lpgPrice, petrolPrice, gasEfficiency);
		
		refuel.setDistance(distance);
		refuel.setDate(date);
		refuel.setLpgAmount(lpgAmount);
		refuel.setLpgPrice(lpgPrice);
		refuel.setPetrolAmount(petrolAmount);
		refuel.setPetrolPrice(petrolPrice);
		refuel.setGasEfficiency(gasEfficiency);
		refuel.setPaid(calculatePaid);
		refuel.setSaiving(calculateSaiving);
		refuel.setUser(userCopy);
		return refuel;
	}
	
	public List<Refuel> getRefuelsByUsername(Comparator<Refuel> comparator, String username) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		RefuelDAO refuelDao = factory.getRefuelDAO();
		List<Refuel> refuels = refuelDao.getRefuelByUsername(username);
		if(comparator != null && refuels != null) {
			refuels.sort(comparator);
		}
		return refuels;
	}
	
	private Double calculatePaid(double lpgAmount, double lpgPrice, double petrolAmount, double petrolPrice) {
		double paid = ((lpgAmount * lpgPrice) + (petrolAmount * petrolPrice));
		return paid;
	}

	private Double calculateSaiving(double lpgAmount, double lpgPrice, double petrolPrice,
			double gasEfficiency) {
		double saiving = (((gasEfficiency/100) * lpgAmount * petrolPrice) - (lpgAmount * lpgPrice));
		return saiving;
	}

	public void deleteRefuelById(long refuelId) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		RefuelDAO refuelDao = factory.getRefuelDAO();
		refuelDao.deleteRefuelById(refuelId);
		
	}

}
