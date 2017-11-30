import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Prediction {
	static DecimalFormat df2 = new DecimalFormat(".##");

	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String CONN_STRING = "jdbc:mysql://localhost/wilderness";
	
	public Prediction(){
	}
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	}
	
	public static int predictTemp(int stationID, String month)
	{
		Statement st = null;
		String q = "SELECT avg(air_temp) FROM station_detail WHERE stationID = " + stationID + " AND month(date) = " + month;
		try {
				DBConnect.getConnection();
				st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(q);
				while(rs.next())
				{
					int avg = rs.getInt("avg(air_temp)");
					//System.out.println(avg);
					avg += getRandMeasure(-7, 7);
					//avg =+ Integer.parseInt(getRandTemp());
					return avg;
				}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public static double predictPressure(int stationID, String month)
	{
		Statement st = null;
		String q = "SELECT avg(barometric_pressure) FROM station_detail WHERE stationID = " + stationID + " AND month(date) = " + month;
		try {
				DBConnect.getConnection();
				st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(q);
				while(rs.next())
				{
					double avg = rs.getInt("avg(barometric_pressure)");
					//System.out.println(avg);
					avg += getRandMeasure(-.5, .5);
					//avg =+ Integer.parseInt(getRandTemp());
					return avg;
				}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public static double predictWindSpeed(int stationID, String month)
	{
		Statement st = null;
		String q = "SELECT avg(wind_speed) FROM station_detail WHERE stationID = " + stationID + " AND month(date) = " + month;
		try {
				DBConnect.getConnection();
				st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(q);
				while(rs.next())
				{
					double avg = rs.getInt("avg(wind_speed)");
					//System.out.println(avg);
					avg += getRandMeasure(-3.2, 3.5);
					if(avg < 0)
						avg = 0;
					//avg =+ Integer.parseInt(getRandTemp());
					return avg;
				}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public static double predictRainfall(int stationID, String month)
	{
		Statement st = null;
		String q = "SELECT avg(rainfall) FROM station_detail WHERE stationID = " + stationID + " AND month(date) = " + month;
		try {
				DBConnect.getConnection();
				st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(q);
				while(rs.next())
				{
					double avg = rs.getInt("avg(rainfall)");
					//System.out.println(avg);
					avg += getRandMeasure(-1.2, 2.5);
					if(avg < 0)
						avg = 0;
					//avg =+ Integer.parseInt(getRandTemp());
					return avg;
				}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	private static double getRandMeasure(double min, double max)
	{
		
		
		double randomNum = ThreadLocalRandom.current().nextDouble(min, max + 1);
		return randomNum;
		//return df2.format(randomNum);
	}
	
	private static int getRandMeasure(int min, int max)
	{
		
		
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}
}
