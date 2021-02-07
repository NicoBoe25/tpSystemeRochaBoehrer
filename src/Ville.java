public class Ville {
    private String nom;
    private int x;
    private int y;

    public int getX() {return x; }

    public int getY() { return y;    }

    public Ville(String nom, int x, int y) {
        this.nom = nom;
        this.x = x;
        this.y = y;
    }

    public double calculDistance(Ville ville){
        return Math.sqrt(
                Math.pow(ville.getX()-this.getX(),2)+
                Math.pow(ville.getY()-this.getY(),2)
        );
    }

    @Override
    public String toString() {
        return nom;
    }

}
