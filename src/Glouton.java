import java.util.ArrayList;

public class Glouton {


    private ArrayList<Ville> visitees;
    private ArrayList<Ville> non_visitees;
    private Glouton glouton;

    public Glouton(ArrayList<Ville> list){

    }

    public Ville nextVille(ArrayList<Ville> listeVillesRestantes, Ville currentVille){
        ArrayList<Double> distanceList = new ArrayList<>();
        for (Ville v:listeVillesRestantes) {
            distanceList.add(currentVille.calculDistance(v));
        }
        Double bestChoice = distanceList.get(0);
        int indexOfBestChoice = 0;
        int compteur=0;
        ArrayList<Ville> listVilleSameDistance = new ArrayList<>();
        listVilleSameDistance.add(currentVille);
        if (distanceList.size()>1){
            for (int i = 1; i < distanceList.size(); i++) {
                if (bestChoice > distanceList.get(i)){
                    bestChoice = distanceList.get(i);
                    indexOfBestChoice = i;
                }
                else if (bestChoice == distanceList.get(i)){
                    compteur++;
                    listVilleSameDistance.add(listeVillesRestantes.get(i));
                }
            }
        }
        if (compteur==0){
            return listeVillesRestantes.get(indexOfBestChoice);
        }else {
            return makeDecisionBetweenSameDistance(listVilleSameDistance);
        }
    }

    private Ville makeDecisionBetweenSameDistance(ArrayList<Ville> listVilleSameDistance) {
        ArrayList<Double> distanceToHome = new ArrayList<>();
        for (Ville ville:listVilleSameDistance) {

        }
        return null;
    }

    public ArrayList<Ville> getVisitees() {
        return visitees;
    }

    public void setVisitees(ArrayList<Ville> visitees) {
        this.visitees = visitees;
    }

    public ArrayList<Ville> getNon_visitees() {
        return non_visitees;
    }

    public void setNon_visitees(ArrayList<Ville> non_visitees) {
        this.non_visitees = non_visitees;
    }

    public Glouton getGlouton() {
        return glouton;
    }

    public void setGlouton(Glouton glouton) {
        this.glouton = glouton;
    }



}
