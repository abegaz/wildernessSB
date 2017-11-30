import java.sql.*;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;
public class Main {

	static DecimalFormat df2 = new DecimalFormat(".##");
	
	public static void main(String[] args)
	{
		try {
			
			DBConnect.getConnection();
			Connection con = null;
			Statement st = DBConnect.getConnection().createStatement();
			/*
			 * 1 - New York
			 *  2 - Idaho
			 *  3 -  Mississippi
			 *  4- Tennessee
			 *  5 - Washington
			 *  6 - California
			 *  7 - Michigan
			 *  8 - Texas
			 *  9 - Alabama
			 *  10 - Georgia
			 */
			int y = Prediction.predictTemp(10, "4"); // Predicts the temperature for any day in Georgia for the month of April
			System.out.println(y);
			
			double x = Prediction.predictWindSpeed(10, "4"); // Predicts the temperature for any day in Georgia for the month of April
			System.out.println(df2.format(x));
			
			double z = Prediction.predictPressure(10, "4");
			System.out.println(df2.format(z));
			
			double a = Prediction.predictRainfall(10, "4");
			System.out.println(df2.format(a));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
