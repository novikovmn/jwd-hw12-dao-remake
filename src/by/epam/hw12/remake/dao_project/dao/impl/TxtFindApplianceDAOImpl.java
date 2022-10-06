package by.epam.hw12.remake.dao_project.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import by.epam.hw12.remake.dao_project.bean.ElectricalAppliance;
import by.epam.hw12.remake.dao_project.bean.Laptop;
import by.epam.hw12.remake.dao_project.bean.Oven;
import by.epam.hw12.remake.dao_project.dao.FindApplianceDAO;
import by.epam.hw12.remake.dao_project.entity.Property;

public final class TxtFindApplianceDAOImpl implements FindApplianceDAO {

	private static final TxtFindApplianceDAOImpl instance = new TxtFindApplianceDAOImpl();

	private TxtFindApplianceDAOImpl() {
	}

	public static TxtFindApplianceDAOImpl getInstance() {
		return instance;
	}

	private final File txtFile = new File("data" + File.separator + "appliance_db.txt");
	private final Pattern pattern = Pattern.compile(PATTERN);

	@Override
	public List<ElectricalAppliance> find(Property property) {

		List<ElectricalAppliance> result = new ArrayList<>();
		
		//////////////////////////////////////////////////////////////////////
		
		// извлекаем параметры вида "свойство=значение"
		
		List<String> properties = new ArrayList<>();

		Set<Entry<String, Object>> entrySet = property.getProperties().entrySet();
		for (Entry<String, Object> entry : entrySet) {
			properties.add(entry.getKey() + "=" + entry.getValue());
		}
		/////////////////////////////////////////////////////////////////////////////
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(txtFile))) {

			// вычитываем весь файл в лист строк
			List<String> allLines = bufferedReader.lines().collect(Collectors.toList());

			// убираем из вычитанного листа лишние строки (т.е. категории)
			for (int i = 0; i < allLines.size(); i++) {
				if (!(allLines.get(i).startsWith(property.getCategoryName()))) {
					allLines.remove(allLines.get(i));
				}
			}

			// проходка по оставшимся строкам (категориям)
			for (int i = 0; i < allLines.size(); i++) {

				int flag = 0;
				String line = allLines.get(i);

				// проверяем, содержит ли строка все нужные характеристики
				for (int j = 0; j < properties.size(); j++) {
					if (line.contains(properties.get(j))) {
						flag++;
					}
				}
				
				// если строка содержит все нужные свойства - приступаем к превращению этой строки в объект
				Matcher matcher = pattern.matcher(line);
				int index = 0;
				if (flag == properties.size()) {
					// в зависимости от категории товаров собираем объект нужного типа
					switch (property.getCategoryName()) {
					case OVEN_CATEGORY:

						Oven oven;
						String[] ovenProperties = new String[OVEN_PROPERTY_LENGTH];

						while (matcher.find()) {
							ovenProperties[index++] = matcher.group().split("=")[1];
						}
						
						// собрали объект нужного типа 
						oven = new Oven(ovenProperties[0], Double.parseDouble(ovenProperties[1]),
								Integer.parseInt(ovenProperties[2]));
						// добавляем его в результирующий список
						result.add(oven);
						break;
					case LAPTOP_CATEGORY:
						Laptop laptop;
						String[] laptopProperties = new String[LAPTOP_PROPERTY_LENGTH];

						while (matcher.find()) {
							laptopProperties[index++] = matcher.group().split("=")[1];
						}

						// собрали объект нужного типа
						laptop = new Laptop(laptopProperties[0], Double.parseDouble(laptopProperties[1]),
								laptopProperties[2], Integer.parseInt(laptopProperties[3]),
								Boolean.parseBoolean(laptopProperties[4]));
						// добавляем его в результирующий список
						result.add(laptop);
						break;
					}
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;

	}

}
