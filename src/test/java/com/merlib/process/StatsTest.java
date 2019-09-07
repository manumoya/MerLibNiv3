package com.merlib.process;
import com.merlib.models.Estadistica;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StatsTest {
    @Test
    public void getStats() {

        Estadistica stat = Stats.getStats();

        assertEquals(6,stat.getMutante());
        assertEquals(4,stat.getHumano());
        assertEquals(1.5,stat.getRatio(),0.1);
    }

    @Test
    public void convertAdntoIns() {
        String[] dna1 = {"ATAAAA","AGGGGC","ATATGG","AGAAGG","CCCCTG","TCACTG"}; // 1
        String stat = Stats.convertAdntoIns(dna1);

        assertEquals("ATAAAA-AGGGGC-ATATGG-AGAAGG-CCCCTG-TCACTG", stat);

    }

    @Test
    public void insStats() {
        String[] dna1 = {"ATAAAA","AGGGGC","ATATGG","AGAAGG","CCCCTG","TCACTG"}; // 1
        Stats.insStats(dna1, true);

        //assertEquals("ATAAAA-AGGGGC-ATATGG-AGAAGG-CCCCTG-TCACTG", stat);

    }



}
