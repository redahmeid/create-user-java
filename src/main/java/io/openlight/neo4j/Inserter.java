package io.openlight.neo4j;

import org.neo4j.driver.v1.*;

import java.util.UUID;

public class Inserter {

    public static String insert(String username,String name, String email){
        Driver driver = GraphDatabase.driver( System.getenv("neo_url"), AuthTokens.basic( System.getenv("neo_user"), System.getenv("neo_password") ) );
        Session session = driver.session();
        UUID id = UUID.randomUUID();
        session.run("CREATE (n:User {username:'"+username+"',name:'"+name+"', email:'"+email+"'})");
        session.close();
        driver.close();
        return username;
    }
}
