package pl.jwrabel.trainings.javandwro3.movierental;

import java.util.Date;

/**
 * Created by jakubwrabel on 22/05/2017.
 */
public class Rent {
	private int customerId;
	private int movieId;
	private Date date;

	public Rent(int customerId, int movieId) {
		this.customerId = customerId;
		this.movieId = movieId;
		this.date = new Date();
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getMovieId() {
		return movieId;
	}

	public Date getDate() {
		return date;
	}
}
