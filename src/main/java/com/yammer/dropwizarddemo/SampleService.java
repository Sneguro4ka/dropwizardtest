package com.yammer.dropwizarddemo;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizarddemo.Player.Player;
import com.yammer.dropwizarddemo.resources.*;

import java.util.*;
import java.util.logging.Logger;

public class SampleService extends Service<SampleConfiguration> {

    static Logger logger = Logger.getLogger(SampleService.class.toString());

    private static List<Player> listPlayers = new ArrayList<Player>();
    static {
        listPlayers.add(new Player("Eden Hazard" , 10 ));
        listPlayers.add(new Player("Cesc Fabregas" , 6 ));
        listPlayers.add(new Player("Olivie Giroud" , 18 ));
        listPlayers.add(new Player("Peter Cech" , 1 ));
        listPlayers.add(new Player("Ronaldinho" , 99 ));
    }


    // List of commands
    public static boolean addPlayer(Player argPlayer){
        logger.info("checking if player(" + argPlayer.getName() + ":" + argPlayer.getId() + ") exists");
        if ( isExist(argPlayer) ) {
            logger.info("The player exists - do not add");
            return false;
        }
        logger.info("The player doesn't exist -  add");
        listPlayers.add(new Player(argPlayer.getName(), argPlayer.getId()));
        return true;
    }

    // -----------------------------
    // 2 functions - one to retrive sorted by NAME, other by ID
    // -----------------------------
    public static TreeSet<Player> getSortByName()
    {
        TreeSet returnSet = new TreeSet<Player>(new Player.SortByName());
        returnSet.addAll(listPlayers);

        return returnSet;
    }
    public static TreeSet<Player> getSortByID()
    {
        TreeSet returnSet = new TreeSet<Player>(new Player.SortByID());
        returnSet.addAll(listPlayers);

        return returnSet;
    }

    public static List<Player> getList(){return listPlayers;}
    // -----------------------------
    // Check if unique
    // -----------------------------
    private static boolean isExist(Player argPlayer){
        for ( Player p : listPlayers )
        {
            if ( argPlayer.getId() == p.getId() )
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        new SampleService().run(args);
    }

    @Override
    public void initialize(Bootstrap<SampleConfiguration> bootstrap) {

    }
    @Override
    public void run(SampleConfiguration configuration, Environment environment) throws Exception {
        environment.addResource(new ShowAll());
        environment.addResource(new ShowSorted());
        environment.addResource(new AddPlayer());
    }
}
