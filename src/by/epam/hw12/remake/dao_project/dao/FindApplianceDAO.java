package by.epam.hw12.remake.dao_project.dao;

import java.util.List;

import by.epam.hw12.remake.dao_project.bean.ElectricalAppliance;
import by.epam.hw12.remake.dao_project.entity.Property;
import by.epam.hw12.remake.dao_project.entity.SearchProperty;


public interface FindApplianceDAO {
	
	String OVEN_CATEGORY = "Oven";
	String LAPTOP_CATEGORY = "Laptop";
	
	int OVEN_PROPERTY_LENGTH = SearchProperty.Oven.values().length; // количество агрументов в конструкторе Oven
	int LAPTOP_PROPERTY_LENGTH = SearchProperty.Laptop.values().length; // количество агрументов в конструкторе Laptop
	
	String PATTERN = "\\w+=\\w+\\.\\w+|\\w+=\\w+"; // для поиска фрагментов вида "property=value"
	
	List<ElectricalAppliance> find(Property properties);	

}
