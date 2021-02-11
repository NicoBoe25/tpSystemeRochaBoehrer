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
        String keyString = findMeilleureDistance();
        System.out.println(keyString +  " est le chemin le plus court\n" +
                "avec une distance de " + stringTreeMap.get(keyString));
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


    public String findMeilleureDistance() {
        double bestResult = Double.MAX_VALUE;
        String keyString = "";
        for (Map.Entry<String,Double> kv : this.stringTreeMap.entrySet()) {
            if (bestResult > kv.getValue()) {
                bestResult =  kv.getValue();
                keyString=kv.getKey();
            }
        }
        return keyString;
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