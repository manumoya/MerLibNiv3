package com.merlib.process;
import com.merlib.models.Estadistica;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StatsTest {
    @Test
    public void getStats() {

        Estadistica stat = Stats.getStats();

        assertEquals(5,stat.getMutante());
        assertEquals(3,stat.getHumano());
        assertEquals(1.7,stat.getRatio(),0.1);
    }

}
