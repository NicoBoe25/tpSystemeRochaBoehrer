import java.util.ArrayList;

public class Individu {



    private ArrayList<Ville> chemin = new ArrayList<>();
    private double fitness;
    private int id;


    private double note;

    public Individu(int id,ArrayList<Ville> listeVille){
        ArrayList<Ville> listeTemp = new ArrayList<>();
        listeTemp.addAll(listeVille);
        while(listeTemp.size()>1){
            int nb = (int) Math.floor(Math.random()*listeTemp.size());
            this.chemin.add(listeTemp.get(nb));
            listeTemp.remove(nb);
        }
        this.chemin.add(listeTemp.get(0));
        calculFitness();
        this.note=0;
        setId(id);

    }

    public void calculFitness(){
        Ville currentVille = new Ville("O",0,0);
        double depart = currentVille.calculDistance(chemin.get(0));
        double fin = currentVille.calculDistance(chemin.get(chemin.size()-1));
        double distanceChemin = calculDistance();
        setFitness(distanceChemin+depart+fin);
    }


    protected double calculDistance() {
        double d = 0.0;
        for (int i = 0; i < chemin.size()-1; i++) {
            d+= chemin.get(i).calculDistance(chemin.get(i+1));
        }
        return d;
    }

    public void print(){
        for(Ville ville : chemin){
            System.out.print(ville.getNom());
        }
        System.out.println();
    }



    public ArrayList<Ville> getChemin() {
        return chemin;
    }

    public void setChemin(ArrayList<Ville> chemin) {
        this.chemin = chemin;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
