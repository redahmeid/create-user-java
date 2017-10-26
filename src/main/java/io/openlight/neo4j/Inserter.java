package io.openlight.neo4j;

import org.neo4j.driver.v1.*;

public class Inserter {

    public static String insert(String name, String email){
        Driver driver = GraphDatabase.driver( "bolt://hobby-geefdaeefcom.dbs.graphenedb.com:24786", AuthTokens.basic( "v303", "GtGq5rldxu" ) );

        Session session = driver.session();

        session.run("CREATE (n:User {name:'"+name+"', email:'"+email+"'})");
        StatementResult result = session.run("MATCH (n:User) RETURN n.id AS id");
        String id = "";
        while ( result.hasNext() )
        {
            Record record = result.next();
            System.out.println( record.get("id").asString() );
            id = record.get("id").asString();
        }

        session.close();
        driver.close();

        return id;
    }
}
