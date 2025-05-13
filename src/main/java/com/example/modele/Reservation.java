package com.example.modele;

public class Reservation implements Comparable<Reservation>{
    private DateCalendrier dateReservation;
    private PlageHoraire plageHoraireReservation;
    private String chIntituleReservation;

    public Reservation (DateCalendrier parDate, PlageHoraire parPlageHoraire, String parIntitule) throws ExceptionPlanning {
        if (parIntitule == null) throw new ExceptionPlanning(5);

        dateReservation = parDate;
        plageHoraireReservation = parPlageHoraire;
        chIntituleReservation = parIntitule;
    }

    public String toString() {
        return "Réservation " + chIntituleReservation + " le : " + dateReservation + " de " + plageHoraireReservation;
    }

    @Override
    public int compareTo(Reservation parReservation) {
       if (parReservation.dateReservation.compareTo(dateReservation) == 0)
                return parReservation.plageHoraireReservation.compareTo(plageHoraireReservation);
       return parReservation.dateReservation.compareTo(dateReservation);
    }

    public Date getDate() {
        return dateReservation;
    }

    public String getIntitule(){ return chIntituleReservation; }

    public PlageHoraire getHoraire(){
        return plageHoraireReservation;
    }

    public boolean estValide(){
        return dateReservation.estValide() && plageHoraireReservation.estValide() && chIntituleReservation != null && chIntituleReservation.length() != 0;

    }
}
