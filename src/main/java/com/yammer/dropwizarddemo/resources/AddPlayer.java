package com.yammer.dropwizarddemo.resources;

import com.yammer.dropwizarddemo.Player.Player;
import com.yammer.dropwizarddemo.SampleService;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import java.util.logging.Logger;

@Path("/add_player/{name}/{id}")
public class AddPlayer {

    static Logger logger = Logger.getLogger(SampleService.class.toString());

    // -----------------------------
    // Try to add player. if exists ( id not unique ) - dont add, else add
    // -----------------------------
    @GET
    public String addPlayerToList(@PathParam("name") @NotNull String name, @PathParam("id") int id) {
        Player newPlayer = new Player(name, id);
        if (SampleService.addPlayer(newPlayer))
            return "The Player : , " + name + ", id : " + id + ", was successfully added";
        else
            return "The Player already exist";
    }
}
