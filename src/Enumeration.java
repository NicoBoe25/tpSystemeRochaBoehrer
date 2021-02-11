import java.util.*;

public class Enumeration {
    private ArrayList<Ville> listVilles;
    private HashMap<String, Double> stringTreeMap;


    public Enumeration(ArrayList<Ville> villeArrayList) {
        this.listVilles = villeArrayList;
        stringTreeMap = new HashMap<>();
        ArrayList<String> tab = new ArrayList<>(Arrays.asList("A","B","C","D","E","F"));
        permute(villeArrayList,0);

        System.out.println(stringTreeMap);
        double ddd = findMeilleureDistance();
        System.out.println(stringTreeMap.get(ddd) + " est le chemin le plus court\n" +
                "avec une distance de " + ddd);
    }


    private String toStringList(ArrayList<Ville> currentListVille) {
        String s = "";
        for (Ville ville : currentListVille) {
            s += ville.toString();
        }
        return s;
    }


    public double calculDistanceList(ArrayList<Ville> listVilles) {
        double distanceAParcourir = 0.0;
        ArrayList<Ville> temp = new ArrayList<>();
        for (Ville v : listVilles) {
            temp.add(v);
        }
        temp.add(new Ville("0", 0, 0));
        temp.add(0, new Ville("0", 0, 0));
        for (int i = 0; i < temp.size() - 1; i++) {
            distanceAParcourir += temp.get(i).calculDistance(temp.get(i + 1));
        }
        return distanceAParcourir;
    }


    public double findMeilleureDistance() {
        double bestResult = 9999999999999999.9;

        for (Map.Entry<String,Double> kv : this.stringTreeMap.entrySet()) {
            if (bestResult > kv.getValue()) {
                bestResult =  kv.getValue();
            }
        }
        return bestResult;
    }

    public int compteur() {
        return stringTreeMap.size();
    }

    public void permute(ArrayList<Ville> a, int k) {
        if (k == a.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < a.size(); i++) {
                sb.append(a.get(i).getNom());
            }
            stringTreeMap.put(sb.toString(),calculDistanceList(a));
        } else {
            for (int i = k; i < a.size(); i++) {
                Ville temp = a.get(k);
                a.set(k,a.get(i));
                a.set(i,temp);
                permute(a, k + 1);
                temp = a.get(k);
                a.set(k,a.get(i));
                a.set(i,temp);
            }
        }

    }
}