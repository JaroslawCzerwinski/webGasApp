package pl.czerwinski.webgasapp.service;

import java.util.List;

import pl.czerwinski.webgasapp.dao.DAOFactory;
import pl.czerwinski.webgasapp.dao.RefuelDAO;
import pl.czerwinski.webgasapp.dao.UserDAO;
import pl.czerwinski.webgasapp.model.Refuel;
import pl.czerwinski.webgasapp.model.User;

public class UserService {
	public void addUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		userDao.create(user);
	}

	public User getUserById(long userId) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		User user = userDao.read(userId);
		return user;
	}

	public User getUserByUsername(String username) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		User user = userDao.getUserByUsername(username);
		return user;
	}

	public void calculateStatisticByUsername(String username) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		RefuelDAO refuelDao = factory.getRefuelDAO();
		UserDAO userDao = factory.getUserDAO();
		List<Refuel> refuels = refuelDao.getRefuelByUsername(username);
		User calculateResult = calculateSatistic(refuels);
		userDao.updateUser(calculateResult); // Zrobi� zapisywanie statystyk do BD
	}

	private User calculateSatistic(List<Refuel> refuels) {
		User result = new User();
		result.setTotalCost(totalCost(refuels));
		result.setTotalSaiving(totalSaiving(refuels));
		result.setLpg100Km(averageConsumption(refuels)); // �rednie spalanie, a nie �rednie spalanie LPG do poprawy
		result.setCost100Km(averageCost100Km(refuels));
		return result;

	}

	private Double totalCost(List<Refuel> refuels) {
		Double totalCost = 0.00;
		for (int i = 0; i < refuels.size(); i++) {
			Refuel refuelCost = refuels.get(i);
			totalCost += refuelCost.getPaid();
		}

		return totalCost;

	}

	private Double totalSaiving(List<Refuel> refuels) {
		Double totalSaving = 0.00;
		for (int i = 0; i < refuels.size(); i++) {
			Refuel saiving = refuels.get(i);
			totalSaving += saiving.getSaiving();
		}
		return totalSaving;

	}

	private Double averageConsumption(List<Refuel> refuels) {
		Double averageLPGConsumption = 0.00;
		Double totalLPGAmount = 0.00;
		Double totalPetrolAmount = 0.00;

		for (int i = 0; i < refuels.size(); i++) {
			Refuel lPGAmount = refuels.get(i);
			totalLPGAmount += lPGAmount.getLpgAmount();
		}

		for (int i = 0; i < refuels.size(); i++) {
			Refuel petrolAmount = refuels.get(i);
			totalPetrolAmount += petrolAmount.getPetrolAmount();
		}

		int firstDistance = refuels.get(1).getDistance();
		int lastDistance = refuels.get(refuels.size() - 1).getDistance();

		averageLPGConsumption = (totalLPGAmount + totalPetrolAmount) / (lastDistance - firstDistance) * 100;

		return averageLPGConsumption;

	}

	private Double averageCost100Km(List<Refuel> refuels) {
		Double averageCost100Km = 0.00;
		Double totalCost = 0.00;

		for (int i = 0; i < refuels.size(); i++) {
			Refuel refuelCost = refuels.get(i);
			totalCost += refuelCost.getPaid();
		}

		int firstDistance = refuels.get(1).getDistance();
		int lastDistance = refuels.get(refuels.size() - 1).getDistance();

		averageCost100Km = totalCost / (lastDistance - firstDistance);

		return averageCost100Km;

	}

}
