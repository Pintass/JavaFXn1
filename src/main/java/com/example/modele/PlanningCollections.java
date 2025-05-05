package com.example.modele;

import com.sun.source.tree.Tree;

import java.util.*;

public class PlanningCollections {
    private List<Reservation> chListe;
    private Set<Reservation> chSet;
    private TreeMap<Integer, Set<Reservation>> chSetWeek;

    public PlanningCollections() {
        chListe = new ArrayList <Reservation> ();
        chSet = new TreeSet <Reservation>();
        chSetWeek = new TreeMap<Integer, Set<Reservation>>();
    }

    public String toString(){
        return "ArrayList, taille : " + chListe.size() + " - " + chListe + "\n" + "TreeSet, taille : " + chSet.size() + " - " + chSet + "\n"
        + "TreeMap, taille : " + chSetWeek.size() + " - " + chSetWeek + "\n" ;
    }

    public void ajout(Reservation parReservation) throws ExceptionPlanning {
        // ArrayList
        Iterator<Reservation> iterateurListe = chListe.iterator();
        while (iterateurListe.hasNext()) {
            Reservation reserve = iterateurListe.next();
            if (parReservation.compareTo(reserve) == 0) throw new ExceptionPlanning(2);
        }
        chListe.add(parReservation);

        // TreeSet

        int sizeInitial = chSet.size();
        chSet.add(parReservation);
        if(sizeInitial == chSet.size()) throw new ExceptionPlanning(2);


    }

    /** getReservation permet de reçevoir toutes les réservations par rapport à une date donnée
    @params
    - DateCalendrier parDate
    @returns<
    - TreeSet <Reservation>
     */
    public TreeSet <Reservation> getReservations(DateCalendrier parDate) {
        TreeSet <Reservation> Setfinal = new TreeSet<Reservation>();
        Iterator<Reservation> iterateurD = chSet.iterator();

        while(iterateurD.hasNext()) {
            Reservation reserve = iterateurD.next();
            if (reserve.getDate() == parDate) {
                Setfinal.add(reserve);
            }
        }
        return Setfinal;
    }


    /** getReservation permet de reçevoir toutes les réservations par rapport à un intitulé donné
   @params
   - String parString
   @returns
   - TreeSet <Reservation>
    */
    public TreeSet <Reservation> getReservations(String parString) {
        TreeSet <Reservation> Setfinal = new TreeSet <Reservation>();
        Iterator<Reservation> iterateurD = chSet.iterator();

        while(iterateurD.hasNext()) {
            Reservation reserve = iterateurD.next();
            if (reserve.getIntitule().toLowerCase().contains(parString.toLowerCase())) { // contains permet de prendre tout ce qui contient parString
                // toLowerCase() permet de ne pas prendre en compte la casse !
                Setfinal.add(reserve);
            }
        }
        return Setfinal;
    }
    




}


