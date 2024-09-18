package Model;

import Enum.StatutProject;

public class Project {
    private Long Id;
    private String nomProjet;
    private Double margeBeneficiaire;
    private Double coutTotal;
    private StatutProject etatProjet;

    public Project(){}

    public Project(String nomProjet,Double margeBeneficiaire,Double coutTotal , StatutProject etatProjet){
        this.nomProjet = nomProjet ;
        this.margeBeneficiaire = margeBeneficiaire;
        this.coutTotal = coutTotal;
        this.etatProjet = etatProjet;
    }

    public Project(Long Id,String nomProjet,Double margeBeneficiaire,Double coutTotal , StatutProject etatProjet){
        this.Id = Id;
        this.nomProjet = nomProjet ;
        this.margeBeneficiaire = margeBeneficiaire;
        this.coutTotal = coutTotal;
        this.etatProjet = etatProjet;
    }

    public Long getId(){
        return this.Id;
    }

    public void setId(Long Id){
        this.Id = Id;
    }

    public  String getNomProjet(){
        return this.nomProjet;
    }

    public void setNomProjet(String nomProjet){
        this.nomProjet = nomProjet;
    }

    public Double getMargeBeneficiaire(){
        return this.margeBeneficiaire;
    }

    public void setMargeBeneficiaire(Double margeBeneficiaire){
        this.margeBeneficiaire = margeBeneficiaire;
    }

    public Double getCoutTotal(){
        return this.coutTotal;
    }

    public void setCoutTotal(Double coutTotal){
        this.coutTotal = coutTotal;
    }

    public StatutProject getEtatProjet(){
        return this.etatProjet;
    }

    public void setEtatProjet(StatutProject etatProjet){
        this.etatProjet = etatProjet;
    }





}
