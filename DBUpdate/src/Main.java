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
			String q = "";
			int id = 1;
			
			/** pressure (inHg) **/ 
			for(int j = 1; j <= 12; j++)
			{
				if(j == 1) // Jan
				{
					for(int i = 1; i <=31 ; i++)
					{
						String x = getRand(29.26, 30.62);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET barometric_pressure = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
						
				         int updatedRowCount = st.executeUpdate(q);
					}
				}
				if(j == 2) // Feb
				{
					for(int i = 1; i <=28 ; i++)
					{
						String x = getRand(29.20, 30.61);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET barometric_pressure = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
			         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 3) // March
				{
					for(int i = 1; i <=31 ; i++)
					{			
						String x = getRand(29.36, 30.33);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET barometric_pressure = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 4) // April
				{
					for(int i = 1; i <=30 ; i++)
					{
						String x = getRand(29.46, 30.39);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET barometric_pressure = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 5) // May
				{
					for(int i = 1; i <=31 ; i++)
					{
						String x = getRand(29.25, 30.48);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET barometric_pressure = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 6) // June
				{
					for(int i = 1; i <=30 ; i++)
					{
						String x = getRand(29.44, 30.31);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET barometric_pressure = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 7) // July
				{
					for(int i = 1; i <=31 ; i++)
					{
						String x = getRand(29.72, 30.26);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET barometric_pressure = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 8) // August
				{
					for(int i = 1; i <=31 ; i++)
					{
						String x = getRand(29.65, 30.36);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET barometric_pressure = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 9) // Sept
				{
					for(int i = 1; i <=30 ; i++)
					{
						String x = getRand(29.80, 30.37);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET barometric_pressure = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 10) // Oct
				{
					for(int i = 1; i <=31 ; i++)
					{
						String x = getRand(29.36, 30.47);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET barometric_pressure = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 11) // Nov
				{
					for(int i = 1; i <=30 ; i++)
					{
						String x = getRand(29.52, 30.46);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET barometric_pressure = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 12) // Dec
				{
					for(int i = 1; i <=31 ; i++)
					{
						String x = getRand(29.46, 30.74);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET barometric_pressure = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
					
			}
			
			/** rainfall (cm) **/ 
		/*
			for(int j = 1; j <= 12; j++)
			{
				if(j == 1) // Jan
				{
					for(int i = 1; i <=31 ; i++)
					{
						String x = getRand(1025, 1026);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET rainfall = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
						
				         int updatedRowCount = st.executeUpdate(q);
					}
				}
				if(j == 2) // Feb
				{
					for(int i = 1; i <=28 ; i++)
					{
						String x = getRand(4.2, 4.6);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET rainfall = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
			         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 3) // March
				{
					for(int i = 1; i <=31 ; i++)
					{			
						String x = getRand(4.1, 4.6);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET rainfall = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 4) // April
				{
					for(int i = 1; i <=30 ; i++)
					{
						String x = getRand(3.3, 4.0);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET rainfall = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 5) // May
				{
					for(int i = 1; i <=31 ; i++)
					{
						String x = getRand(3.0, 3.3);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET rainfall = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 6) // June
				{
					for(int i = 1; i <=30 ; i++)
					{
						String x = getRand(3.0,3.6);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET rainfall = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 7) // July
				{
					for(int i = 1; i <=31 ; i++)
					{
						String x = getRand(3.2, 3.6);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET rainfall = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 8) // August
				{
					for(int i = 1; i <=31 ; i++)
					{
						String x = getRand(2.9, 3.2);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET rainfall = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 9) // Sept
				{
					for(int i = 1; i <=30 ; i++)
					{
						String x = getRand(3, 3.4);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET rainfall = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 10) // Oct
				{
					for(int i = 1; i <=31 ; i++)
					{
						String x = getRand(2.9, 3.3);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET rainfall = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 11) // Nov
				{
					for(int i = 1; i <=30 ; i++)
					{
						String x = getRand(3.0, 3.9);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET rainfall = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 12) // Dec
				{
					for(int i = 1; i <=31 ; i++)
					{
						String x = getRand(3.9, 4.05);
						q = "UPDATE `wilderness`.`station_detail` "
								+ "SET rainfall = " + x + " WHERE date = '2016-" + j + "-" + i + " ' "
										+ "AND stationID = "  + id;
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
					
			}
			*/
			
			/** wind_speed (mph) **/
		/*
		for(int j = 1; j <= 12; j++){
			for(int i = 1; i <=31 ; i++)
			{
					String x = getRand(6.2, 10.3);
					q = "UPDATE `wilderness`.`station_detail` "
							+ "SET wind_speed = " + x + " WHERE date = '2016-"+ j +"-" + i + " ' "
									+ "AND stationID = "  + id;
					  int updatedRowCount = st.executeUpdate(q);
				}
		}*/
			
			/** temperature (Celsius) **/
			
			/*for(int j = 1; j <= 12; j++)
			{
				if(j == 1) // Jan
				{
					for(int i = 1; i <=31 ; i++)
					{
						q = "INSERT INTO `wilderness`.`station_detail` (`stationID`, `air_temp`, `date`) "
								+ "VALUES (' " + id + "', ' " + getRand(1, 11) + " ', '2016-" + j + "-" + i + "')";
						
				         int updatedRowCount = st.executeUpdate(q);
					}
				}
				if(j == 2) // Feb
				{
					for(int i = 1; i <=28 ; i++)
					{
						q = "INSERT INTO `wilderness`.`station_detail` (`stationID`, `air_temp`, `date`) "
								+ "VALUES (' " + id + "', ' " +getRand(3, 14) + " ', '2016-" + j + "-" + i + "')";
			         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 3) // March
				{
					for(int i = 1; i <=31 ; i++)
					{
						q = "INSERT INTO `wilderness`.`station_detail` (`stationID`, `air_temp`, `date`) "
								+ "VALUES (' " + id + "', ' " + getRand(7, 18) + " ', '2016-" + j + "-" + i + "')";
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 4) // April
				{
					for(int i = 1; i <=30 ; i++)
					{
						q = "INSERT INTO `wilderness`.`station_detail` (`stationID`, `air_temp`, `date`) "
								+ "VALUES (' " + id + "', ' " + getRand(11, 22) + " ', '2016-" + j + "-" + i + "')";
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 5) // May
				{
					for(int i = 1; i <=31 ; i++)
					{
						q = "INSERT INTO `wilderness`.`station_detail` (`stationID`, `air_temp`, `date`) "
								+ "VALUES (' " + id + "', ' " + getRand(16, 27) + " ', '2016-" + j + "-" + i + "')";
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 6) // June
				{
					for(int i = 1; i <=30 ; i++)
					{
						q = "INSERT INTO `wilderness`.`station_detail` (`stationID`, `air_temp`, `date`) "
								+ "VALUES (' " + id + "', ' " + getRand(20, 30) + " ', '2016-" + j + "-" + i + "')";
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 7) // July
				{
					for(int i = 1; i <=31 ; i++)
					{
						q = "INSERT INTO `wilderness`.`station_detail` (`stationID`, `air_temp`, `date`) "
								+ "VALUES (' " + id + "', ' " + getRand(22, 32) + " ', '2016-" + j + "-" + i + "')";
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 8) // August
				{
					for(int i = 1; i <=31 ; i++)
					{
						q = "INSERT INTO `wilderness`.`station_detail` (`stationID`, `air_temp`, `date`) "
								+ "VALUES (' " + id + "', ' " + getRand(22, 31) + " ', '2016-" + j + "-" + i + "')";
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 9) // Sept
				{
					for(int i = 1; i <=30 ; i++)
					{
						q = "INSERT INTO `wilderness`.`station_detail` (`stationID`, `air_temp`, `date`) "
								+ "VALUES (' " + id + "', ' " + getRand(18, 28) + " ', '2016-" + j + "-" + i + "')";
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 10) // Oct
				{
					for(int i = 1; i <=31 ; i++)
					{
						q = "INSERT INTO `wilderness`.`station_detail` (`stationID`, `air_temp`, `date`) "
								+ "VALUES (' " + id + "', ' " + getRand(12, 23) + " ', '2016-" + j + "-" + i + "')";
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 11) // Nov
				{
					for(int i = 1; i <=30 ; i++)
					{
						q = "INSERT INTO `wilderness`.`station_detail` (`stationID`, `air_temp`, `date`) "
								+ "VALUES (' " + id + "', ' " + getRand(6, 18) + " ', '2016-" + j + "-" + i + "')";
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
				if(j == 12) // Dec
				{
					for(int i = 1; i <=31 ; i++)
					{
						q = "INSERT INTO `wilderness`.`station_detail` (`stationID`, `air_temp`, `date`) "
								+ "VALUES (' " + id + "', ' " + getRand(2, 12) + " ', '2016-" + j + "-" + i + "')";
				         int updatedRowCount = st.executeUpdate(q);

					}
				}
					
			}*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String getRand(double min, double max)
	{
		// cm conversion for rainfall
		//min *= 2.54;
		//max *= 2.54;

		double randomNum = ThreadLocalRandom.current().nextDouble(min, max + 1.0);
		return df2.format(randomNum);
	}
}
