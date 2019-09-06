package com.merlib.models;

public class Estadistica {

    int count_mutant_dna;
    int count_human_dna;
    double ratio;

    public Estadistica(int mutante, int humano, double ratio) {
        this.count_mutant_dna = mutante;
        this.count_human_dna = humano;
        this.ratio = ratio;
    }

    public int getMutante() {
        return count_mutant_dna;
    }

    public void setMutante(int count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public int getHumano() {
        return count_human_dna;
    }

    public void setHumano(int count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }



}
