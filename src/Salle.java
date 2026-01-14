public class Salle {
    private String nom;
    private int capacite;
    private boolean aProjecteur;

    public Salle(String nom, int capacite, boolean aProjecteur) {
        this.nom = nom;
        this.capacite = capacite;
        this.aProjecteur = aProjecteur;
    }

    public String getNom() { return nom; }
    public int getCapacite() { return capacite; }
    public boolean isAProjecteur() { return aProjecteur; }

    public String getDescription() {
        String projecteur = aProjecteur ? "oui" : "non";
        return "Salle " + nom + " (capacité: " + capacite + ", projecteur: " + projecteur + ")";
    }
}