package pl.czerwinski.webgasapp.model;

public class User {
	private long id;
	private String username;
	private String password;
	private Double totalSaiving;
	private Double totalCost;
	private Double cost100Km;
	private Double averageConsumption100Km;

	public User() {
	}

	public User(String username) {
		this.username = username;
	}

	public User(User user) {
		this.id = user.id;
		this.username = user.username;
		this.password = user.password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getTotalSaiving() {
		return totalSaiving;
	}

	public void setTotalSaiving(Double totalSaiving) {
		this.totalSaiving = totalSaiving;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Double getCost100Km() {
		return cost100Km;
	}

	public void setCost100Km(Double cost100Km) {
		this.cost100Km = cost100Km;
	}

	public Double getAverageConsumption100Km() {
		return averageConsumption100Km;
	}

	public void setAverageConsumption100Km(Double averageConsumption100Km) {
		this.averageConsumption100Km = averageConsumption100Km;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", totalCost=" + totalCost
				+ ", totalSaiving=" + totalSaiving + ", cost/100km=" + cost100Km + ", averageConsumption100Km="
				+ averageConsumption100Km;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost100Km == null) ? 0 : cost100Km.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((averageConsumption100Km == null) ? 0 : averageConsumption100Km.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
		result = prime * result + ((totalSaiving == null) ? 0 : totalSaiving.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (cost100Km == null) {
			if (other.cost100Km != null)
				return false;
		} else if (!cost100Km.equals(other.cost100Km))
			return false;
		if (id != other.id)
			return false;
		if (averageConsumption100Km == null) {
			if (other.averageConsumption100Km != null)
				return false;
		} else if (!averageConsumption100Km.equals(other.averageConsumption100Km))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		if (totalSaiving == null) {
			if (other.totalSaiving != null)
				return false;
		} else if (!totalSaiving.equals(other.totalSaiving))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
