/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jarkko
 */
public class KassapaateTest {
    
    Kassapaate paate;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void rahaaOikeinTest() {
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void myytyjaMaukkaitaLounaitaOikeinTest() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void myytyjaEdullisiaLounaitaOikeinTest() {
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoEdullisiaLounaitaRahaMaaraKasvaaTest() {
        paate.syoEdullisesti(240);
        assertEquals(100240, paate.kassassaRahaa());
    }    

    @Test
    public void kateisostoEdullisiaLounaitaVaihtorahaOikeinTest() {
        assertEquals(60, paate.syoEdullisesti(300));
    } 
    
    @Test
    public void kateisostoEdullisiaLounaitaMyydytKasvaaTest() {
        paate.syoEdullisesti(240);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateisostoEdullisiaLounaitaMaksuEiRiittavaRahaMaaraEiMuutuTest() {
        paate.syoEdullisesti(200);
        assertEquals(100000, paate.kassassaRahaa());
    }    

    @Test
    public void kateisostoEdullisiaLounaitaMaksuEiRiittavaVaihtorahaOikeinTest() {
        assertEquals(200, paate.syoEdullisesti(200));
    }
    
    @Test
    public void kateisostoEdullisiaLounaitaMaksuEiRiittavaMyydytEiKasvaTest() {
        paate.syoEdullisesti(200);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoMaukkaitaLounaitaRahaMaaraKasvaaTest() {
        paate.syoMaukkaasti(400);
        assertEquals(100400, paate.kassassaRahaa());
    }    

    @Test
    public void kateisostoMaukkaitaLounaitaVaihtorahaOikeinTest() {
        assertEquals(60, paate.syoMaukkaasti(460));
    }
    
    @Test
    public void kateisostoMaukkaitaLounaitaMyydytKasvaaTest() {
        paate.syoMaukkaasti(400);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisostoMaukkaitaLounaitaMaksuEiRiittavaRahaMaaraEiMuutuTest() {
        paate.syoMaukkaasti(200);
        assertEquals(100000, paate.kassassaRahaa());
    }    

    @Test
    public void kateisostoMaukkaitaLounaitaMaksuEiRiittavaVaihtorahaOikeinTest() {
        assertEquals(200, paate.syoMaukkaasti(200));
    }
    
    @Test
    public void kateisostoMaukkaitaLounaitaMaksuEiRiittavaMyydytEiKasvaTest() {
        paate.syoMaukkaasti(200);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }    

    @Test
    public void korttiostoEdullisiaLounaitaVeloitetaanSaldoTest() {
        paate.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
    }

    @Test
    public void korttiostoEdullisiaLounaitaVeloitetaanPalauttaaTest() {
        assertEquals(true , paate.syoEdullisesti(kortti));
    }

    @Test
    public void korttiostoEdullisiaLounaitaJosRahaaMyydytKasvaaTest() {
        paate.syoEdullisesti(kortti);
        assertEquals(1 , paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiostoEdullisiaLounaitaEiSaldoaVeloitetaankoTest() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        paate.syoEdullisesti(kortti);
        assertEquals(200, kortti.saldo());
    }

    @Test
    public void korttiostoEdullisiaLounaitaEiSaldoaVeloitetaanPalauttaaTest() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(false , paate.syoEdullisesti(kortti));
    }

    @Test
    public void korttiostoEdullisiaLounaitaEiSaldoaMyydytKasvaakoTest() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        paate.syoEdullisesti(kortti);
        assertEquals(0 , paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiostoEdullisiaLounaitaKassaEiMuutuTest() {
        paate.syoEdullisesti(kortti);
        assertEquals(100000 , paate.kassassaRahaa());
    }
    
    @Test
    public void korttiostoMaukkaitaLounaitaVeloitetaanSaldoTest() {
        paate.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
    }

    @Test
    public void korttiostoMaukkaitaLounaitaVeloitetaanPalauttaaTest() {
        assertEquals(true , paate.syoMaukkaasti(kortti));
    }

    @Test
    public void korttiostoMaukkaitaLounaitaJosRahaaMyydytKasvaaTest() {
        paate.syoMaukkaasti(kortti);
        assertEquals(1 , paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiostoMaukkaitaLounaitaEiSaldoaVeloitetaankoTest() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(200, kortti.saldo());
    }

    @Test
    public void korttiostoMaukkaitaLounaitaEiSaldoaVeloitetaanPalauttaaTest() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(false , paate.syoMaukkaasti(kortti));
    }

    @Test
    public void korttiostoMaukkaitaLounaitaEiSaldoaMyydytKasvaakoTest() {
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(0 , paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttiostoMaukkaitaLounaitaKassaEiMuutuTest() {
        paate.syoMaukkaasti(kortti);
        assertEquals(100000 , paate.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaaKortilleSaldoMuuttuuTest() {
        paate.lataaRahaaKortille(kortti, 100);
        assertEquals(1100 , kortti.saldo());
    }

    @Test
    public void lataaRahaaKortilleKassanRahaMaaraKasvaaTest() {
        paate.lataaRahaaKortille(kortti, 100);
        assertEquals(100100 , paate.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaaKortilleNegatiivinenSummaKassaEiMuutuTest() {
        paate.lataaRahaaKortille(kortti, -100);
        assertEquals(100000 , paate.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaaKortilleNegatiivinenSummaSaldoEiMuutuTest() {
        paate.lataaRahaaKortille(kortti, -100);
        assertEquals(1000 , kortti.saldo());
    }
}
