package pl.jwrabel.trainings.javandwro3.movierental;

import org.junit.Test;
import pl.jwrabel.trainings.javandwro3.movierental.exceptions.NullCustomerException;
import pl.jwrabel.trainings.javandwro3.movierental.exceptions.NullMovieException;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jakubwrabel on 22/05/2017.
 */
public class MovieRentalTest {
	@Test
	public void addCustomer_correctCase() throws NullCustomerException {
		// given
		MovieRental movieRental = new MovieRental();
		Customer customer = new Customer("123", "Adam", "Kowalski", "Wrocław", new Date());

		// when
		movieRental.addCustomer(customer);

		// then
		assertEquals(1, movieRental.getCustomers().size());
		assertTrue(movieRental.getCustomers().contains(customer));
	}

	@Test(expected = NullCustomerException.class)
	public void addCustomer_nullCustomer() throws NullCustomerException {
		// given
		MovieRental movieRental = new MovieRental();
		Customer customer = null;

		// when
		movieRental.addCustomer(customer);
	}

	@Test
	public void addMovie_correctCase() throws NullMovieException {
		// given
		MovieRental movieRental = new MovieRental();
		Movie movie = new Movie("Action", "Terminator", "bla");

		// when
		movieRental.addMovie(movie);

		// then
		assertEquals(1, movieRental.getMovies().size());
		assertTrue(movieRental.getMovies().contains(movie));
	}

	@Test(expected = NullMovieException.class)
	public void addMovie_nullMovie() throws NullMovieException {
		// given
		MovieRental movieRental = new MovieRental();
		Movie movie = null;

		// when
		movieRental.addMovie(movie);
	}

}