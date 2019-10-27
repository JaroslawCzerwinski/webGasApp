package pl.czerwinski.webgasapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import pl.czerwinski.webgasapp.model.User;
import pl.czerwinski.webgasapp.util.ConnectionProvider;

public class UserDAOImpl implements UserDAO {

	private static final String CREATE_USER = "INSERT INTO user(username, password) VALUES(:username, :password);";

	private static final String READ_USER = "SELECT user_id, username, password FROM user WHERE user_id = :id";

	private static final String READ_USER_BY_USERNAME = "SELECT user_id, username, password, total_saiving, total_cost, cost_100km, average_consumption_100km  FROM user WHERE username = :username";

	private static final String UPDATE_USER_STATISTIC = "UPDATE user SET total_saiving=:total_saiving, total_cost=:total_cost, cost_100km=:cost_100km, average_consumption_100km=:average_consumption_100km "
			+ "WHERE username=:username;";

	private NamedParameterJdbcTemplate template;

	public UserDAOImpl() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}

	@Override
	public User create(User user) {
		User resultUser = new User(user);
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		int update = template.update(CREATE_USER, paramSource, holder);
		if (update > 0) {
			resultUser.setId(holder.getKey().longValue());
			setPrivigiles(resultUser);
		}
		return resultUser;
	}

	private void setPrivigiles(User user) {
		final String userRoleQuery = "INSERT INTO user_role(username) VALUES(:username)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		template.update(userRoleQuery, paramSource);
	}

	@Override
	public User read(Long primaryKey) {
		User resultUser = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("id", primaryKey);
		resultUser = template.queryForObject(READ_USER, paramSource, new UserRowMapper());
		return resultUser;
	}

	@Override
	public void updateUserStatistic(String username, User user) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("username", username);
		paramMap.put("total_saiving", user.getTotalSaiving());
		paramMap.put("total_cost", user.getTotalCost());
		paramMap.put("cost_100km", user.getCost100Km());
		paramMap.put("average_consumption_100km", user.getAverageConsumption100Km());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		template.update(UPDATE_USER_STATISTIC, paramSource);

	}

	@Override
	public User getUserByUsername(String username) {
		User resultUser = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		resultUser = template.queryForObject(READ_USER_BY_USERNAME, paramSource, new UserRowMapper());
		return resultUser;
	}

	@Override
	public boolean update(User updateObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	private class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			User user = new User();
			user.setId(resultSet.getLong("user_id"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setTotalCost(resultSet.getDouble("total_cost"));
			user.setTotalSaiving(resultSet.getDouble("total_saiving"));
			user.setAverageConsumption100Km(resultSet.getDouble("average_consumption_100km"));
			user.setCost100Km(resultSet.getDouble("cost_100km"));
			return user;
		}

	}

}
