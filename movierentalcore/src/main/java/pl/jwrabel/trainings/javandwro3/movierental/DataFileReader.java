package pl.jwrabel.trainings.javandwro3.movierental;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubwrabel on 22/05/2017.
 */
public class DataFileReader {
	public static List<Customer> readCustomersFromFile(String fileName) {
		List<Customer> customers = new ArrayList<>();

		try {

			List<String> fileLines = Files.readLines(new File(fileName), Charsets.UTF_8);

			for (String line : fileLines) {
				Customer customer = new Customer(line);
				customers.add(customer);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return customers;
	}
}
