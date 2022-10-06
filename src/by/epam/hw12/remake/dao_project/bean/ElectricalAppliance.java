package by.epam.hw12.remake.dao_project.bean;

import java.io.Serializable;

public abstract class ElectricalAppliance implements Serializable{

	private static final long serialVersionUID = -7725678842049705861L;
	
	private String brand;

	public ElectricalAppliance() {

	}

	public ElectricalAppliance(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
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
		ElectricalAppliance other = (ElectricalAppliance) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ElectricalAppliance [brand=" + brand + "]";
	}

}
