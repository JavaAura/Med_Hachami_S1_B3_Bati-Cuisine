package Model;

public class Material extends Composant {
    private double quantity;
    private double coefficientQualite;
    protected double coutUnitaire;
    protected double coutTransport;


    public Material() {}

    public Material(String nom, String typeComposant, double tauxTVA, double coutUnitaire, double coutTransport, Long projetId, double quantity, double coefficientQualite) {
        super(nom, typeComposant, tauxTVA, projetId);
        this.quantity = quantity;
        this.coefficientQualite = coefficientQualite;
        this.coutUnitaire = coutUnitaire;
        this.coutTransport = coutTransport;
    }

    public Material(Long Id, String nom, String typeComposant, double tauxTVA, double coutUnitaire, double coutTransport, Long projetId, double quantity, double coefficientQualite) {
        super(Id, nom, typeComposant, tauxTVA, projetId);
        this.quantity = quantity;
        this.coefficientQualite = coefficientQualite;
        this.coutUnitaire = coutUnitaire;
        this.coutTransport = coutTransport;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCoefficientQualite() {
        return coefficientQualite;
    }

    public void setCoefficientQualite(double coefficientQualite) {
        this.coefficientQualite = coefficientQualite;
    }

    public double getCoutUnitaire() {
        return coutUnitaire;
    }

    public void setCoutUnitaire(double coutUnitaire) {
        this.coutUnitaire = coutUnitaire;
    }

    public double getCoutTransport() {
        return coutTransport;
    }

    public void setCoutTransport(double coutTransport) {
        this.coutTransport = coutTransport;
    }

    // Methods for cost calculation
    public double calculerCoutAvantTVA() {
        return (this.coutUnitaire * this.quantity * this.coefficientQualite) + this.coutTransport;
    }

    public double calculerCoutAvecTVA(double couTotalBeforeTVA) {
        return couTotalBeforeTVA * (1 + this.tauxTVA / 100);
    }

}
