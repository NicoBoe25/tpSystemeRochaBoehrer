import java.util.ArrayList;

public class Glouton {

    private static ArrayList<Ville> liste = new ArrayList<>();

    public Glouton(ArrayList<Ville> _villes) {
        this.liste=_villes;
    }

    public double Distance(){

        double res = 0;

        for (int i=0; i<liste.size()-1; i++){
            res += liste.get(i).calculDistance(liste.get(i+1));
        }
        res += liste.get(liste.size()-1).calculDistance(liste.get(0));
        return res;
    }

    public void setListe(ArrayList<Ville> _liste){
        this.liste = _liste;
    }

}
