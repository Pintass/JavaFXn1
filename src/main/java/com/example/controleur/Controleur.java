package com.example.controleur;

import com.example.modele.*;
import com.example.vue.Formulaire;
import com.example.vue.HBoxRoot;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class Controleur implements EventHandler {
    @Override
    public void handle(Event event) {
        PlanningCollections planning = HBoxRoot.getPlanning();
        Formulaire reservationPane = HBoxRoot.getFormulairePane();
        DateCalendrier selDate = new DateCalendrier();


        // la source de event est un ToggleButton du calendrier
        if (event.getSource() instanceof ToggleButton) {
            ToggleButton clickedButton = (ToggleButton)event.getSource();
            selDate = (DateCalendrier)clickedButton.getUserData();

            reservationPane.updateDateSel(selDate);
        }

        // la source de event est le bouton "Enregistrer" du formulaire de réservation
        if (event.getSource() instanceof Button) {
            Button clickedButton = (Button)event.getSource();
            String sCours = reservationPane.getTextFieldCours();
// =======
            // on récupère les informations des horaires afin de créer les horaires dans ce controleur
            Integer iHeureDebut = reservationPane.getHeureDebut();
            Integer iMinDebut = reservationPane.getHeureMinDebut();
            Integer iHeureFin = reservationPane.getHeureFin();
            Integer iMinFin = reservationPane.getMinHeureFin();
            // On crée les horaires désormais :
            Horaire hHoraireDebut = new Horaire(iHeureDebut, iMinDebut);
            Horaire hHoraireFin = new Horaire(iHeureFin, iMinFin);
            System.out.println(hHoraireDebut + " " + hHoraireFin);

            // Puis la plage horaire de la réservation, on mets un try catch car il peut y avoir une réservation
            try {
                System.out.println("date " + reservationPane.getDateRecord());
                PlageHoraire phPlageHoraireReservation = new PlageHoraire(hHoraireDebut, hHoraireFin);
                Reservation rReservation = new Reservation(reservationPane.getDateRecord(), phPlageHoraireReservation, sCours);
                System.out.println(rReservation);
                planning.ajout(rReservation);

                System.out.println(planning);
                reservationPane.updateMessageConfirmation("Réservation confirmée et ajoutée !");
            } catch (ExceptionPlanning e) {
                reservationPane.updateMessageConfirmation("Erreur, veuillez effectuer une réservation possible");
            }


        }
    }
}
