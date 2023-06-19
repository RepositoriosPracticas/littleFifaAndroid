package com.example.littlefifa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class fragment_insertar_resultado extends Fragment {

    private static final String DB_URL = "jdbc:mysql://mysql.colexio-karbo.com/karbo_piglesias";
    private static final String USER = "karbo_piglesias";
    private static final String PASS = "Alumno*2021";
    private Connection conn = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT id, equipo1, equipo2, liga, temporada, partido FROM lf_partidos WHERE fecha = CURDATE();";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // Obtener los datos de cada registro
                int id = rs.getInt("id");
                String equipo1 = rs.getString("equipo1");
                String equipo2 = rs.getString("equipo2");
                String liga = rs.getString("liga");
                String temporada = rs.getString("temporada");
                String partido = rs.getString("partido");
                String equip_partido = rs.getString(equipo1 + "-" +equipo2);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insertar_resultado, container, false);
    }
}