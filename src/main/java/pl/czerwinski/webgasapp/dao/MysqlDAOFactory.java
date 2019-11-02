package pl.czerwinski.webgasapp.dao;

public class MysqlDAOFactory extends DAOFactory {

	@Override
	public RefuelDAO getRefuelDAO() {
		return new RefuelDAOImpl();
	}

	@Override
	public UserDAO getUserDAO() {
		return new UserDAOImpl();
	}

}
