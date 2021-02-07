import java.util.ArrayList;

public class Enumeration {
    private ArrayList<Ville> listVilles;
    private ArrayList<Double> listDistancesParcours;

    private int idMeilleureSolution;
    public int getIdMeilleureSolution() {return idMeilleureSolution; }


    public Enumeration(ArrayList<Ville> villeArrayList) {
        this.listVilles = villeArrayList;
    }

    public double getMeilleureDistance(){
        double bestResult = 0.0;
        return bestResult;

    }
}
