package by.epam.hw12.remake.dao_project.main;

import by.epam.hw12.remake.dao_project.bean.Laptop;
import by.epam.hw12.remake.dao_project.dao.impl.TxtFindApplianceDAOImpl;
import by.epam.hw12.remake.dao_project.entity.Property;
import by.epam.hw12.remake.dao_project.entity.SearchProperty;
import by.epam.hw12.remake.dao_project.view.ConsoleOutput;

public class Main {

	public static void main(String[] args) {

		ApplianceDBCreator.writeItemsToFile();

		TxtFindApplianceDAOImpl finder = TxtFindApplianceDAOImpl.getInstance();

		ConsoleOutput output = new ConsoleOutput();

		Property property = new Property(Laptop.class.getSimpleName());
		
//		поиск макбуков с оперативной памятью 16 gb
//		property.addProperty(SearchProperty.Laptop.OS.name(), "MacOS");
//		property.addProperty(SearchProperty.Laptop.RAM.name(), 16);		
		
		// поиск ноутбуков фирмы Asus
		property.addProperty(SearchProperty.Laptop.BRAND.name(), "Asus");

		output.printAppliances(finder.find(property));

	}

}
