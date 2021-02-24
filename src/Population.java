import java.lang.reflect.Array;
import java.util.ArrayList;

public class Population {



    private ArrayList<Individu> listeIndividu;

    public Population(int size, ArrayList<Ville> listeVille){
        listeIndividu = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            listeIndividu.add(new Individu(i,listeVille));
        }
        //chercher le + grand chemin
        double valeurMax = 0;
        for (Individu ind:listeIndividu) {
            if(ind.getFitness()>valeurMax){
                valeurMax=ind.getFitness();
            }
        }
        //noter en comparant
        for (Individu ind:listeIndividu) {
            ind.setNote((ind.getFitness()/valeurMax)*100);
        }
    }



    public ArrayList<Individu> getListeIndividu() {
        return listeIndividu;
    }

    public void setListeIndividu(ArrayList<Individu> listeIndividu) {
        this.listeIndividu = listeIndividu;
    }
}
