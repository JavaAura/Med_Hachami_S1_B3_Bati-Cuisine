package Model;

public class Material extends Composant {
    private double coutUnitaire;
    private double quantity;
    private double coutTransport;
    private double coefficientQualite;

    public Material(){}

    public Material(Long Id , String nom, String typeComposant, double tauxTva , double coutUnitaire  ,double quantity , double coutTransport , double coefficientQualite){
        super(Id, nom ,typeComposant ,tauxTva);
        this.coutUnitaire = coutUnitaire;
        this.quantity = quantity;
        this.coutTransport = coutTransport;
        this.coefficientQualite = coefficientQualite;
    }

    public  double getQuantity(){
        return this.quantity;
    }

    public void setQuantity(double quantity){
        this.quantity = quantity;
    }

    public double getCoutTransport(){
        return this.coutTransport;
    }

    public void setCoutTransport(double coutTransport){
        this.coutTransport = coutTransport; 
    }

    public double calculerCout() {
        return (this.quantity * this.coutUnitaire * this.coefficientQualite )+ this.coutTransport;
    }

}
