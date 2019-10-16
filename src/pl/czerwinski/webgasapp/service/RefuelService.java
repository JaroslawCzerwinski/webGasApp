package pl.czerwinski.webgasapp.service;

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
		refuel.setGasEfficiency(gasEfficiency/100);
		refuel.setPaid(calculatePaid);
		refuel.setSaiving(calculateSaiving);
		refuel.setUser(userCopy);
		return refuel;
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

}
