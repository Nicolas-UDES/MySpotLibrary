package MySpotLibrary.BLL;

import MySpotLibrary.Entites.Marking;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MarkingBLL {

	public static double oldGetPower(Marking marking){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(marking.getDate());

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		double power = year + month*30 + day;
		return power + marking.getStrength() * marking.getAmount();
	}

	public static double getPower(Marking marking){
		Long timeDif = new Date().getTime() - marking.getDate().getTime();
		return (1 / timeDif) * marking.getStrength() * marking.getAmount();
	}

	public static Marking max(Marking a, Marking b) {
		return getPower(a) >= getPower(b) ? a : b;
	}
}