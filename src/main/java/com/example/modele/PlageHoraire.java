package com.example.modele;

import static java.lang.Math.abs;

public class PlageHoraire {
    private final static int DUREE_MINI = 10;
    private Horaire horaireDebut;
    private Horaire horaireFin;

    public PlageHoraire(Horaire parHoraireDebut, Horaire parHoraireFin) throws ExceptionPlanning {
        if (parHoraireFin.getHeure() < parHoraireDebut.getHeure()) throw new ExceptionPlanning(3);
        horaireDebut = parHoraireDebut;
        horaireFin = parHoraireFin;
    }

    /**
     * Est valide retourne true quand la plage horaire this est valide.
     * On suppose que l'horaire est déja valide.
     *
     * @return boolean
     */
    public boolean estValide() {
        return horaireFin.toMinutes() - horaireDebut.toMinutes() > DUREE_MINI;
    }

    ;

    /**
     * Retourne l'horaire du début, l'horaire de fin et la durée séparant les deux.
     *
     * @return String
     */
    public String toString() {
        int duree = duree();
        int heure = 0;
        while (duree >= 60) {
            duree -= 60;
            heure++;
        }

        return horaireDebut + " à " + horaireFin + " duree :" + abs(heure) + "h" + abs(duree);
    }

    /**
     * Permet de calculer la différence de tem
     *
     * @return int
     */
    public int duree() {
        return horaireFin.toMinutes() - horaireDebut.toMinutes();
    }


    public int compareTo(PlageHoraire parPlageHoraire) {
        if (parPlageHoraire.horaireDebut.toMinutes() >= horaireFin.toMinutes() && horaireDebut.toMinutes() <= parPlageHoraire.horaireDebut.toMinutes())
            return -1;
        if (parPlageHoraire.horaireFin.toMinutes() <= horaireDebut.toMinutes() && horaireFin.toMinutes() >= parPlageHoraire.horaireFin.toMinutes())
            return 1;
        return 0;
    }

}
