package pl.jwrabel.trainings.javandwro3.movierental;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by jakubwrabel on 22/05/2017.
 */
public class CustomerTest {
	@Test
	public void toCSVString() throws Exception {
		// given
		Customer customer = new Customer("123", "Adam", "Kowalski", "Wrocław", new Date(0));

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String expectedString = customer.getId() + ",123,Adam,Kowalski,Wrocław," + simpleDateFormat.format(new Date(0));

		// when
		String csvString = customer.toCSVString();

		// then
		assertEquals(expectedString, csvString);
	}

}