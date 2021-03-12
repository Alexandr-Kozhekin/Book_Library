package application;

import servis.UserInterface.BookLibrary;

import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class BookLibraryApplication {

    static Logger LOGGER;

    static {

        try (FileInputStream ins = new FileInputStream("/Users/alexandrkozhekin/Documents/IntaliIDEA/Book_Library/log.config")) {

            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(BookLibraryApplication.class.getName());

        } catch (Exception ignore) {

            ignore.printStackTrace();

        }
    }

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            String sqlCommand = "CREATE TABLE Books (Id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "AuthorBook VARCHAR(20), " +
                    "TittleBook VARCHAR(20), " +
                    "YearOfIssueBook VARCHAR(20))";

            try (Connection connection = getConnection()){

                Statement statement = connection.createStatement();
                // создание таблицы
                statement.executeUpdate(sqlCommand);

                LOGGER.log(Level.INFO,"Connection to Store DB successful!");

                BookLibrary bookLibrary = new BookLibrary();
                bookLibrary.run();

            }

        } catch(Exception ex) {

            LOGGER.log(Level.WARNING, "Connection failed...", ex);

        }
    }

    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();

        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))){

            props.load(in);

        }

        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);

    }

}
