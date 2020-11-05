package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }

    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals(1000, kortti.saldo());
    }

    @Test
    public void kortinSaldonLataaminenOnnistuu() {
        kortti.lataaRahaa(200);
        assertEquals(1200, kortti.saldo());
    }

    @Test
    public void kortinSaldoVähenee() {
        kortti.otaRahaa(200);
        assertEquals(800, kortti.saldo());
    }

    @Test
    public void kortinSaldoEiMuutu() {
        kortti.otaRahaa(1100);
        assertEquals(1000, kortti.saldo());
    }

    @Test
    public void trueJosRahatRiittivät() {
        boolean saldoVähenee = kortti.otaRahaa(200);
        assertEquals(true, saldoVähenee);
    }
    
    @Test
    public void falseJosEiTarpeeksiRahaa() {
        boolean saldoVähenee = kortti.otaRahaa(1200);
        assertEquals(false, saldoVähenee);
    }
    
    @Test
    public void onkoStringMuotoOikein() {
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
}
