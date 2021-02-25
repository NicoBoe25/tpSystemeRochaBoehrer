import java.util.ArrayList;
import java.util.Date;

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


        ArrayList<Ville> villeArrayList = createListSixVilles();
        long start = System.currentTimeMillis();
        Genetique g = new Genetique(50,villeArrayList);
        g.run(500);
        long end = System.currentTimeMillis();
        System.out.println("temps écoulé : "+(end - start)+" ms");


        Individu bestIndividu=null;
        for (int i = 0; i < 100; i++) {
        ArrayList<Ville> villeArrayList2 = createListTrenteVilles();
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

/*
        Individu individu = new Individu(92929,villeArrayList,true);
        individu.print();
        System.out.println(individu.getDistance());

        Population p = new Population(6,villeArrayList);

        for (Individu ind : p.getListeIndividu()) {
            System.out.println(ind.getNote());
        }

        Individu res = p.getListeIndividu().get(0).croise(p.getListeIndividu().get(1));
        res.print();
        Population p2 = p.nextGen();
        System.out.println("________ POPULATION ________");
        System.out.println(p.findBestIndividu().getDistance());
        System.out.println(p2.findBestIndividu().getDistance());
        */










/*
        long startTime = System.currentTimeMillis();
        Enumeration enumeration = new Enumeration(villeArrayList);
        System.out.println("Possibilités trouvées : "+enumeration.compteur());
        System.out.println("Timer task finished at:"+new Date());
        long endTime = System.currentTimeMillis();
        System.out.println("temps écoulé : "+(endTime - startTime)+" ms");
*/
/*
        long startTime2 = System.nanoTime();
        Glouton glouton = new Glouton(villeArrayList);
        glouton.run();
        System.out.println(glouton.listeToString(glouton.getVisitees()));
        System.out.println("Distance glouton "+glouton.getDistanceGlouton());
        long endTime2 = System.nanoTime();
        System.out.println("temps écoulé : "+(endTime2 - startTime2)+" ns");
*/
        /*
        long startTime3 = System.nanoTime();
        GloutonDeuxVilles gloutonDeuxVilles = new GloutonDeuxVilles(villeArrayList);
        gloutonDeuxVilles.run();
        System.out.println(gloutonDeuxVilles.listeToString(gloutonDeuxVilles.getVisitees()));
        System.out.println("Distance glouton2 "+gloutonDeuxVilles.getDistanceGlouton());
        long endTime3 = System.nanoTime();
        System.out.println("temps écoulé : "+(endTime3 - startTime3)+" ns");
        */


//----------------- 10 Villes -----------------------------------------//
/*
        villeArrayList.clear();
        villeArrayList = createListDixVilles();

        long startTime20 = System.nanoTime();
        Glouton glouton10 = new Glouton(villeArrayList);
        glouton10.run();
        System.out.println(glouton10.listeToString(glouton10.getVisitees()));
        System.out.println("Distance glouton "+glouton10.getDistanceGlouton());
        long endTime20 = System.nanoTime();
        System.out.println("temps écoulé : "+(endTime20 - startTime20)+" ns soit "+(endTime20 - startTime20)/1000000+" ms");
        //refaire avec 10 villes
*/
//----------------- 15 Villes -----------------------------------------//
        /*
        villeArrayList.clear();
        villeArrayList = createListQuinzeVilles();

        System.out.println("TEST GLOUTON 15");
        long startTime5 = System.nanoTime();
        Glouton glouton2 = new Glouton(villeArrayList);
        glouton2.run();
        System.out.println(glouton2.listeToString(glouton2.getVisitees()));
        System.out.println("Distance glouton "+glouton2.getDistanceGlouton());
        long endTime5 = System.nanoTime();
        System.out.println("temps écoulé : "+(endTime5 - startTime5)+" ns soit "+(endTime5 - startTime5)/1000000+" ms");
/*

//----------------- 30 Villes -----------------------------------------//
        villeArrayList.clear();
        villeArrayList = createListTrenteVilles();

        System.out.println("TEST GLOUTON 30");
        long startTime50 = System.nanoTime();
        Glouton glouton30 = new Glouton(villeArrayList);
        glouton30.run();
        System.out.println(glouton30.listeToString(glouton30.getVisitees()));
        System.out.println("Distance glouton "+glouton30.getDistanceGlouton());
        long endTime50 = System.nanoTime();
        System.out.println("temps écoulé : "+(endTime50 - startTime50)+" ns soit "+(endTime50 - startTime50)/1000000+" ms");
  */

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
