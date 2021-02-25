import java.lang.reflect.Array;
import java.util.ArrayList;

public class Population {



    private ArrayList<Individu> listeIndividu;

    public Population(int size, ArrayList<Ville> listeVille){
        listeIndividu = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            listeIndividu.add(new Individu(i,listeVille,true));
        }
        //chercher le + grand chemin
        double valeurMax = 0;
        for (Individu ind:listeIndividu) {
            if(ind.getDistance()>valeurMax){
                valeurMax=ind.getDistance();
            }
        }
        //noter en comparant
        for (Individu ind:listeIndividu) {
            ind.setNote((1/ind.getDistance()));
        }
    }

    public Population(ArrayList<Individu> listeIndividu){
        this.listeIndividu = new ArrayList<>();
        this.listeIndividu.addAll(listeIndividu);
    }


    public Population nextGen(){
        ArrayList<Individu> newPopulation = new ArrayList<>();
        for (int i = 0; i < this.listeIndividu.size(); i++) {
            int indi1 = (int) Math.floor(Math.random()*listeIndividu.size());
            int indi2 = (int) Math.floor(Math.random()*listeIndividu.size());
            newPopulation.add(listeIndividu.get(indi1).croise(listeIndividu.get(indi2)));
        }
        return new Population(newPopulation);
    }


    public Individu findBestIndividu(){
        double bestChoice = Double.MIN_VALUE;
        int id=0;
        for (int i = 0; i < listeIndividu.size(); i++) {
            if (listeIndividu.get(i).getNote()>bestChoice){
                bestChoice=listeIndividu.get(i).getNote();
                id = i;
            }
        }
        return listeIndividu.get(id);
    }

    public ArrayList<Individu> getListeIndividu() {
        return listeIndividu;
    }

    public void setListeIndividu(ArrayList<Individu> listeIndividu) {
        this.listeIndividu = listeIndividu;
    }
}
