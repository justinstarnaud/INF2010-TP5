public class Vertex implements Comparable<Vertex> {
    int cost;
    int index;
    Vertex path;
    boolean known;

    public Vertex(int cost, int index){
        this.cost = cost;
        this.index = index;
        known = false;
    }

    @Override
    public int compareTo(Vertex o) {
        /* Implement comparison between the cost of two edges */
        return -1;
    }
}
