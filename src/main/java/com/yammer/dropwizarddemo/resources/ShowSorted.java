package com.yammer.dropwizarddemo.resources;
import com.yammer.dropwizarddemo.Player.Player;
import com.yammer.dropwizarddemo.SampleService;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import java.util.TreeSet;
import java.util.logging.Logger;

@Path("/show_sorted/{byNameOrId}")
public class ShowSorted {

    static Logger logger = Logger.getLogger(SampleService.class.toString());

    // -----------------------------
    // Show the list of players SORTED
    // according to the param given - NAME / ID
    // -----------------------------
    @GET
    public String showByNameOrID(@PathParam("byNameOrId") @NotNull String argByNameOrId) {

        if (argByNameOrId.equals("name"))
            return sortByName();
        else
            if (argByNameOrId.equals("id"))
                return sortById();
            else
                return "invalid parameter";

    }

    // ---------------------------------------
    // if user asks to sort by NAME,
    // return regular tree ( sorted by default by id )
    // ---------------------------------------
    private static String sortByName(){
        String s = "List Of Players : ";
        TreeSet sortedID = SampleService.getSortByName();

        for (Object o : sortedID ) {
            Player p = (Player)o;
            s = s + " Name: " + p.getName() + " | " + "id: " + p.getId() + " ||";
        }
        return s;
    }

    // ---------------------------------------
    // if user asks to sort by NAME,
    // sort and return sorted by NAME)
    // ---------------------------------------
    private static String sortById(){
        String s = "List Of Players : ";
        TreeSet sortedID = SampleService.getSortByID();

        for (Object o : sortedID ) {
            Player p = (Player)o;
            s = s + " Name: " + p.getName() + " | " + "id: " + p.getId() + " ||";
        }
        return s;
    }


}
