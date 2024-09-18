package Model;

import Enum.StatutProject;




import java.util.List;

public class Projet {
    private Long Id;
    private String nomProjet;
    private Double margeBeneficiaire;
    private Double coutTotal;
    private StatutProject etatProjet;
    private Client client;
    private List<Composant> composants;



    public Projet(){}

    public Projet(String nomProjet,Double margeBeneficiaire,Double coutTotal , StatutProject etatProjet , Client client){
        this.nomProjet = nomProjet ;
        this.margeBeneficiaire = margeBeneficiaire;
        this.coutTotal = coutTotal;
        this.etatProjet = etatProjet;
        this.client = client;
    }

    public Projet(Long Id,String nomProjet,Double margeBeneficiaire,Double coutTotal , StatutProject etatProjet , Client client){
        this.Id = Id;
        this.nomProjet = nomProjet ;
        this.margeBeneficiaire = margeBeneficiaire;
        this.coutTotal = coutTotal;
        this.etatProjet = etatProjet;
        this.client = client;
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

    public Client getClient(){
        return this.client;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public List<Composant> getListComposants(){
        return this.composants;
    }

    public void setComposants(List<Composant> composants){
        this.composants = composants;
    }



}
