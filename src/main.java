public class main {

    public static void main(String[] args) {
        System.out.println("Programme lancé");
        Ville villeA = new Ville("A",1,1);
        Ville villeB = new Ville("B",2,2);
        Ville villeC = new Ville("C",1,3);
        Ville villeD = new Ville("D",3,2);
        Ville villeE = new Ville("E",3,5);
        Ville villeF = new Ville("F",7,2);
        Ville p0 = new Ville("P0",0,0);
        Ville p7 = new Ville("P7",0,0);

        System.out.println(villeA.calculDistance(villeB));
    }
}
