import pl.jwrabel.trainings.javandwro3.movierental.CsvObject;

/**
 * Created by jakubwrabel on 23/05/2017.
 */
public class Abc implements CsvObject {
	@Override
	public String toCSVString() {
		return  "ABC";
	}
}
