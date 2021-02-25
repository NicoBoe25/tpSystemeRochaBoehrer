import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Individu {



    private ArrayList<Ville> chemin = new ArrayList<>();
    private double distance;
    private int id;


    private double note;

    public Individu(int id,ArrayList<Ville> listeVille,boolean randomize){
        ArrayList<Ville> listeTemp = new ArrayList<>();
        listeTemp.addAll(listeVille);
        if(randomize) {
            while (listeTemp.size() > 1) {
                int nb = (int) Math.floor(Math.random() * listeTemp.size());
                this.chemin.add(listeTemp.get(nb));
                listeTemp.remove(nb);
            }
            this.chemin.add(listeTemp.get(0));
        }else {
            this.chemin.addAll(listeVille);
        }

        calculDistanceChemin();
        this.note=0;
        setId(id);

    }

    public void calculDistanceChemin(){
        Ville currentVille = new Ville("O",0,0);
        double depart = currentVille.calculDistance(chemin.get(0));
        double fin = currentVille.calculDistance(chemin.get(chemin.size()-1));
        double distanceChemin = calculDistance();
        setDistance(distanceChemin+depart+fin);
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


    public Individu croise(Individu partenaire){
        double mutationRate = 0.25;
        ArrayList<Ville> phenotypeP = this.chemin;
        ArrayList<Ville> phenotypeM = partenaire.chemin;
        ArrayList<Ville> phenotypeE = new ArrayList<>();
        for (int i = 0; i < phenotypeM.size(); i++) {
            double val = Math.random();
            // sup à 0.5 -> mère
            if (val>=0.5){
                if(!phenotypeE.contains(phenotypeM.get(i))) {
                    phenotypeE.add(i,phenotypeM.get(i));
                }else if(!phenotypeE.contains(phenotypeP.get(i))){
                    phenotypeE.add(i,phenotypeP.get(i));
                }
            }else {
                if (!phenotypeE.contains(phenotypeP.get(i))) {
                    phenotypeE.add(i,phenotypeP.get(i));
                } else if (!phenotypeE.contains(phenotypeM.get(i))) {
                    phenotypeE.add(i,phenotypeM.get(i));
                }
            }
            if(phenotypeE.size()!=i+1){
                for (int j = 0; j < i ; j++) {
                    if(!phenotypeE.contains(phenotypeM.get(j))){
                        phenotypeE.add(i,phenotypeM.get(j));
                    }else if(!phenotypeE.contains(phenotypeP.get(j))){
                        phenotypeE.add(i,phenotypeP.get(j));
                    }
                }
            }
        }

        if(Math.random()<mutationRate){
            //to comment for no mutations
            //phenotypeE = mute(phenotypeE);
        }
        return new Individu(555, phenotypeE,false);

    }

    public ArrayList<Ville> mute(ArrayList<Ville> list){
        int id1ToSwap = new Random().nextInt(list.size());
        int id2ToSwap = id1ToSwap;
        do{
            id2ToSwap = new Random().nextInt(list.size());
        }while(id2ToSwap==id1ToSwap);
        Collections.swap(list,id1ToSwap,id2ToSwap);

        return list;
    }


    public void afficheListe(ArrayList<Ville> list){
        System.out.println("liste = ");
        for (Ville v:list) {
            System.out.print(v.getNom());
        }
        System.out.println();

    }

    public ArrayList<Ville> getChemin() {
        return chemin;
    }

    public void setChemin(ArrayList<Ville> chemin) {
        this.chemin = chemin;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double fitness) {
        this.distance = fitness;
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

    @Override
    public String toString() {
         afficheListe(this.chemin);
         return "distance = "+distance;

    }
}
