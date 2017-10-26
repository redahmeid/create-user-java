package io.openlight.neo4j;

import org.neo4j.driver.v1.*;

import java.util.UUID;

public class Inserter {

    public static String insert(String username,String name, String email){
        Driver driver = GraphDatabase.driver( "bolt://hobby-djjfigaajbbfgbkeaecpfepl.dbs.graphenedb.com:24786", AuthTokens.basic( "openlight", "b.6GGBQb5zVyyC.AGcbmyfCH0dLlifb" ) );

        Session session = driver.session();
        UUID id = UUID.randomUUID();
        session.run("CREATE (n:User {id:'"+id.toString()+"',username:'"+username+"',name:'"+name+"', email:'"+email+"'})");
        StatementResult result = session.run("MATCH (n:User) RETURN ID(n)");


        session.close();
        driver.close();

        return id.toString();
    }
}
