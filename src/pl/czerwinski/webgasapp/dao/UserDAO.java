package pl.czerwinski.webgasapp.dao;

import java.util.List;

import pl.czerwinski.webgasapp.model.User;


public interface UserDAO extends GenericDAO<User, Long> {
	
	List<User> getAll();
	User getUserByUsername(String username);
	void updateUser(User calculateResult);

}
