import java.util.*;
public class Heap {
    public final Vertex[] Heap;
    private int size;
    private final int maxsize;

    private static final int FRONT = 1;

    public boolean isEmpty = false;

    public Heap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 1;

        Heap = new Vertex[maxsize];
        Heap[0] = null;
        Heap[1] = new Vertex(0,0);
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
       return (2 * pos) + 1;
    }


    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    private void swap(int fpos, int spos) {
        Vertex tmp;
        tmp = Heap[fpos];

        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos].cost > Heap[leftChild(pos)].cost
                    || Heap[pos].cost > Heap[rightChild(pos)].cost) {
                if (Heap[leftChild(pos)].cost
                        < Heap[rightChild(pos)].cost) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void add(Vertex element) {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;

        while (size > 1 && Heap[current].cost < Heap[parent(current)].cost) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    /*TODO Find the vertex in the heap using the Vertex's index and decrease the key and heapify the elements. */
    public void decreaseKey(Vertex v, int newCost){

    }

    /*TODO Find the smallest cost unknown Vertex in the Heap. */
    public Vertex findSmallestUnknown(){

        return null;
    }

    public Vertex poll() {
        Vertex popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        if(size > 1)
            minHeapify(FRONT);

        if(size < 1){
            isEmpty = true;
        }

        return popped;
    }
}

