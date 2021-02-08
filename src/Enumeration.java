import java.util.*;

public class Enumeration {
    private ArrayList<Ville> listVilles;
    private HashMap<Double, String> stringTreeMap;


    public Enumeration(ArrayList<Ville> villeArrayList) {
        this.listVilles = villeArrayList;
        stringTreeMap = new HashMap<>();
        makeHeapList(listVilles.size(),listVilles);

        System.out.println(stringTreeMap);
        double ddd = findMeilleureDistance();
        System.out.println(stringTreeMap.get(ddd)+" est le chemin le plus court\n" +
                "avec une distance de " +ddd);
    }

    public void makeHeapList(int k, ArrayList<Ville> currentListVille){
        if (k==1){
            String s = toStringList(currentListVille);
            Double d = calculDistanceList(currentListVille);
            stringTreeMap.put(d,s);
        }else {
            makeHeapList(k-1, currentListVille);
            for (int i = 0; i < k-2; i++) {
                if (k%2==0){
                    Collections.swap(currentListVille,i,k-1);
                }else {
                    Collections.swap(currentListVille,0,k-1);
                }
                makeHeapList(k-1,currentListVille);
            }
        }
    }

    private String toStringList(ArrayList<Ville> currentListVille) {
        String s ="";
        for (Ville ville: currentListVille) {
            s+=ville.toString();
        }
        return s;
    }


    public double calculDistanceList(ArrayList<Ville> listVilles){
        double distanceAParcourir=0.0;
        ArrayList<Ville> temp = new ArrayList<>();
        for (Ville v:listVilles) {
            temp.add(v);
        }
        temp.add(new Ville("0",0,0));
        temp.add(0,new Ville("0",0,0));
        for (int i = 0; i < temp.size()-1; i++) {
            distanceAParcourir += temp.get(i).calculDistance(temp.get(i+1));
        }
        return distanceAParcourir;
    }

    public double findMeilleureDistance(){
        double bestResult = 9999999999999999.9;
        for (Double aDouble:this.stringTreeMap.keySet()) {
            if (bestResult>aDouble){
                bestResult = aDouble;
            }
        }
        return bestResult;
    }
}
