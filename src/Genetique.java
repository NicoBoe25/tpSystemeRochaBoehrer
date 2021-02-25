import java.util.ArrayList;

public class Genetique {



    private Population pop;
    private Individu bestIndividu;

    public Genetique(int size, ArrayList<Ville> list){
        Population p = new Population(size,list);
        this.pop = p;
        bestIndividu = p.findBestIndividu();
    }

    public Individu run(int size){
        for (int i = 0; i < size; i++) {
            Population temp = pop.nextGen();
            if(temp.findBestIndividu().getDistance()<bestIndividu.getDistance()){
                bestIndividu=temp.findBestIndividu();
                pop=temp;
            }
        }
        System.out.println("choix:"+bestIndividu.getDistance());
        return bestIndividu;
    }


    public Population getPop() {
        return pop;
    }

    public void setPop(Population pop) {
        this.pop = pop;
    }

}
