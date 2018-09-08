package com.sda.jdbc;

import java.sql.*;
import java.text.ParseException;

import static com.sda.jdbc.AddBook.addNewBook;

public class StaryMain {

//    public static final String URL = "jdbc:mysql://localhost/ksiegarnia?useSSL=false&serverTimezone=UTC";
//    private static final String username = "root";
//    private static final String password = "neftyda0";
//
//        public static void main(String[] args) throws SQLException {
//
//        Connection connection = null;   //połączenie z bazą danych
//        Statement statement = null;     //wykonanie zapytania
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");  //rejestracja sterownika
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(URL, username, password);
//            String sql = "select * from booki";
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()) {
//                int pageCount = resultSet.getInt("page_count");
//                String title = resultSet.getString("title");
//
//                System.out.println(title + " " + pageCount);
//            }
//
////            String sqlInsert = "INSERT INTO booki (title, author, published, isbn, category, page_count," +
////                    " publisher, price) VALUES (\n" +
////                    "    'MySQL. Vademecum profesjonalisty v. 2',\n" +
////                    "    'Paul DuBois',\n" +
////                    "    '2014-03-28',\n" +
////                    "    '978-83-246-8146-5',\n" +
////                    "    'bazy danych',\n" +
////                    "    1216,\n" +
////                    "    'Helion',\n" +
////                    "    149.00\n" +
////                    ");";
//
////            String sqlInsert = "DELETE FROM booki WHERE isbn = '978-83-246-8146-6'";
////            statement.executeUpdate(sqlInsert);
//
////            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////            String dateString = "04.08.2015";
////            Date date = dateFormat.parse(dateString);
////            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//
////            PreparedStatement statement1 = connection.prepareStatement(
////                    "INSERT INTO booki VALUES (?,?,?,?,?,?,?,?,?)"
////            );
////            statement1.setString(1,"Tytuł nowej książki v. 2");
////            statement1.setString(2,"Autor książki");
////            statement1.setDate(3, sqlDate);
////            statement1.setString(4,"978-83-246-8146-7");
////            statement1.setString(5,"Kategoria książki");
////            statement1.setInt(6,666);
////            statement1.setString(7,"Wydawca książki");
////            statement1.setDouble(8,199.99);
////            statement1.setInt(9, 1000);
////            statement1.execute();
//
//            addNewBook();
//
//            resultSet.close();
//            statement.close();
//            connection.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
////        } catch (ParseException e) {
////            e.printStackTrace();
//        }
//    }
}
