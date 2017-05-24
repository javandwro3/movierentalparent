package pl.jwrabel.trainings.javandwro3.movierental;

import pl.jwrabel.trainings.javandwro3.movierental.exceptions.MovieAlreadyExistsException;
import pl.jwrabel.trainings.javandwro3.movierental.exceptions.NullCustomerException;
import pl.jwrabel.trainings.javandwro3.movierental.exceptions.NullMovieException;
import pl.jwrabel.trainings.javandwro3.movierental.factory.CustomerFactory;
import pl.jwrabel.trainings.javandwro3.movierental.factory.MovieFactory;
import pl.jwrabel.trainings.javandwro3.movierental.factory.RentFactory;
import pl.jwrabel.trainings.javandwro3.movierental.io.DataFileReader;
import pl.jwrabel.trainings.javandwro3.movierental.io.DataFileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubwrabel on 22/05/2017.
 * <p>
 * Klasa reprezentująca wypożyczalnię filmów, przechowuje listę klientów, listę filmów i listę wypożyczeń
 */
public class MovieRental {
	private List<Customer> customers;
	private List<Rent> rents;
	private List<Movie> movies;

	/***
	 * Konstruktor tworzący obiekt klasy {@link MovieRental}
	 * Dodatkowo wczytuje dane klientów, filmów i wypożyczeń z plików i "ustawia" w wypożyczalni
	 */
	public MovieRental() {
		this.rents = new ArrayList<>();
		this.movies = new ArrayList<>();

		readDataFromFile();
	}

	/***
	 * Metoda wczytująca dane z pliku (klientów, wypożyczenia, filmy) i ustawiająca te dane jako pola klasy {@link MovieRental}
	 * (listy customers, movies, rents)
	 */
	private void readDataFromFile() {
		DataFileReader<Customer> customerDataFileReader = new DataFileReader<>(new CustomerFactory());

		try {
			this.customers = customerDataFileReader.readFromFile("customers.csv");
		} catch (IOException e) {
			System.err.println("Błąd podczas wczytywania klientów z pliku");
			this.customers = new ArrayList<>();
		}

		// Inny sposób na ustawienie kolejnego nextId
		if (!customers.isEmpty()) {
			int maxId = this.customers.stream().mapToInt(x -> x.getId()).summaryStatistics().getMax();
			Customer.setNextId(maxId + 1);
		}

		DataFileReader<Movie> movieDataFileReader = new DataFileReader<>(new MovieFactory());

		try {
			this.movies = movieDataFileReader.readFromFile("movies.csv");
		} catch (IOException e) {
			System.err.println("Błąd podczas wczytywania filmów z pliku");
			this.movies = new ArrayList<>();
		}

		DataFileReader<Rent> rentDataFileReader = new DataFileReader<>(new RentFactory());

		try {
			this.rents = rentDataFileReader.readFromFile("rents.csv");
		} catch (IOException e) {
			System.err.println("Błąd podczas wczytywania wypożyczeń z pliku");
			this.rents = new ArrayList<>();
		}
	}

	/***
	 * Metoda do dodawania nowego klienta do wypożyczalni, przyjmuje obiekt klasy {@link Customer}
	 * (dodaje nowego klienta do listy customers)
	 * dodatkowo po dodaniu zapisuje wszystkich klientów do pliku
	 */
	public void addCustomer(Customer customer) throws NullCustomerException {
		if (customer == null) {
			throw new NullCustomerException();
		}

		customers.add(customer);
		saveCustomersToFile();
	}

	/***
	 * Metoda do dodawania nowego filmu do wypożyczalni, przyjmuje obiekt klasy {@link Movie}
	 * (dodaje nowy film do listy movies)
	 * dodatkowo po dodaniu zapisuje wszystkie filmy do pliku
	 */
	public void addMovie(Movie movie) throws NullMovieException, MovieAlreadyExistsException {
		if (movie == null) {
			throw new NullMovieException();
		}

		if (movies.contains(movie)) {
			throw new MovieAlreadyExistsException();
		}

		movies.add(movie);
		saveMoviesToFile();
	}

	/***
	 * Metoda do dodawania wypożyczenia do wypożyczalni, przyjmuje obiekt klasy {@link Rent}
	 * (dodaje nowego klienta do listy rents)
	 * dodatkowo po dodaniu zapisuje dane wszystkie wypożyczenia do pliku
	 */
	public void addRent(Rent rent) {
		// TODO handle errors
		rents.add(rent);
		saveRentsToFile();
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public List<Rent> getRents() {
		return rents;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	/***
	 * Metoda wypisująca wszystkie dane wypożyczalni
	 */
	public void printAllData() {
		System.out.println("====== WYPOŻYCZALNIA =====");
		System.out.println("--- CUSTOMERS ---");
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		System.out.println("--- MOVIES ---");
		for (Movie movie : movies) {
			System.out.println(movie);
		}

		System.out.println("--- RENTS ---");
		for (Rent rent : rents) {
			System.out.println(rent);
		}
		System.out.println("==========================");
	}

	/***
	 * Metoda zapisująca wszystkich klientów do pliku customers.csv
	 */
	public void saveCustomersToFile() {
		DataFileWriter.writeObjectToFile("customers.csv", customers);
	}

	/***
	 * Metoda zapisująca wszystkie filmy do pliku movies.csv
	 */
	public void saveMoviesToFile() {
		DataFileWriter.writeObjectToFile("movies.csv", movies);
	}

	/***
	 * Metoda zapisująca wszystkie wypożyczenia do pliku rents.csv
	 */
	public void saveRentsToFile() {
		DataFileWriter.writeObjectToFile("rents.csv", rents);
	}
}
