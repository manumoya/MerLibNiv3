package com.merlib.models;

public class Estadistica {

    int mutante;
    int humano;
    float ratio;

    public Estadistica(int mutante, int humano, float ratio) {
        this.mutante = mutante;
        this.humano = humano;
        this.ratio = ratio;
    }

    public int getMutante() {
        return mutante;
    }

    public void setMutante(int mutante) {
        this.mutante = mutante;
    }

    public int getHumano() {
        return humano;
    }

    public void setHumano(int humano) {
        this.humano = humano;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }



}
