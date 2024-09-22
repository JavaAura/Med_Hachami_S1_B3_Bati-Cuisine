package Model;

public class MainOeuvre extends Composant {
    private double tauxHoraire;
    private double heureTravail;
    private double productiviteOuvrier;

  

    public MainOeuvre() {}

    public MainOeuvre(String nom, String typeComposant, double tauxTVA, Long projetId, double tauxHoraire, double heureTravail, double productiviteOuvrier) {
        super(nom, typeComposant, tauxTVA, projetId);
        this.tauxHoraire = tauxHoraire;
        this.heureTravail = heureTravail;
        this.productiviteOuvrier = productiviteOuvrier;
    }

    public MainOeuvre(Long Id, String nom, String typeComposant, double tauxTVA, Long projetId, double tauxHoraire, double heureTravail, double productiviteOuvrier) {
        super(Id, nom, typeComposant, tauxTVA, projetId);
        this.tauxHoraire = tauxHoraire;
        this.heureTravail = heureTravail;
        this.productiviteOuvrier = productiviteOuvrier;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public double getHeureTravail() {
        return heureTravail;
    }

    public void setHeureTravail(double heureTravail) {
        this.heureTravail = heureTravail;
    }

    public double getProductiviteOuvrier() {
        return productiviteOuvrier;
    }

    public void setProductiviteOuvrier(double productiviteOuvrier) {
        this.productiviteOuvrier = productiviteOuvrier;
    }

    // Methods for cost calculation
    public double calculerCoutAvantTVA() {
        return this.tauxHoraire * this.heureTravail * this.productiviteOuvrier;
    }

    public double calculerCoutAvecTVA(double costBeforeVAT) {
        return costBeforeVAT * (1 + this.tauxTVA / 100);
    }

}
