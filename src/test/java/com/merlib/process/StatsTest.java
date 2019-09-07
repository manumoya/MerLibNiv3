package com.merlib.process;
import com.merlib.models.Estadistica;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StatsTest {
    @Test
    public void getConnection() {

        Estadistica stat = Stats.getStats();

        assertEquals(0,stat.getHumano());
        assertEquals(7,stat.getMutante());
        assertEquals(1.0,stat.getRatio(),0.1);
    }

}
