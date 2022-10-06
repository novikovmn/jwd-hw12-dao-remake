package by.epam.hw12.remake.dao_project.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.epam.hw12.remake.dao_project.bean.ElectricalAppliance;
import by.epam.hw12.remake.dao_project.bean.Laptop;
import by.epam.hw12.remake.dao_project.bean.Oven;

public class ApplianceDBCreator {

	public static void writeItemsToFile() {

		File file = new File("data" + File.separator + "appliance_db.txt");
		FileWriter fileWriter = null;

		try {

			fileWriter = new FileWriter(file);

			List<ElectricalAppliance> appliances = createListOfAppliances();

			for (ElectricalAppliance appliance : appliances) {
				fileWriter.write(appliance.toString() + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	private static List<ElectricalAppliance> createListOfAppliances() {

		List<ElectricalAppliance> appliances = new ArrayList<ElectricalAppliance>();
		appliances.add(new Laptop("Honor", 14.0, "Windows", 8, false));
		appliances.add(new Laptop("Apple", 13.3, "MacOS", 16, false));
		appliances.add(new Laptop("Asus", 13.3, "Windows", 4, true));
		appliances.add(new Laptop("Asus", 15.6, "Windows", 8, true));
		appliances.add(new Laptop("Irbis", 14.0, "Linux", 4, true));
		appliances.add(new Oven("Bosh", 52, 1200));
		appliances.add(new Oven("Tefal", 42, 900));
		appliances.add(new Oven("Gefest", 35, 1000));
		appliances.add(new Oven("Indesit", 47, 1400));
		appliances.add(new Oven("Gefest", 31, 1600));

		return appliances;
	}

}
