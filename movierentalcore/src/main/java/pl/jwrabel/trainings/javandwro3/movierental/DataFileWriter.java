package pl.jwrabel.trainings.javandwro3.movierental;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jakubwrabel on 22/05/2017.
 */
public class DataFileWriter {
	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("1234", "Adam", "Miauczyński", "Wroclaw", new Date()));
		customers.add(new Customer("23245", "Jan", "Nowak", "Wroclaw", new Date()));

		writeCustomersToFile("customers.csv", customers);
	}

	public static void writeCustomersToFile(String fileName, List<Customer> customers) {
		try {
			FileWriter fileWriter = new FileWriter(fileName);

			for (Customer customer : customers) {
				fileWriter.write(customer.toCSVString() + System.lineSeparator());
				// prawie to samo co:
//				fileWriter.write(customer.toCSVString() + "\n");
			}

			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
