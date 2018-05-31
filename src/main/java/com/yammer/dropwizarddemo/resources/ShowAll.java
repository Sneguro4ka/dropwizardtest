package com.yammer.dropwizarddemo.resources;

import com.yammer.dropwizarddemo.Player.Player;
import com.yammer.dropwizarddemo.SampleService;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import java.util.List;

@Path("/show_list")
public class ShowAll {

    // -----------------------------
    // Show the list of players NOT SORTED
    // -----------------------------
    @GET
    public String showList(){
        String s = "List Of Players : ";
        List<Player> currentList = SampleService.getList();
        for (Player p : currentList )
        {
            s = s + " Name: " + p.getName() + " | " + "id: " + p.getId() + " ||" ;
        }
        return s;
    }

}
