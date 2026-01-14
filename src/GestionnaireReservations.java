import java.util.ArrayList;
import java.util.List;

public class GestionnaireReservations {
    private List<Reservation> reservations;

    // Définition des créneaux standards pour le Bonus 3
    private static final String[] CRENEAUX_JOURNEE = {
            "08h00-10h00", "10h00-12h00", "14h00-16h00", "16h00-18h00"
    };

    public GestionnaireReservations() {
        this.reservations = new ArrayList<>();
    }

    // BONUS 1 : Empêche les chevauchements de réservations
    public void ajouterReservation(Reservation reservation) {
        if (estSalleDisponible(reservation.getSalle().getNom(), reservation.getDate(), reservation.getCreneau())) {
            reservations.add(reservation);
            System.out.println("✅ Succès : " + reservation.toString());
        } else {
            System.out.println("❌ Échec : La salle " + reservation.getSalle().getNom() + " est déjà réservée le " + reservation.getDate() + " pour le créneau " + reservation.getCreneau() + ".");
        }
    }

    public void afficherReservations() {
        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation enregistrée.");
            return;
        }
        System.out.println("\n--- Liste de toutes les réservations ---");
        for (Reservation r : reservations) {
            System.out.println(r.toString());
        }
    }

    public void afficherReservationsPourSalle(String nomSalle) {
        System.out.println("\n--- Réservations pour la salle : " + nomSalle + " ---");
        boolean trouve = false;
        for (Reservation r : reservations) {
            if (r.getSalle().getNom().equalsIgnoreCase(nomSalle)) {
                System.out.println(r.toString());
                trouve = true;
            }
        }
        if (!trouve) System.out.println("Aucune réservation pour cette salle.");
    }

    public void afficherReservationsPourDate(String date) {
        System.out.println("\n--- Réservations pour la date : " + date + " ---");
        boolean trouve = false;
        for (Reservation r : reservations) {
            if (r.getDate().equals(date)) {
                System.out.println(r.toString());
                trouve = true;
            }
        }
        if (!trouve) System.out.println("Aucune réservation pour cette date.");
    }

    public boolean estSalleDisponible(String nomSalle, String date, String creneau) {
        for (Reservation r : reservations) {
            if (r.getSalle().getNom().equalsIgnoreCase(nomSalle) &&
                    r.getDate().equals(date) &&
                    r.getCreneau().equals(creneau)) {
                return false; // Salle déjà occupée
            }
        }
        return true; // Salle libre
    }

    // BONUS 2 : Chercher les réservations par utilisateur
    public void afficherReservationsPourUtilisateur(String email) {
        System.out.println("\n--- Réservations pour l'utilisateur : " + email + " ---");
        boolean trouve = false;
        for (Reservation r : reservations) {
            if (r.getUtilisateur().getEmail().equalsIgnoreCase(email)) {
                System.out.println(r.toString());
                trouve = true;
            }
        }
        if (!trouve) System.out.println("Aucune réservation pour cet utilisateur.");
    }

    // BONUS 3 : Trouver les créneaux libres
    public void afficherCreneauxLibres(String nomSalle, String date) {
        System.out.println("\n--- Créneaux libres pour " + nomSalle + " le " + date + " ---");
        boolean toutOccupe = true;
        for (String creneau : CRENEAUX_JOURNEE) {
            if (estSalleDisponible(nomSalle, date, creneau)) {
                System.out.println("✅ " + creneau + " est libre.");
                toutOccupe = false;
            }
        }
        if (toutOccupe) System.out.println("Tous les créneaux sont occupés ce jour-là.");
    }
}