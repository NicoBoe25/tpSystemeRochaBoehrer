import java.util.ArrayList;

public class Glouton {

    private ArrayList<Ville> visitees;
    private ArrayList<Ville> non_visitees;
    private double distanceGlouton;

    public Glouton(ArrayList<Ville> list){
        this.non_visitees = list;
        this.visitees = new ArrayList<>();
        this.distanceGlouton = 0.0;

    }

    public void run(){
        Ville currentVille = new Ville("O",0,0);
        visitees.add(currentVille);
        while (!non_visitees.isEmpty()){
            Ville ville = nextVille(non_visitees, visitees.get(visitees.size()-1));
            visitees.add(ville);
            non_visitees.remove(ville);
        }
        visitees.add(currentVille);
        calculDistanceGlouton();
    }

    private void calculDistanceGlouton() {
        double d = 0.0;
        for (int i = 0; i < visitees.size()-1; i++) {
            d+= visitees.get(i).calculDistance(visitees.get(i+1));
        }
        setDistanceGlouton(d);
    }

    private Ville nextVille(ArrayList<Ville> listeVillesRestantes, Ville currentVille){
        ArrayList<Double> distanceList = new ArrayList<>();
        for (Ville v:listeVillesRestantes) {
            distanceList.add(currentVille.calculDistance(v));
        }
        double bestChoice = distanceList.get(0);
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
                else if (bestChoice==distanceList.get(i)){
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


    private Ville makeDecisionBetweenSameDistance(ArrayList<Ville> listVille) {
        String nameVilleReturn = listVille.get(0).getNom();
        int index=0;
        for (int i = 1; i < listVille.size() ; i++) {
            if (nameVilleReturn.compareTo(listVille.get(i).getNom()) > 0){
                nameVilleReturn = listVille.get(i).getNom();
                index=i;
            }
        }
        return listVille.get(index);
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
    public Double getDistanceGlouton() {
        return distanceGlouton;
    }

    public void setDistanceGlouton(Double distanceGlouton) {
        this.distanceGlouton = distanceGlouton;
    }

    public String listeToString(ArrayList<Ville> list){
        String res ="";
        for(Ville ville : list){
            res+=ville.getNom();
        }
        return res;
    }


}
