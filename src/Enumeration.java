import java.util.ArrayList;

public class Enumeration {
    private ArrayList<Ville> listVilles;
    private ArrayList<ArrayList<Ville>> listOfListVilles;
    private ArrayList<Double> listDistancesParcours;

    private int idMeilleureSolution;
    public int getIdMeilleureSolution() {return idMeilleureSolution; }
    public void setIdMeilleureSolution(int idMeilleureSolution) {this.idMeilleureSolution = idMeilleureSolution;}

    public Enumeration(ArrayList<Ville> villeArrayList) {
        this.listVilles = villeArrayList;
        listDistancesParcours = new ArrayList<>();

    }

    public void setListDistancesParcours(){
        for (int i = 0; i < listOfListVilles.size(); i++) {
            double distanceAParcourir =0.0;
            ArrayList<Ville> tempArrayList = listOfListVilles.get(i);
            for (int j = 0; j < listOfListVilles.get(i).size()-1; j++) {
                distanceAParcourir += tempArrayList.get(j).calculDistance(tempArrayList.get(j+1));
            }
            listDistancesParcours.add(distanceAParcourir);
        }
    }


    public void findMeilleureDistance(){
        double bestResult = listDistancesParcours.get(0);
        for (int i = 1; i < listDistancesParcours.size(); i++) {
            if (bestResult<listDistancesParcours.get(i)){
                bestResult = listDistancesParcours.get(i);
                setIdMeilleureSolution(i);
            }
        }
    }
}
