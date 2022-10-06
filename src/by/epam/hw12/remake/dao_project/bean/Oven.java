package by.epam.hw12.remake.dao_project.bean;

import java.io.Serializable;

public class Oven extends ElectricalAppliance implements Serializable {

	private static final long serialVersionUID = 6506673401261292271L;
	
	private double capacity;
	private int powerConsumtion;

	public Oven() {
		super();
	}

	public Oven(String brand, double capacity, int powerConsumtion) {
		super(brand);
		this.capacity = capacity;
		this.powerConsumtion = powerConsumtion;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public int getPowerConsumtion() {
		return powerConsumtion;
	}

	public void setPowerConsumtion(int powerConsumtion) {
		this.powerConsumtion = powerConsumtion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(capacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + powerConsumtion;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oven other = (Oven) obj;
		if (Double.doubleToLongBits(capacity) != Double.doubleToLongBits(other.capacity))
			return false;
		if (powerConsumtion != other.powerConsumtion)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Oven : BRAND=" + this.getBrand() + ", CAPACITY=" + capacity + ", POWER_CONSUMPTION=" + powerConsumtion;
	}

}
