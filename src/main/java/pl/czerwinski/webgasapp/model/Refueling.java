package pl.czerwinski.webgasapp.model;

import pl.czerwinski.webgasapp.model.User;

import java.sql.Timestamp;

public class Refueling {
	private long id;
	private int distance;
	private Timestamp date;
	private double lpgAmount;
	private double lpgPrice;
	private double petrolAmount;
	private double petrolPrice;
	private double paid;
	private double saiving;
	private double gasEfficiency;
	private User userId;

	public Refueling() {
	}

	public Refueling(Refueling refueling) {
		this.id = refueling.id;
		this.distance = refueling.distance;
		this.date = new Timestamp(refueling.date.getTime());
		this.lpgAmount = refueling.lpgAmount;
		this.lpgPrice = refueling.lpgPrice;
		this.petrolAmount = refueling.petrolAmount;
		this.petrolPrice = refueling.petrolPrice;
		this.paid = refueling.paid;
		this.saiving = refueling.saiving;
		this.gasEfficiency = refueling.gasEfficiency;
		this.userId = new User(refueling.userId);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public double getLpgAmount() {
		return lpgAmount;
	}

	public void setLpgAmount(double lpgAmount) {
		this.lpgAmount = lpgAmount;
	}

	public double getLpgPrice() {
		return lpgPrice;
	}

	public void setLpgPrice(double lpgPrice) {
		this.lpgPrice = lpgPrice;
	}

	public double getPetrolAmount() {
		return petrolAmount;
	}

	public void setPetrolAmount(double petrolAmount) {
		this.petrolAmount = petrolAmount;
	}

	public double getPetrolPrice() {
		return petrolPrice;
	}

	public void setPetrolPrice(double petrolPrice) {
		this.petrolPrice = petrolPrice;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}

	public double getSaiving() {
		return saiving;
	}

	public void setSaiving(double saiving) {
		this.saiving = saiving;
	}

	public double getGasEfficiency() {
		return gasEfficiency;
	}

	public void setGasEfficiency(double gasEfficiency) {
		this.gasEfficiency = gasEfficiency;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Discovery [id=" + id + ", distance=" + distance + ", date=" + date + ", lpgAmount=" + lpgAmount
				+ ", lpgPrice=" + lpgPrice + ", petrolAmount=" + petrolAmount + ", petrolPrcie=" + petrolPrice
				+ ", paid=" + paid + ", saiving=" + saiving + ", gasEfficiency=" + gasEfficiency + ", userId=" + userId
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + distance;
		long temp;
		temp = Double.doubleToLongBits(gasEfficiency);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		temp = Double.doubleToLongBits(lpgAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lpgPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(paid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(petrolAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(petrolPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saiving);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Refueling other = (Refueling) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (distance != other.distance)
			return false;
		if (Double.doubleToLongBits(gasEfficiency) != Double.doubleToLongBits(other.gasEfficiency))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(lpgAmount) != Double.doubleToLongBits(other.lpgAmount))
			return false;
		if (Double.doubleToLongBits(lpgPrice) != Double.doubleToLongBits(other.lpgPrice))
			return false;
		if (Double.doubleToLongBits(paid) != Double.doubleToLongBits(other.paid))
			return false;
		if (Double.doubleToLongBits(petrolAmount) != Double.doubleToLongBits(other.petrolAmount))
			return false;
		if (Double.doubleToLongBits(petrolPrice) != Double.doubleToLongBits(other.petrolPrice))
			return false;
		if (Double.doubleToLongBits(saiving) != Double.doubleToLongBits(other.saiving))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
