package com.merlib.models;


public class Persona {

    String adn;
    int tipo;

    public Persona(String adn, int tipo) {
        this.adn = adn;
        this.tipo = tipo;
    }

    public String getAdn() {
        return adn;
    }

    public void setAdn(String adn) {
        this.adn = adn;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
