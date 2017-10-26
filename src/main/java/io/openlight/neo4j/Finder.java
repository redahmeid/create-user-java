package io.openlight.neo4j;

import io.openlight.domain.User;
import org.neo4j.driver.v1.*;

import java.util.UUID;

public class Finder {

    public static User getByUsername(String username){
        Driver driver = GraphDatabase.driver( "bolt://hobby-djjfigaajbbfgbkeaecpfepl.dbs.graphenedb.com:24786", AuthTokens.basic( "openlight", "b.6GGBQb5zVyyC.AGcbmyfCH0dLlifb" ) );
        User user = new User();
        Session session = driver.session();
        StatementResult result = session.run("MATCH (n:User { username: '"+username+"' }) RETURN n.username AS username, n.name AS name, n.email AS email");

        while ( result.hasNext() )
        {
            Record record = result.next();
            user.username = record.get("username").asString();
            user.email = record.get("email").asString();
            user.name = record.get("name").asString();
            
        }

        session.close();
        driver.close();

        return user;
    }
}
