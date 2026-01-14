public class Reservation {
    private Salle salle;
    private Utilisateur utilisateur;
    private String date;
    private String creneau;

    public Reservation(Salle salle, Utilisateur utilisateur, String date, String creneau) {
        this.salle = salle;
        this.utilisateur = utilisateur;
        this.date = date;
        this.creneau = creneau;
    }

    public Salle getSalle() { return salle; }
    public Utilisateur getUtilisateur() { return utilisateur; }
    public String getDate() { return date; }
    public String getCreneau() { return creneau; }

    public String toString() {
        return "Réservation de " + utilisateur.toString()
                + " pour la salle " + salle.getNom()
                + " le " + date + " [" + creneau + "]";
    }
}