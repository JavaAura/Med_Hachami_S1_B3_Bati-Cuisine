package Model;

public abstract class Composant {
    private Long Id;
    private String nom;
    private String typeComposant;
    protected double tauxTVA;
    private Long projetId;
    

    public Composant(Long Id, String nom, String typeComposant, double tauxTVA, Long projetId) {
        this.Id = Id;
        this.nom = nom;
        this.typeComposant = typeComposant;
        this.tauxTVA = tauxTVA;
        this.projetId = projetId;
    }

    public Composant(String nom, String typeComposant, double tauxTVA, Long projetId) {
        this.nom = nom;
        this.typeComposant = typeComposant;
        this.tauxTVA = tauxTVA;
        this.projetId = projetId;
    }

    public Composant() {}

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypeComposant() {
        return typeComposant;
    }

    public void setTypeComposant(String typeComposant) {
        this.typeComposant = typeComposant;
    }

    public double getTauxTVA() {
        return tauxTVA;
    }

    public void setTauxTVA(double tauxTVA) {
        this.tauxTVA = tauxTVA;
    }

    public Long getProjetId() {
        return projetId;
    }

    public void setProjetId(Long projetId) {
        this.projetId = projetId;
    }





}
