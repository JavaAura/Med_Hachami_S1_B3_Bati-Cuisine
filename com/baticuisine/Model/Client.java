package com.baticuisine.Model;

public class Client {
    private Long Id;
    private String nom;
    private String addresse;
    private String telephone;
    private Boolean estProfessionnel;


    public Client(){

    }


    public Client(String nom, String addresse, String telephone , Boolean estProfessionnel){
        this.nom = nom;
        this.addresse = addresse;
        this.telephone = telephone;
        this.estProfessionnel = estProfessionnel;

    }

    public Client(Long Id ,String nom, String addresse, String telephone , Boolean estProfessionnel){
        this.Id = Id;
        this.nom = nom;
        this.addresse = addresse;
        this.telephone = telephone;
        this.estProfessionnel = estProfessionnel;

    }

    public Long getId(){
        return this.Id;
    }

    public void setId(Long Id){
        this.Id = Id;
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getAdresse(){
        return this.addresse;
    }

    public void setAddresse(String addresse){
        this.addresse = addresse;
    }

    public String getTelephone(){
        return this.telephone;
    }

    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    public Boolean getEstProfessionnel(){
        return this.estProfessionnel;
    }

    public void setEstProfessionnel(Boolean estProfessionnel){
        this.estProfessionnel = estProfessionnel;
    }


}
