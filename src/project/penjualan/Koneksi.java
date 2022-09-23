/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.penjualan;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Acer
 */
public class Koneksi {
    public Connection db_pbol;
    public Statement statement;
    public PreparedStatement preparedStatement;
    public Koneksi() {
        this.db_pbol = null;
    }
    public void bukaKoneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            db_pbol = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/db_pbol?user=root&password=");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void tutupKoneksi() {
        try { if (statement != null) {
            statement.close();
        }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (db_pbol != null) {
                db_pbol.close();            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
