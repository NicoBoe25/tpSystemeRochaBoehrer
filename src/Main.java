import java.util.ArrayList;

public class Main {
    static Ville villeA = new Ville("A",1,1);
    static Ville villeB = new Ville("B",2,2);
    static Ville villeC = new Ville("C",1,3);
    static Ville villeD = new Ville("D",3,2);
    static Ville villeE = new Ville("E",3,5);
    static Ville villeF = new Ville("F",7,2);
    static Ville villeG = new Ville("G",7,5);
    static Ville villeH = new Ville("H",8,4);
    static Ville villeI = new Ville("I",10,1);
    static Ville villeJ = new Ville("J",11,5);
    static Ville villeK = new Ville("K",1,14);
    static Ville villeL = new Ville("L",2,8);
    static Ville villeM = new Ville("M",5,1);
    static Ville villeN = new Ville("N",6,0);
    static Ville villeO = new Ville("O",6,6);
    static Ville villeP = new Ville("P",7,12);
    static Ville villeQ = new Ville("Q",8,14);
    static Ville villeR = new Ville("R",9,1);
    static Ville villeS = new Ville("S",9,4);
    static Ville villeT = new Ville("T",9,14);
    static Ville villeU = new Ville("U",10,5);
    static Ville villeV = new Ville("V",11,1);
    static Ville villeW = new Ville("W",11,12);
    static Ville villeX = new Ville("X",13,12);
    static Ville villeY = new Ville("Y",14,5);
    static Ville villeZ = new Ville("Z",16,3);
    static Ville ville1 = new Ville("1",21,12);
    static Ville ville2 = new Ville("2",28,13);
    static Ville ville3 = new Ville("3",30,1);
    static Ville ville4 = new Ville("4",30,17);



