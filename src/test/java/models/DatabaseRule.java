package models;

import models.DB;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


public class DatabaseRule extends ExternalResource {


    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/travelwithme_test", "postgres", "MAINA");  //Those with linux or windows use two strings for username and password
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteanimalsQuery = "DELETE FROM places *;";
            con.createQuery(deleteanimalsQuery).executeUpdate();
        }
    }
}
