package io.openlight.neo4j;

import org.neo4j.driver.v1.*;

public class Inserter {

    public static String insert(String name, String email){
        Driver driver = GraphDatabase.driver( "bolt://hobby-djjfigaajbbfgbkeaecpfepl.dbs.graphenedb.com:24786", AuthTokens.basic( "openlight", "b.6GGBQb5zVyyC.AGcbmyfCH0dLlifb" ) );

        Session session = driver.session();

        session.run("CREATE (n:User {name:'"+name+"', email:'"+email+"'})");
        StatementResult result = session.run("MATCH (n:User) RETURN ID");
        String id = "";
        while ( result.hasNext() )
        {
            Record record = result.next();
            System.out.println( record );
            id = record.get("id").asString();
        }

        session.close();
        driver.close();

        return id;
    }
}