    public static void main(String[] args) {
        System.out.println("Programme lancé");
        System.out.println("---------------------Test 6 Villes-----------------------------");

        ArrayList<Ville> villeArrayList = createListSixVilles();

        System.out.println("Enumération :");
        long startTimeEnumeration = System.currentTimeMillis();
        Enumeration enumeration = new Enumeration(villeArrayList);
        long endTimeEnumeration = System.currentTimeMillis();
        System.out.println("Possibilités trouvées : "+enumeration.compteur());
        System.out.println("temps écoulé : "+(endTimeEnumeration - startTimeEnumeration)+" ms");

        System.out.println("Glouton :");
        long startTimeGlouton = System.nanoTime();
        Glouton glouton = new Glouton(villeArrayList);
        glouton.run();
        System.out.println(glouton.listeToString(glouton.getVisitees()));
        System.out.println("Distance glouton "+glouton.getDistanceGlouton());
        long endTimeGlouton = System.nanoTime();
        System.out.println("temps écoulé : "+(endTimeGlouton - startTimeGlouton)+" ns");


        Individu bestIndividu=null;
        for (int i = 0; i < 100; i++) {
            ArrayList<Ville> villeArrayList2 = createListSixVilles();
            long startTimeGenetique = System.currentTimeMillis();
            Genetique g2 = new Genetique(100,villeArrayList2);
            Individu temp = g2.run(100);
            long endTimeGenetique = System.currentTimeMillis();
            if(bestIndividu!=null && temp.getDistance()<bestIndividu.getDistance()){
                bestIndividu = temp ;
            }else if(bestIndividu==null){
                bestIndividu=temp;
            }
            System.out.println("temps écoulé : "+(endTimeGenetique - startTimeGenetique)+" ms");
        }
        System.out.println("best of the best = "+bestIndividu);
        bestIndividu.print();

        villeArrayList.clear();
//----------------- 10 Villes -----------------------------------------//
        System.out.println("---------------------Test 10 Villes-----------------------------");
        villeArrayList = createListDixVilles();

        System.out.println("Enumération :");
        startTimeEnumeration = System.currentTimeMillis();
        Enumeration enumeration10 = new Enumeration(villeArrayList);
        endTimeEnumeration = System.currentTimeMillis();
        System.out.println("Possibilités trouvées : "+enumeration10.compteur());
        System.out.println("temps écoulé : "+(endTimeEnumeration - startTimeEnumeration)+" ms");


        startTimeGlouton = System.nanoTime();
        Glouton glouton10 = new Glouton(villeArrayList);
        glouton10.run();
        System.out.println(glouton10.listeToString(glouton10.getVisitees()));
        System.out.println("Distance glouton "+glouton10.getDistanceGlouton());
        endTimeGlouton = System.nanoTime();
        System.out.println("temps écoulé : "+(endTimeGlouton - startTimeGlouton)+" ns soit "+(endTimeGlouton - startTimeGlouton)/1000000+" ms");


        bestIndividu=null;
        for (int i = 0; i < 100; i++) {
            ArrayList<Ville> villeArrayList2 = createListDixVilles();
            long start2 = System.currentTimeMillis();
            Genetique g2 = new Genetique(100,villeArrayList2);
            Individu temp = g2.run(100);
            long end2 = System.currentTimeMillis();
            if(bestIndividu!=null && temp.getDistance()<bestIndividu.getDistance()){
                bestIndividu = temp ;
            }else if(bestIndividu==null){
                bestIndividu=temp;
            }
            System.out.println("temps écoulé : "+(end2 - start2)+" ms");
        }
        System.out.println("best of the best = "+bestIndividu);
        bestIndividu.print();

        villeArrayList.clear();
//----------------- 15 Villes -----------------------------------------//
        System.out.println("---------------------Test 15 Villes-----------------------------");

        villeArrayList = createListQuinzeVilles();

        System.out.println("Enumération = Out of bound exception");

        startTimeGlouton = System.nanoTime();
        Glouton glouton15 = new Glouton(villeArrayList);
        glouton15.run();
        System.out.println(glouton15.listeToString(glouton15.getVisitees()));
        System.out.println("Distance glouton "+glouton15.getDistanceGlouton());
        endTimeGlouton = System.nanoTime();
        System.out.println("temps écoulé : "+(endTimeGlouton - startTimeGlouton)+" ns soit "+(endTimeGlouton - startTimeGlouton)/1000000+" ms");


        bestIndividu=null;
        for (int i = 0; i < 100; i++) {
            ArrayList<Ville> villeArrayList2 = createListQuinzeVilles();
            long start2 = System.currentTimeMillis();
            Genetique g2 = new Genetique(100,villeArrayList2);
            Individu temp = g2.run(100);
            long end2 = System.currentTimeMillis();
            if(bestIndividu!=null && temp.getDistance()<bestIndividu.getDistance()){
                bestIndividu = temp ;
            }else if(bestIndividu==null){
                bestIndividu=temp;
            }
            System.out.println("temps écoulé : "+(end2 - start2)+" ms");
        }
        System.out.println("best of the best = "+bestIndividu);
        bestIndividu.print();

        villeArrayList.clear();

//----------------- 30 Villes -----------------------------------------//
        villeArrayList = createListTrenteVilles();

        System.out.println("---------------------Test 30 Villes-----------------------------");

        startTimeGlouton = System.nanoTime();
        Glouton glouton30 = new Glouton(villeArrayList);
        glouton30.run();
        System.out.println(glouton30.listeToString(glouton30.getVisitees()));
        System.out.println("Distance glouton "+glouton30.getDistanceGlouton());
        endTimeGlouton = System.nanoTime();
        System.out.println("temps écoulé : "+(endTimeGlouton - startTimeGlouton)+" ns soit "+(endTimeGlouton - startTimeGlouton)/1000000+" ms");


        bestIndividu=null;
        for (int i = 0; i < 100; i++) {
            ArrayList<Ville> villeArrayList2 = createListQuinzeVilles();
            long start2 = System.currentTimeMillis();
            Genetique g2 = new Genetique(100,villeArrayList2);
            Individu temp = g2.run(100);
            long end2 = System.currentTimeMillis();
            if(bestIndividu!=null && temp.getDistance()<bestIndividu.getDistance()){
                bestIndividu = temp ;
            }else if(bestIndividu==null){
                bestIndividu=temp;
            }
            System.out.println("temps écoulé : "+(end2 - start2)+" ms");
        }
        System.out.println("best of the best = "+bestIndividu);
        bestIndividu.print();

        villeArrayList.clear();
    }



    private static ArrayList<Ville> createListSixVilles() {

        ArrayList<Ville> villeList = new ArrayList<>();
        villeList.add(villeA);
        villeList.add(villeB);
        villeList.add(villeC);
        villeList.add(villeD);
        villeList.add(villeE);
        villeList.add(villeF);
        return villeList;
    }
    private static ArrayList<Ville> createListDixVilles() {
        ArrayList<Ville> villeList;
        villeList = createListSixVilles();
        villeList.add(villeG);
        villeList.add(villeH);
        villeList.add(villeI);
        villeList.add(villeJ);
        return villeList;
    }
    private static ArrayList<Ville> createListQuinzeVilles() {
        ArrayList<Ville> villeList;
        villeList = createListDixVilles();
        villeList.add(villeK);
        villeList.add(villeL);
        villeList.add(villeM);
        villeList.add(villeN);
        villeList.add(villeO);
        return villeList;
    }
    private static ArrayList<Ville> createListTrenteVilles() {
        ArrayList<Ville> villeList;
        villeList = createListQuinzeVilles();
        villeList.add(villeP);
        villeList.add(villeQ);
        villeList.add(villeR);
        villeList.add(villeS);
        villeList.add(villeT);
        villeList.add(villeU);
        villeList.add(villeV);
        villeList.add(villeW);
        villeList.add(villeX);
        villeList.add(villeY);
        villeList.add(villeZ);
        villeList.add(ville1);
        villeList.add(ville2);
        villeList.add(ville3);
        villeList.add(ville4);

        return villeList;
    }

}
