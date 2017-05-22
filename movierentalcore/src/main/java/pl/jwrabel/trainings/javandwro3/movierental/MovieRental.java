package pl.jwrabel.trainings.javandwro3.movierental;

import pl.jwrabel.trainings.javandwro3.movierental.exceptions.MovieAlreadyExistsException;
import pl.jwrabel.trainings.javandwro3.movierental.exceptions.NullCustomerException;
import pl.jwrabel.trainings.javandwro3.movierental.exceptions.NullMovieException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubwrabel on 22/05/2017.
 */
public class MovieRental {
	private List<Customer> customers;
	private List<Rent> rents;
	private List<Movie> movies;

	public MovieRental() {
		this.customers = new ArrayList<>();
		this.rents = new ArrayList<>();
		this.movies = new ArrayList<>();
	}

	public void addCustomer(Customer customer) throws NullCustomerException {
		if (customer == null) {
			throw new NullCustomerException();
		}

		customers.add(customer);
	}

	public void addMovie(Movie movie) throws NullMovieException, MovieAlreadyExistsException {
		if (movie == null) {
			throw new NullMovieException();
		}

		if(movies.contains(movie)){
			throw new MovieAlreadyExistsException();
		}

		movies.add(movie);
	}

	public void addRent(Rent rent){
		// TODO handle errors
		rents.add(rent);
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
}
