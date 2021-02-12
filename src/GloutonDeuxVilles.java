import java.util.ArrayList;

public class GloutonDeuxVilles extends Glouton {

    private ArrayList<Ville> visitees;
    private ArrayList<Ville> non_visitees;
    private double distanceGlouton;

    public GloutonDeuxVilles(ArrayList<Ville> list){
        super();
        this.non_visitees=list;
        this.distanceGlouton=0.0;
        this.visitees=new ArrayList<>();
    }

    @Override
    public void run(){
        Ville currentVille = new Ville("O",0,0);
        visitees.add(currentVille);
        while (non_visitees.size()>2){
            Ville ville = nextVille(non_visitees, visitees.get(visitees.size()-1));
            visitees.add(ville);
            non_visitees.remove(ville);
        }
        visitees.addAll(non_visitees);
        visitees.add(currentVille);
        calculDistance();
    }

    @Override
    public Ville nextVille(ArrayList<Ville> villes, Ville currentVille){
        double bestDistance = Double.MAX_VALUE;
        int indexBestDistance = 0;
        for (int i = 0; i < villes.size(); i++) {
            for (int j = 0; j < villes.size(); j++) {
                if (i!=j){
                    double currentDistance = currentVille.calculDistance(villes.get(i))+villes.get(i).calculDistance(villes.get(j));
                    if (currentDistance<bestDistance){
                        bestDistance=currentDistance;
                        indexBestDistance=i;
                    }
                }
            }
        }
        return villes.get(indexBestDistance);
    }

    protected void calculDistance() {
        double d = 0.0;
        for (int i = 0; i < visitees.size()-1; i++) {
            d+= visitees.get(i).calculDistance(visitees.get(i+1));
        }
        setDistanceGlouton(d);
    }


    @Override
    public ArrayList<Ville> getVisitees() {
        return visitees;
    }

    @Override
    public void setVisitees(ArrayList<Ville> visitees) {
        this.visitees = visitees;
    }

    @Override
    public ArrayList<Ville> getNon_visitees() {
        return non_visitees;
    }

    @Override
    public void setNon_visitees(ArrayList<Ville> non_visitees) {
        this.non_visitees = non_visitees;
    }

    @Override
    public double getDistanceGlouton() {
        return distanceGlouton;
    }

    public void setDistanceGlouton(double distanceGlouton) {
        this.distanceGlouton = distanceGlouton;
    }

}
