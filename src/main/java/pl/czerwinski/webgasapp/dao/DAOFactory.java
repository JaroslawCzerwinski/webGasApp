package pl.czerwinski.webgasapp.dao;


public abstract class DAOFactory {
	
	public abstract RefuelDAO getRefuelDAO();

	public abstract UserDAO getUserDAO();

}
