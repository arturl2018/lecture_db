package sdp.gl2019.db;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class FindDataSafeExample {

    public static void main(String[] args) {

        System.out.println("Podaj szukaną nazwe stacji");
        Scanner scanner = new Scanner(System.in);
        String stacja = scanner.nextLine();
        try (Connection connection = getConnection()) {
            Synop synop = findByStacja(connection, stacja);
            System.out.println(synop);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private static Synop findByStacja(Connection connection, String stacja) throws SQLException {


        PreparedStatement statement = connection.prepareStatement("select id_stacji, stacja, data_pomiaru, godzina_pomiaru, temperatura, " +
                "predkosc_wiatru, kierunek_wiatru, wilgotnosc_wzgledna, suma_opadu, cisnienie" +
                " from synop where stacja = ?;");

        statement.setString(1, stacja);
        ResultSet res = statement.executeQuery();

        if (!res.next()) {
            return null;
        }
        Synop synop = new Synop();
        synop.setIdStacji(res.getInt("id_stacji"));
        synop.setStacja(res.getString("stacja"));

        LocalDate data_pomiaru = res.getDate("data_pomiaru").toLocalDate();
        synop.setDataPomiaru(data_pomiaru);

        synop.setGodzinaPomiaru(res.getInt("godzina_pomiaru"));
        synop.setTemperatura(res.getDouble("temperatura"));
        synop.setPredkoscWiatru(res.getDouble("predkosc_wiatru"));
        synop.setKierunekWiatru(res.getDouble("kierunek_wiatru"));
        synop.setWilgotnoscWzgledna(res.getDouble("wilgotnosc_wzgledna"));
        synop.setSumaOpadu(res.getDouble("suma_opadu"));
        synop.setCisnienie(res.getDouble("cisnienie"));
        return synop;
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";

        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}