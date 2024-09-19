package Model;

public abstract class Composant {
    private Long Id;
    private String nom;
    private String typeComposant;

    public Composant(){}

    public Composant(String nom, String typeComposant){
        this.nom = nom;
        this.typeComposant = typeComposant;
    }

    public Composant(Long Id ,String nom, String typeComposant){
        this.Id = Id;
        this.nom = nom;
        this.typeComposant = typeComposant;
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

    
}
