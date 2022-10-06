package by.epam.hw12.remake.dao_project.view;

import java.util.List;

import by.epam.hw12.remake.dao_project.bean.ElectricalAppliance;

public class ConsoleOutput {

	public void printAppliances(List<ElectricalAppliance> appliances) {
		for (ElectricalAppliance appliance : appliances) {
			System.out.println(appliance);
		}
	}

}
