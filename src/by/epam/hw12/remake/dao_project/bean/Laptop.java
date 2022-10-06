package by.epam.hw12.remake.dao_project.bean;

import java.io.Serializable;

public class Laptop extends ElectricalAppliance implements Serializable{

	private static final long serialVersionUID = -4169354195872969274L;
	
	private double displayInch;
	private String operatingSystem;
	private int ram;
	private boolean cardReader;

	public Laptop() {
		super();
	}

	public Laptop(String brand, double displayInch, String operatingSystem, int ram, boolean cardReader) {
		super(brand);
		this.displayInch = displayInch;
		this.operatingSystem = operatingSystem;
		this.ram = ram;
		this.cardReader = cardReader;
	}

	public double getDisplayInch() {
		return displayInch;
	}

	public void setDisplayInch(double displayInch) {
		this.displayInch = displayInch;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public boolean isCardReader() {
		return cardReader;
	}

	public void setCardReader(boolean cardReader) {
		this.cardReader = cardReader;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (cardReader ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(displayInch);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((operatingSystem == null) ? 0 : operatingSystem.hashCode());
		result = prime * result + ram;
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
		Laptop other = (Laptop) obj;
		if (cardReader != other.cardReader)
			return false;
		if (Double.doubleToLongBits(displayInch) != Double.doubleToLongBits(other.displayInch))
			return false;
		if (operatingSystem == null) {
			if (other.operatingSystem != null)
				return false;
		} else if (!operatingSystem.equals(other.operatingSystem))
			return false;
		if (ram != other.ram)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Laptop : BRAND=" + this.getBrand() + ", DISPLAY_INCH=" + displayInch + ", OS=" + operatingSystem + ", RAM=" + ram
				+ ", CARD_READER=" + cardReader;
	}

}
