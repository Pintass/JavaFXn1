package com.example.modele;

import javafx.scene.control.Label;

import java.util.*;

public class PlanningCollections {
    private List <Reservation> chListReservations;
    private Set <Reservation> chSetReservations;
    private Map <Integer, Set<Reservation>> chMapReservations;
    public PlanningCollections(){
        chListReservations = new ArrayList<Reservation>();
        chSetReservations = new TreeSet<Reservation>();
        chMapReservations = new TreeMap<Integer, Set<Reservation>>();
    }

    /**
     * ajout de parReservation (classe Reservation) à la liste des réservations et au set des réservations
     *
     * @param parReservation
     * @throws ExceptionPlanning
     *
     * leve ExcpetionPlanning quand parReservation n'est pas compatible avec une reservation de planning
     */

    public void ajout (Reservation parReservation) throws ExceptionPlanning{
        // ajout à la liste
        // parcours avec itérateur
        Iterator<Reservation> iterateur = chListReservations.iterator();
        while (iterateur.hasNext()){
            Reservation reserve = iterateur.next();
            if (parReservation.compareTo(reserve) == 0)
                throw new ExceptionPlanning(2);
        }
        chListReservations.add(parReservation);
        // ajout au set
        int sizeInitial = chSetReservations.size();
        chSetReservations.add(parReservation);
        if (sizeInitial == chSetReservations.size())
            throw new ExceptionPlanning(2);
        chSetReservations.add(parReservation);
        // ajout au map
        int numSemaine = ((DateCalendrier) parReservation.getDate()).getWeekOfYear();
        Set<Reservation> set = chMapReservations.get(numSemaine);
        if(set == null){
            set = new TreeSet<>();
            set.add(parReservation);
            chMapReservations.put(numSemaine, set);
        }
        else{
            int nbre = set.size();
            set.add(parReservation);
            if (nbre==set.size()){
                throw new ExceptionPlanning(1);
            }
        }
    }

    /**
     * Retourne l'ensemble des réservations du planning contenant la date passé en paramètre.
     *
     * @param parDate
     * @return TreeSet <Reservation>
     */
    public TreeSet <Reservation> getReservations (DateCalendrier parDate){
        TreeSet <Reservation> setReservationsJour = new TreeSet<Reservation>();
        Iterator <Reservation> iterateur = chSetReservations.iterator();
        while (iterateur.hasNext()){
            Reservation resJour = iterateur.next();
            if (resJour.getDate().compareTo(parDate) == 0){
                setReservationsJour.add(resJour);
            }
        }
        if (setReservationsJour.isEmpty()){
            return null;
        }
        return setReservationsJour;
    }

    /*public TreeSet <Reservation> getReservations (String parString){
        TreeSet <Reservation> setReservationsString = new TreeSet<Reservation>();
        Iterator <Reservation> iterateur = chSetReservations.iterator();
        while (iterateur.hasNext()){
            Reservation resString = iterateur.next();
            if (resString.getIntitule().toLowerCase().contains(parString.toLowerCase())){
                setReservationsString.add(resString);
            }
        }
        if (setReservationsString.isEmpty()){
            return null;
        }
        return setReservationsString;
    }*/

    public String toString(){
        return "treeSet" + chSetReservations.size() + "-" + chSetReservations + "\n"
                + "arrayList" + chListReservations.size() + "-" + chListReservations + "\n"
                + "treeMap" + chMapReservations.size() + "-" + chMapReservations + "\n";
    }

    public Map<Integer, Set<Reservation>> getReservations() {
        return chMapReservations;
    }

}
