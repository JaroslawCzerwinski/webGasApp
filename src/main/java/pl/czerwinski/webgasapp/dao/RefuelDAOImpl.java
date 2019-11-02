package pl.czerwinski.webgasapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import pl.czerwinski.webgasapp.model.Refuel;
import pl.czerwinski.webgasapp.util.ConnectionProvider;

public class RefuelDAOImpl implements RefuelDAO {

	private static final String CREATE_NEW_REFUEL = "INSERT INTO refueling_data(distance, date, lpg_amount, lpg_price, petrol_amount, petrol_price, paid, saiving, gas_efficiency, user_id) "
			+ "VALUES(:distance, :date, :lpg_amount, :lpg_price, :petrol_amount, :petrol_price, :paid, :saiving, :gas_efficiency, :user_id);";

	private static final String READ_REFUELING_BY_USERNAME = "SELECT refueling_id, distance, date, lpg_amount, lpg_price, petrol_amount, petrol_price, paid, saiving, gas_efficiency FROM refueling_data r LEFT JOIN user u ON r.user_id = u.user_id WHERE username=:username";

	private static final String DELETE_REFUEL_BY_ID = "DELETE FROM refueling_data WHERE refueling_id=:refueling_id";
;
	
	private NamedParameterJdbcTemplate template;

	public RefuelDAOImpl() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}

	@Override
	public Refuel create(Refuel refuel) {
		Refuel resultRefuel = new Refuel(refuel);
		KeyHolder holder = new GeneratedKeyHolder();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("distance", refuel.getDistance());
		paramMap.put("date", refuel.getDate());
		paramMap.put("lpg_amount", refuel.getLpgAmount());
		paramMap.put("lpg_price", refuel.getLpgPrice());
		paramMap.put("petrol_amount", refuel.getPetrolAmount());
		paramMap.put("petrol_price", refuel.getPetrolPrice());
		paramMap.put("paid", refuel.getPaid());
		paramMap.put("saiving", refuel.getSaiving());
		paramMap.put("gas_efficiency", refuel.getGasEfficiency());
		paramMap.put("user_id", refuel.getUser().getId());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int update = template.update(CREATE_NEW_REFUEL, paramSource, holder);
		if (update > 0) {
			resultRefuel.setId(holder.getKey().longValue());
		}
		return resultRefuel;
	}

	@Override
	public Refuel read(Long primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Refuel updateObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Refuel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Refuel> getRefuelByUsername(String username) {
		SqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		List<Refuel> refueling = template.query(READ_REFUELING_BY_USERNAME, paramSource, new RefuelRowMapper());
		return refueling;
	}
	private class RefuelRowMapper implements RowMapper<Refuel> {
		@Override
		public Refuel mapRow(ResultSet resultSet, int row) throws SQLException {
			Refuel refuel = new Refuel();
			refuel.setId(resultSet.getLong("refueling_id"));
			refuel.setDistance(resultSet.getInt("distance"));
			refuel.setDate(resultSet.getString("date"));
			refuel.setLpgAmount(resultSet.getDouble("lpg_amount"));
			refuel.setLpgPrice(resultSet.getDouble("lpg_price"));
			refuel.setPetrolAmount(resultSet.getDouble("petrol_amount"));
			refuel.setPetrolPrice(resultSet.getDouble("petrol_price"));
			refuel.setPaid(resultSet.getDouble("paid"));
			refuel.setSaiving(resultSet.getDouble("saiving"));
			refuel.setGasEfficiency(resultSet.getDouble("gas_efficiency"));
			
			return refuel;
		}
	}
	@Override
	public void deleteRefuelById(long refuelId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("refueling_id", refuelId);
		template.update(DELETE_REFUEL_BY_ID, paramSource);
		
	}
	
}
