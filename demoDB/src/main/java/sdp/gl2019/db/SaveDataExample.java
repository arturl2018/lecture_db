package sdp.gl2019.db;

import org.springframework.web.client.RestTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveDataExample {


	public static void main(String[] args) {


		RestTemplate restTemplate = new RestTemplate();

		String url = "https://danepubliczne.imgw.pl/api/data/synop";
		Synop[] synops = restTemplate.getForObject(url, Synop[].class);

		try(Connection connection = getConnection()) {
			for(Synop synop : synops) {
				System.out.println(synop);
				addToDatabase(synop, connection);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Done");


	}

	private static void addToDatabase(Synop synop, Connection connection) throws SQLException {


			Statement statement = connection.createStatement();
			statement.execute("insert into synop (id_stacji, stacja, data_pomiaru, godzina_pomiaru, temperatura, " +
					"predkosc_wiatru, kierunek_wiatru, wilgotnosc_wzgledna, suma_opadu, cisnienie)" +
					"values ("
					+ synop.getIdStacji() + ", "
					+ "'" + synop.getStacja() + "', "
					+ "'" + synop.getDataPomiaru() + "', "
					+ synop.getGodzinaPomiaru()+ ", "
					+ synop.getTemperatura() + ", "
					+ synop.getPredkoscWiatru() + ", "
					+ synop.getKierunekWiatru() + ", "
					+ synop.getWilgotnoscWzgledna() + ", "
					+ synop.getSumaOpadu() + ", "
					+ synop.getCisnienie()
					+ ");");
	}

	private static Connection getConnection() throws ClassNotFoundException, SQLException {

		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "postgres";

		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(url, user, password);
	}

}
