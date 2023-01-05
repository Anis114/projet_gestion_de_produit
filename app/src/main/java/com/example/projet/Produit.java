package com.example.projet;

public class Produit {
    String  nom;
    int  id;
    double  prix;

    public Produit() {
    }

    public Produit(String nom, int id, double prix) {
        this.nom = nom;
        this.id = id;
        this.prix = prix;
    }

    public Produit(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
