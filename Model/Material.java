package Model;

public class Material extends Composant {
    private double quantity;
    private double coutTransport;

    public Material(){}

    public Material(Long Id , String nom, String typeComposant, double tauxTva , double quantity , double coutTransport){
        super(Id, nom ,typeComposant ,tauxTva);
        this.quantity = quantity;
        this.coutTransport = coutTransport;
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

}
