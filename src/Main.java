import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("Programme lancé");

        ArrayList<Ville> villeArrayList = createListSixVilles();


//        long startTime = System.currentTimeMillis();
//        Enumeration enumeration = new Enumeration(villeArrayList);
//        System.out.println("Possibilités trouvées : "+enumeration.compteur());
//        System.out.println("Timer task finished at:"+new Date());
//        long endTime = System.currentTimeMillis();
//        System.out.println("temps écoulé : "+(endTime - startTime)+" ms");
//
//
        long startTime2 = System.nanoTime();
        Glouton glouton = new Glouton(villeArrayList);
        glouton.run();
        System.out.println(glouton.listeToString(glouton.getVisitees()));
        System.out.println("Distance glouton "+glouton.getDistanceGlouton());
        long endTime2 = System.nanoTime();
        System.out.println("temps écoulé : "+(endTime2 - startTime2)+" ns");


        long startTime3 = System.nanoTime();
        GloutonDeuxVilles gloutonDeuxVilles = new GloutonDeuxVilles(villeArrayList);

        gloutonDeuxVilles.run();
        System.out.println(gloutonDeuxVilles.listeToString(gloutonDeuxVilles.getVisitees()));
        System.out.println("Distance glouton2 "+gloutonDeuxVilles.getDistanceGlouton());
        long endTime3 = System.nanoTime();
        System.out.println("temps écoulé : "+(endTime3 - startTime3)+" ns");


    }

    private static ArrayList<Ville> createListSixVilles() {
        Ville villeA = new Ville("A",1,1);
        Ville villeB = new Ville("B",2,2);
        Ville villeC = new Ville("C",1,3);
        Ville villeD = new Ville("D",3,2);
        Ville villeE = new Ville("E",3,5);
        Ville villeF = new Ville("F",7,2);

        ArrayList<Ville> villeArrayList = new ArrayList<>();
        villeArrayList.add(villeA);
        villeArrayList.add(villeB);
        villeArrayList.add(villeC);
        villeArrayList.add(villeD);
        villeArrayList.add(villeE);
        villeArrayList.add(villeF);
        return villeArrayList;
    }
}
