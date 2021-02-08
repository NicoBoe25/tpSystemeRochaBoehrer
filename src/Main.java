import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Programme lancé");
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

        Enumeration enumeration = new Enumeration(villeArrayList);
        System.out.println(enumeration.compteur());

    }
}
