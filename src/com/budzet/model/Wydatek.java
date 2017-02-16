package com.budzet.model;

public class Wydatek
{
    private int id;
    private double cena;
    private String opis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Wydatek() {
    }

    public Wydatek(double cena, String opis) {
        this.cena = cena;
        this.opis = opis;
    }
}
