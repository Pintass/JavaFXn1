package com.example.modele;

public class Planning {
    private static final byte TAILLE = 4;
    private Reservation[] reservations;

    public Planning() {
//        TAILLE = parTaille; //on a ajouté static
        reservations = new Reservation[TAILLE];
        ;
    }

    /**
     * @return
     */
    public String toString() {
        String reservationsStr = "Liste des réservations: ";
        for (int i = 0; i < reservations.length; i++) {
            if (reservations[i] != null) {
                reservationsStr += "\n" + reservations[i];
            } else break;
        }
        return reservationsStr;
    }


    /**
     * Ajout d'une réservation.
     *
     * @param parReservation
     * @return true lorsque :
     * parReservation est valide
     * compatible avec les autres reservations
     * et que le tableau n'est pas plein
     * Dans ce cas la réservation est ajoutée
     */
    public void ajout(Reservation parReservation) throws ExceptionPlanning {
        if (!parReservation.estValide()) throw new ExceptionPlanning(0);
        if (reservations[TAILLE - 1] != null) throw new ExceptionPlanning(1);
        for (int i = 0; i < TAILLE; i++) {
            if (reservations[i] == null) {
                reservations[i] = parReservation;
                break;
            }
            if (reservations[i].compareTo(parReservation) == 0) throw new ExceptionPlanning(2);
        }
    }


    public Reservation getReservation(Date parDate) {
        for (int i = 0; i < TAILLE; i++) {
            if (reservations[i] != null) {
                if (reservations[i].getDate().compareTo(parDate) == 0) {
                    return reservations[i];
                }
            } else break;
        }
        return null;
    }

    public Reservation[] getReservations(Date parDate) {
        Reservation[] reservationsDate = new Reservation[TAILLE];
        byte k = 0;
        byte i = 0;
        while (i < TAILLE) {
            if (reservations[i] != null) {
                if (reservations[i].getDate().compareTo(parDate) == 0) {
                    reservationsDate[k] = reservations[i];
                    k++;
                }
            } else break;
            i++;
        }

        return reservationsDate;
    }
}