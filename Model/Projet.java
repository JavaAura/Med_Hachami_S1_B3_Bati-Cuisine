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
    private List<MainOeuvre> labors;
    private List<Material> materials;



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

    public List<Material> getMaterials(){
        return this.materials;
    }

    public void setMaterials(List<Material> materials){
        this.materials = materials;
    }


    public List<MainOeuvre> getLabors(){
        return this.labors;
    }

    public void setLabors(List<MainOeuvre> labors){
        this.labors = labors;
    }
  


    // public double calculerCoutTotal(double tauxTVA, boolean appliquerMarge) {
    //     double coutMateriauxAvantTVA = 0;
    //     double coutMateriauxAvecTVA = 0;
    //     double coutMainOeuvreAvantTVA = 0;
    //     double coutMainOeuvreAvecTVA = 0;

    //     for (Composant composant : composants) {
    //         if (composant instanceof Material) {
    //             Material mat = (Material) composant;
    //             coutMateriauxAvantTVA += mat.calculerCoutAvantTVA();
    //             coutMateriauxAvecTVA += mat.calculerCoutAvecTVA(tauxTVA);
    //         } else if (composant instanceof MainOeuvre) {
    //             MainOeuvre mainOeuvre = (MainOeuvre) composant;
    //             coutMainOeuvreAvantTVA += mainOeuvre.calculerCoutAvantTVA();
    //             coutMainOeuvreAvecTVA += mainOeuvre.calculerCoutAvecTVA(tauxTVA);
    //         }
    //     }

    //     double coutTotalAvantMarge = coutMateriauxAvecTVA + coutMainOeuvreAvecTVA;
    //     double marge = 0;

    //     if (appliquerMarge) {
    //         marge = coutTotalAvantMarge * (margeBeneficiaire / 100);
    //     }

    //     this.coutTotal = coutTotalAvantMarge + marge;
    //     return this.coutTotal;
    // }

  



}
