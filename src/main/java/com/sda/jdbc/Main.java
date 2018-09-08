package com.sda.jdbc;

import java.sql.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static final String URL = "jdbc:mysql://localhost/ksiegarnia?useSSL=false&serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "neftyda0";

    public static void addNewBook() throws SQLException, ParseException {

        Date data_wydania = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj tytuł: ");
        String title = scanner.nextLine();
        System.out.println("podaj autora: ");
        String author = scanner.nextLine();
        System.out.println("podaj datę wydania: ");
        String date = scanner.nextLine();
        System.out.println("podaj isbn: ");
        String isbn = scanner.nextLine();
        System.out.println("podaj kategorię: ");
        String category = scanner.nextLine();
        System.out.println("podaj liczbę stron: ");
        int page_count = scanner.nextInt();
        System.out.println("podaj wydawcę: ");
        String publisher = scanner.next();
        System.out.println("podaj cenę: ");
        Double price = scanner.nextDouble();
        System.out.println("podaj stan magazynowy: ");
        int in_stock = scanner.nextInt();

        Connection connection = DriverManager.getConnection(URL, username, password);



        PreparedStatement statement1 = connection.prepareStatement(
                "INSERT INTO booki VALUES (?,?,?,?,?,?,?,?,?)"
        );
        statement1.setString(1, title);
        statement1.setString(2, author);
        statement1.setDate(3, data_wydania.valueOf(date), Calendar.getInstance());
        statement1.setString(4, isbn);
        statement1.setString(5, category);
        statement1.setInt(6, page_count);
        statement1.setString(7, publisher);
        statement1.setDouble(8, price);
        statement1.setInt(9, in_stock);
        statement1.execute();
    }

    public static void main(String[] args) {

        Connection connection = null;   //połączenie z bazą danych
        Statement statement = null;     //wykonanie zapytania

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //rejestracja sterownika
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, username, password);
            String sql = "select * from booki";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int pageCount = resultSet.getInt("page_count");
                String title = resultSet.getString("title");

                System.out.println(title + " " + pageCount);
            }

            addNewBook();

//            String sqlInsert = "INSERT INTO booki (title, author, published, isbn, category, page_count," +
//                    " publisher, price) VALUES (\n" +
//                    "    'MySQL. Vademecum profesjonalisty v. 2',\n" +
//                    "    'Paul DuBois',\n" +
//                    "    '2014-03-28',\n" +
//                    "    '978-83-246-8146-5',\n" +
//                    "    'bazy danych',\n" +
//                    "    1216,\n" +
//                    "    'Helion',\n" +
//                    "    149.00\n" +
//                    ");";

//            String sqlInsert = "DELETE FROM booki WHERE isbn = '978-83-246-8146-6'";
//            statement.executeUpdate(sqlInsert);

//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String dateString = "04.08.2015";
//            Date date = dateFormat.parse(dateString);
//            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

//            PreparedStatement statement1 = connection.prepareStatement(
//                    "INSERT INTO booki VALUES (?,?,?,?,?,?,?,?,?)"
//            );
//            statement1.setString(1,"Tytuł nowej książki v. 2");
//            statement1.setString(2,"Autor książki");
//            statement1.setDate(3, sqlDate);
//            statement1.setString(4,"978-83-246-8146-7");
//            statement1.setString(5,"Kategoria książki");
//            statement1.setInt(6,666);
//            statement1.setString(7,"Wydawca książki");
//            statement1.setDouble(8,199.99);
//            statement1.setInt(9, 1000);
//            statement1.execute();

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
        }


    }
}
