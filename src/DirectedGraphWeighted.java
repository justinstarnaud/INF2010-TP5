import java.util.ArrayList;
import java.util.HashSet;

public class DirectedGraphWeighted {
    public HashSet<Vertex>[] neighbours;
    public int vertexCapacity;
    public int edgeQuantity;

    /* Initialize de DirectedGraph */
    public void initialize(int numNodes) {
        this.neighbours = new HashSet[numNodes];
        for(int i=0; i<numNodes; i++) neighbours[i] = new HashSet<Vertex>();
        this.edgeQuantity = 0;
        this.vertexCapacity = numNodes;
    }

    /*Create an edge between the vertices - Veuillez vous referez aux notes de cours */
    public void connect(int v1, Vertex vertex){
        if(v1>=0 && v1 <= vertexCapacity && !neighbours[v1].contains(vertex)){
            neighbours[v1].add(vertex);
        }
    }

    /* Print all the edges connecting vertices*/
    public String toString(){
        StringBuilder o = new StringBuilder();
        String ln = System.getProperty("line.separator");
        o.append(vertexCapacity).append(ln).append(edgeQuantity).append(ln);
        for (HashSet<Vertex> hashSet : neighbours) {
            for (Vertex vertex : hashSet) {
                o.append(vertex.cost);
            }
            o.append(ln);
        }
        return o.toString();
    }

    /* Return a HashMap of adjacent edges / vertices */
    public HashSet<Vertex> adj(int v) {
        return new HashSet<>(this.neighbours[v]);
    }

    public DirectedGraphWeighted(int numNodes){
        initialize(numNodes);
    }

    public int findLowestCost() {
        /* NE PAS MODIFIER CE CODE */
        int totalCost = 0;

        Heap vertices = new Heap(vertexCapacity + 1);
        /* NE PAS MODIFIER CE CODE */

        /* Add all of the vertices to the Heap start at Index 1. The default cost should be the largest possible value for an integer */
        boolean adding = true;
        for(HashSet<Vertex> v : neighbours){
            for(Vertex areteVoisine : v){
                for (Vertex elem: vertices.Heap){
                    if(elem != null && elem.index == areteVoisine.index){
                        adding = false;
                        break;
                    }


                }

                if(adding)
                    vertices.add(new Vertex(Integer.MAX_VALUE, areteVoisine.index));

                adding = true;
            }
        }
        while(true){
            Vertex v = vertices.findSmallestUnknown();
            if(v == null) break;
            v.known = true;
            for(Vertex w: adj(v.index)){
                /* Decrease the cost of the vertex in the Heap using decreaseKey if conditions are met */
                //int pathCost = v.path != null ? v.path.cost : 0;
                vertices.decreaseKey(w, w.cost + v.cost );
                // Nb d'iteration
                // modification plus couteuse
            }
        }

        /*Add up the total cost of the elements in the Heap */
        // nb d'iteration
        while(!vertices.isEmpty){
            totalCost += vertices.poll().cost;
            System.out.println(totalCost);
        }
        return totalCost;
    }
}
