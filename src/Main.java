public class Main {
    public static void main(String[] args) {
        GestionnaireReservations gestionnaire = new GestionnaireReservations();


        Salle sA101 = new Salle("A101", 30, true);
        Salle sB202 = new Salle("B202", 50, false);
        Salle sC303 = new Salle("C303", 20, true);


        Utilisateur uAlice = new Utilisateur("Alice", "alice@ecole.fr");
        Utilisateur uBob = new Utilisateur("Bob", "bob@ecole.fr");
        Utilisateur uCharlie = new Utilisateur("Charlie", "charlie@ecole.fr");

        System.out.println("--- AJOUT DES RÉSERVATIONS ---");

        gestionnaire.ajouterReservation(new Reservation(sA101, uAlice, "2026-01-10", "08h00-10h00"));
        gestionnaire.ajouterReservation(new Reservation(sB202, uBob, "2026-01-10", "10h00-12h00"));
        gestionnaire.ajouterReservation(new Reservation(sA101, uCharlie, "2026-01-11", "14h00-16h00"));
        gestionnaire.ajouterReservation(new Reservation(sC303, uAlice, "2026-01-10", "14h00-15h00"));


        gestionnaire.ajouterReservation(new Reservation(sA101, uBob, "2026-01-10", "08h00-10h00"));



        gestionnaire.afficherReservations();
        gestionnaire.afficherReservationsPourSalle("A101");
        gestionnaire.afficherReservationsPourDate("2026-01-10");


        System.out.println("\n--- TESTS DE DISPONIBILITÉ ---");
        System.out.println("A101 le 2026-01-10 [08h00-10h00] dispo ? " +
                gestionnaire.estSalleDisponible("A101", "2026-01-10", "08h00-10h00")); // Attendu: false

        System.out.println("A101 le 2026-01-10 [11h00-13h00] dispo ? " +
                gestionnaire.estSalleDisponible("A101", "2026-01-10", "11h00-13h00")); // Attendu: true

        System.out.println("B202 le 2026-01-10 [10h00-12h00] dispo ? " +
                gestionnaire.estSalleDisponible("B202", "2026-01-10", "10h00-12h00")); // Attendu: false


        System.out.println("\n--- TESTS DES BONUS ---");
        gestionnaire.afficherReservationsPourUtilisateur("alice@ecole.fr");
        gestionnaire.afficherCreneauxLibres("A101", "2026-01-10");
    }
}