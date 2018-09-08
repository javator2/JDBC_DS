package com.sda.jdbc;

import java.sql.SQLException;

import static com.sda.jdbc.AddBook.addNewBook;

public class Main {

    public static void main(String[] args) throws SQLException {

        Database.getConnection();
        addNewBook();
        Database.closeConnection();

    }
}
