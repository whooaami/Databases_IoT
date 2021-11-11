package com.database.iot;

import com.database.iot.view.View;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        new View().show();
    }
}
