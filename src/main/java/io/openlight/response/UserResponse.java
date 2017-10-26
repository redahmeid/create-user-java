package io.openlight.response;

import io.openlight.domain.User;

import java.util.ArrayList;

public class UserResponse{

    public User body;

    public ArrayList<Link> actions;


    public void addLink(Link link){
        if(actions==null) actions = new ArrayList<>();
        actions.add(link);
    }

    public String self;
}