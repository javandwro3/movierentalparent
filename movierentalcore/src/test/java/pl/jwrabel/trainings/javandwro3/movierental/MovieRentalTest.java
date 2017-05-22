package pl.jwrabel.trainings.javandwro3.movierental;

import org.junit.Test;
import pl.jwrabel.trainings.javandwro3.movierental.exceptions.NullCustomerException;

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

}