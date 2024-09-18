package Model;

public class Composant {
    private Long Id;
    private String nom;
    private String typeComposant;
    private double tauxTva;

    public Composant(){}

    public Composant(String nom, String typeComposant, double tauxTva){
        this.nom = nom;
        this.typeComposant = typeComposant;
        this.tauxTva = tauxTva;
    }

    public Composant(Long Id ,String nom, String typeComposant, double tauxTva){
        this.Id = Id;
        this.nom = nom;
        this.typeComposant = typeComposant;
        this.tauxTva = tauxTva;
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

    public String getTypeComposant(){
        return this.typeComposant;
    }

    public void setTypeComposant(String typeComposant){
        this.typeComposant = typeComposant;
    }

    public double getTauxTva(){
        return this.tauxTva;
    }

    public void setTauxTva(double tauxTva){
        this.tauxTva = tauxTva;
    }
}
