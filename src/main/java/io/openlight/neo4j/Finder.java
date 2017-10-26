package io.openlight.neo4j;

import io.openlight.domain.User;
import org.neo4j.driver.v1.*;

import java.util.UUID;

public class Finder {

    public static User getByUsername(String username){
        Driver driver = GraphDatabase.driver( "bolt://hobby-djjfigaajbbfgbkeaecpfepl.dbs.graphenedb.com:24786", AuthTokens.basic( "openlight", "b.6GGBQb5zVyyC.AGcbmyfCH0dLlifb" ) );
        User user = new User();
        Session session = driver.session();
        StatementResult result = session.run("MATCH (n:User { username: '"+username+"' }) RETURN n");

        while ( result.hasNext() )
        {
            Record record = result.next();
            user.username = record.get("n.username").asString();
            user.email = record.get("n.email").asString();
            user.name = record.get("n.name").asString();
            System.out.println( record );
        }

        session.close();
        driver.close();

        return user;
    }
}
