package com.sda.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

public class AddBook {
    public static void addNewBook() throws SQLException {

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

        Connection connection = Database.getConnection();


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
}
