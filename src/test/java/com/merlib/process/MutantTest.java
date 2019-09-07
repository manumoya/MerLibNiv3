package com.merlib.process;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MutantTest {

    String[] dna1 = {"ATAAAA","AGGGGC","ATATGG","AGAAGG","CCCCTG","TCACTG"}; // 1
    String[] dna2 = {"ATGAAA","AGGGGC","CTATGG","ACAAGG","CCCCTG","TCACTG"}; // 2
    String[] dna3 = {"ATGAAA","AGAAAG","CAGATG","ACATGA","CCTGCC","TTGATA"}; // 3
    String[] dna4 = {"ATAAAA","AGGGGC","ATATGG","AGAAGG","CCCGTG","TCGATG"}; // 4
    String[] dna5 = {"AAAA","AAAT","AAAG","ACCA"}; // 5
    String[] dna6 = {"ATAAA","AGGGG","ATGGG","AGGGG","CGCTG"}; // 6
    String[] dna7 = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"}; // 7
    String[] dna8 = {"AAAA","AAAT","AAAG"}; // 8
    String[] dna9 = {"ATAAR","AGGGG","ATGGG","AGGGG","CGCGG"}; // 9
    String[] dna10 = {"ATA","AGG","ATG"}; // 10
    String[] dna11 = {"CTGATG","ACATTC","CAGTCT","CGAAGA","AGTTAG","TCGCAC"}; // 11
    String[] dna12 = {"TAAATCGG","AAAATTTT","TCAGTAGT","GAATTGAT","CCCCGGTT","AAAGTGAG","GAAAAGGG","TCTTTTAG"}; //12
    String[] dna13 = {"ATGGGATAG","TAGGATGAA","GGCGGTGGA","AACCAATAA","AAAACGGTA","TCTACCGCA","GCACACATG","GCTGTAGTG",
            "CCGGGGGCG"}; //13
    String[] dna14 = {"ATAG","AGGC","ATGT","CGAA"}; // 14
    String[] dna15 = {"AAAC","AGCT","TCCG","CAAT"}; // 15
    String[] dna16 = {"ATGAAAGTAC","TACTGTTGTT","GGACACCCGA","CCTGTAAACG","AAGTGGCCAA","TACAACCGGT",
            "GTTGAAACAC","CCACTGATCG","AGTAGTGAGC","AACTCAAGCA"}; // 16

    int largo1 = dna1.length;
    int largo2 = dna2.length;
    int largo3 = dna3.length;
    int largo4 = dna4.length;
    int largo5 = dna5.length;
    int largo6 = dna6.length;
    int largo7 = dna7.length;
    int largo8 = dna8.length;
    int largo9 = dna9.length;
    int largo10 = dna10.length;
    int largo11 = dna11.length;
    int largo12 = dna12.length;
    int largo13 = dna13.length;
    int largo14 = dna14.length;
    int largo15 = dna15.length;
    int largo16 = dna16.length;

    char[][] arr1 = new char[largo1][largo1];
    char[][] arr2 = new char[largo2][largo2];
    char[][] arr3 = new char[largo3][largo3];
    char[][] arr4 = new char[largo4][largo4];
    char[][] arr5 = new char[largo5][largo5];
    char[][] arr6 = new char[largo6][largo6];
    char[][] arr7 = new char[largo7][largo7];
    char[][] arr8 = new char[largo8][largo8];
    char[][] arr9 = new char[largo9][largo9];
    char[][] arr10 = new char[largo10][largo10];
    char[][] arr11 = new char[largo11][largo11];
    char[][] arr12 = new char[largo12][largo12];
    char[][] arr13 = new char[largo13][largo13];
    char[][] arr14 = new char[largo14][largo14];
    char[][] arr15 = new char[largo15][largo15];
    char[][] arr16 = new char[largo16][largo16];

    boolean completeMatriz1 =  Mutant.completeMatriz(arr1,dna1);
    boolean completeMatriz2 =  Mutant.completeMatriz(arr2,dna2);
    boolean completeMatriz3 =  Mutant.completeMatriz(arr3,dna3);
    boolean completeMatriz4 =  Mutant.completeMatriz(arr4,dna4);
    boolean completeMatriz5 =  Mutant.completeMatriz(arr5,dna5);
    boolean completeMatriz6 =  Mutant.completeMatriz(arr6,dna6);
    boolean completeMatriz7 =  Mutant.completeMatriz(arr7,dna7);
    boolean completeMatriz8 =  Mutant.completeMatriz(arr8,dna8);
    boolean completeMatriz9 =  Mutant.completeMatriz(arr9,dna9);
    boolean completeMatriz10 =  Mutant.completeMatriz(arr10,dna10);
    boolean completeMatriz11 =  Mutant.completeMatriz(arr11,dna11);
    boolean completeMatriz12 =  Mutant.completeMatriz(arr12,dna12);
    boolean completeMatriz13 =  Mutant.completeMatriz(arr13,dna13);
    boolean completeMatriz14 =  Mutant.completeMatriz(arr14,dna14);
    boolean completeMatriz15 =  Mutant.completeMatriz(arr15,dna15);
    boolean completeMatriz16 =  Mutant.completeMatriz(arr16,dna16);

    @Test
    public void completeMatriz() {
        assertEquals(true, completeMatriz1);
        assertEquals(true, completeMatriz2);
        assertEquals(true, completeMatriz3);
        assertEquals(true, completeMatriz4);
        assertEquals(true, completeMatriz5);
        assertEquals(true, completeMatriz6);
        assertEquals(true, completeMatriz7);
        assertEquals(false, completeMatriz8);
        assertEquals(false, completeMatriz9);
        assertEquals(false, completeMatriz10);
        assertEquals(true, completeMatriz11);
        assertEquals(true, completeMatriz12);
        assertEquals(true, completeMatriz13);
        assertEquals(true, completeMatriz14);
        assertEquals(true, completeMatriz15);
        assertEquals(true, completeMatriz16);
    }

    @Test
    public void valideLetter() {
        char [] dnaSimple1 = "ATAAAA".toCharArray();
        char [] dnaSimple2 = "ATAAARA".toCharArray();
        char [] dnaSimple3 = "ATGA AC".toCharArray();
        boolean valide1 =  Mutant.valideLetter(dnaSimple1);
        boolean valide2 =  Mutant.valideLetter(dnaSimple2);
        boolean valide3 =  Mutant.valideLetter(dnaSimple3);
        assertEquals(true, valide1);
        assertEquals(false, valide2);
        assertEquals(false, valide3);
    }

    @Test
    public void countSecuenceHoriz() {
        assertEquals(2, Mutant.countSecuenceHoriz(arr1, largo1));
        assertEquals(2, Mutant.countSecuenceHoriz(arr2, largo2));
        assertEquals(0, Mutant.countSecuenceHoriz(arr3, largo3));
        assertEquals(2, Mutant.countSecuenceHoriz(arr4, largo4));
        assertEquals(1, Mutant.countSecuenceHoriz(arr5, largo5));
        assertEquals(2, Mutant.countSecuenceHoriz(arr6, largo6));
        assertEquals(1, Mutant.countSecuenceHoriz(arr7, largo7));
        assertEquals(0, Mutant.countSecuenceHoriz(arr11, largo11));
        assertEquals(2, Mutant.countSecuenceHoriz(arr12, largo12));
        assertEquals(2, Mutant.countSecuenceHoriz(arr13, largo13));
        assertEquals(0, Mutant.countSecuenceHoriz(arr14, largo14));
        assertEquals(0, Mutant.countSecuenceHoriz(arr15, largo15));
        assertEquals(0, Mutant.countSecuenceHoriz(arr16, largo16));
    }

    @Test
    public void countSecuenceVert() {
        assertEquals(2, Mutant.countSecuenceVert(arr1, largo1));
        assertEquals(1, Mutant.countSecuenceVert(arr2, largo2));
        assertEquals(0, Mutant.countSecuenceVert(arr3, largo3));
        assertEquals(2, Mutant.countSecuenceVert(arr4, largo4));
        assertEquals(1, Mutant.countSecuenceVert(arr5, largo5));
        assertEquals(2, Mutant.countSecuenceVert(arr6, largo6));
        assertEquals(1, Mutant.countSecuenceVert(arr7, largo7));
        assertEquals(0, Mutant.countSecuenceVert(arr11, largo11));
        assertEquals(2, Mutant.countSecuenceVert(arr12, largo12));
        assertEquals(2, Mutant.countSecuenceVert(arr13, largo13));
        assertEquals(0, Mutant.countSecuenceVert(arr14, largo14));
        assertEquals(0, Mutant.countSecuenceVert(arr15, largo15));
        assertEquals(0, Mutant.countSecuenceVert(arr16, largo16));
    }

    @Test
    public void searchDiagIzqDer() {
    }

    @Test
    public void countSecuenceDiagIzqDer() {
        assertEquals(0, Mutant.countSecuenceDiagIzqDer(arr1, largo1));
        assertEquals(2, Mutant.countSecuenceDiagIzqDer(arr2, largo2));
        assertEquals(0, Mutant.countSecuenceDiagIzqDer(arr3, largo3));
        assertEquals(0, Mutant.countSecuenceDiagIzqDer(arr4, largo4));
        assertEquals(1, Mutant.countSecuenceDiagIzqDer(arr5, largo5));
        assertEquals(1, Mutant.countSecuenceDiagIzqDer(arr6, largo6));
        assertEquals(1, Mutant.countSecuenceDiagIzqDer(arr7, largo7));
        assertEquals(0, Mutant.countSecuenceDiagIzqDer(arr11, largo11));
        assertEquals(1, Mutant.countSecuenceDiagIzqDer(arr12, largo12));
        assertEquals(2, Mutant.countSecuenceDiagIzqDer(arr13, largo13));
        assertEquals(0, Mutant.countSecuenceDiagIzqDer(arr14, largo14));
        assertEquals(0, Mutant.countSecuenceDiagIzqDer(arr15, largo15));
        assertEquals(3, Mutant.countSecuenceDiagIzqDer(arr16, largo16));
    }

    @Test
    public void searchDiagDerIzq() {
    }

    @Test
    public void countSecuenceDiagDerIzq() {
        assertEquals(0, Mutant.countSecuenceDiagDerIzq(arr1, largo1));
        assertEquals(0, Mutant.countSecuenceDiagDerIzq(arr2, largo2));
        assertEquals(4, Mutant.countSecuenceDiagDerIzq(arr3, largo3));
        assertEquals(1, Mutant.countSecuenceDiagDerIzq(arr4, largo4));
        assertEquals(1, Mutant.countSecuenceDiagDerIzq(arr5, largo5));
        assertEquals(1, Mutant.countSecuenceDiagDerIzq(arr6, largo6));
        assertEquals(0, Mutant.countSecuenceDiagDerIzq(arr7, largo7));
        assertEquals(0, Mutant.countSecuenceDiagDerIzq(arr11, largo11));
        assertEquals(1, Mutant.countSecuenceDiagDerIzq(arr12, largo12));
        assertEquals(0, Mutant.countSecuenceDiagDerIzq(arr13, largo13));
        assertEquals(0, Mutant.countSecuenceDiagDerIzq(arr14, largo14));
        assertEquals(1, Mutant.countSecuenceDiagDerIzq(arr15, largo15));
        assertEquals(0, Mutant.countSecuenceDiagDerIzq(arr16, largo16));
    }

    @Test
    public void isMutant() {
        assertEquals(true, Mutant.isMutant(dna1));
        assertEquals(true, Mutant.isMutant(dna2));
        assertEquals(true, Mutant.isMutant(dna3));
        assertEquals(true, Mutant.isMutant(dna4));
        assertEquals(true, Mutant.isMutant(dna5));
        assertEquals(true, Mutant.isMutant(dna6));
        assertEquals(true, Mutant.isMutant(dna7));
        assertEquals(false, Mutant.isMutant(dna8));
        assertEquals(false, Mutant.isMutant(dna9));
        assertEquals(false, Mutant.isMutant(dna10));
        assertEquals(false, Mutant.isMutant(dna11));
        assertEquals(true, Mutant.isMutant(dna12));
        assertEquals(true, Mutant.isMutant(dna13));
        assertEquals(false, Mutant.isMutant(dna14));
        assertEquals(false, Mutant.isMutant(dna15));
        assertEquals(true, Mutant.isMutant(dna16));
    }

    /*
    @Test
    void testCompleteMatriz() {
    }

    @Test
    void testValideLetter() {
    }

    @Test
    void testPrintMatriz() {
    }

    @Test
    void testCountSecuenceHoriz() {
    }

    @Test
    void testCountSecuenceVert() {
    }

    @Test
    void testSearchDiagIzqDer() {
    }

    @Test
    void testCountSecuenceDiagIzqDer() {
    }

    @Test
    void testSearchDiagDerIzq() {
    }

    @Test
    void testCountSecuenceDiagDerIzq() {
    }

    @Test
    void testIsMutant() {
    }

     */
}