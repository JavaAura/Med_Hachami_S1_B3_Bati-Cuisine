package Model;

public class MainOeuvre extends Composant {
    private double tauxHoraire;
    private double heureTravail;
    private double productiviteOuvrier;

    public MainOeuvre(){}

    public MainOeuvre(Long Id , String nom, String typeComposant, double tauxTva ,double tauxHoraire , double heureTravail,double productiviteOuvrier){
        super(Id, nom ,typeComposant ,tauxTva);
        this.tauxHoraire = tauxHoraire;
        this.heureTravail = heureTravail;
        this.productiviteOuvrier = productiviteOuvrier;
    }

    public double getTauxHoraire(){
        return this.tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire){
        this.tauxHoraire = tauxHoraire;
    }

    public double getHeureTravail(){
        return this.heureTravail;
    }

    public void setHeureTravaille(double heureTravail){
        this.heureTravail = heureTravail;
    }

    public double getProductiviteOuvrier(){
        return this.productiviteOuvrier;
    }

    public void setProductiviteOuvrier(double productiviteOuvrier){
        this.productiviteOuvrier = productiviteOuvrier;
    }

    public double calculerCout() {
        return this.tauxHoraire * this.heureTravail * this.productiviteOuvrier;
    }
}
