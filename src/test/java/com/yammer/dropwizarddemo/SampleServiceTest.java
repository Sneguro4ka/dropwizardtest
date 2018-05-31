package com.yammer.dropwizarddemo;

import com.yammer.dropwizarddemo.Player.Player;
import org.junit.Assert;
import org.junit.Test;

public class SampleServiceTest {

    @Test
    public void addPlayer() {
        Player p = new Player("John Doe", -1);

        Assert.assertEquals(true, SampleService.addPlayer(p));

        Assert.assertEquals(false, SampleService.addPlayer(p));
    }

    @Test
    public void getList()  {
        Assert.assertEquals(null, SampleService.getList());
    }
}