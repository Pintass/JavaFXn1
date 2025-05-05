package com.example.modele;

public class Reservation {
    private Date dateReservation;
    private PlageHoraire plageHoraireReservation;
    private String chIntituleReservation;

    public Reservation (Date parDate, PlageHoraire parPlageHoraire, String parIntitule) throws ExceptionPlanning {
        if (parIntitule == null) throw new ExceptionPlanning(5);

        dateReservation = parDate;
        plageHoraireReservation = parPlageHoraire;
        chIntituleReservation = parIntitule;
    }

    public String toString() {
        return "Réservation " + chIntituleReservation + " le : " + dateReservation + " de " + plageHoraireReservation;
    }

    public int compareTo(Reservation parReservation) {
        switch (parReservation.dateReservation.compareTo(dateReservation)) {
            case 0:
                return parReservation.plageHoraireReservation.compareTo(plageHoraireReservation);
            case -1:
                return -1;
            case 1:
                return 1;
        }
        return 0;
    }

    public Date getDate() {
        return dateReservation;
    }

    public String getIntitule(){ return chIntituleReservation; }

    public boolean estValide(){
        return dateReservation.estValide() && plageHoraireReservation.estValide() && chIntituleReservation != null && chIntituleReservation.length() != 0;

    }
}
