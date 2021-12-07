import java.util.*;

public class Interview {
    private static final int[][] DIRECTIONS = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int minCost(Cell[][] grid) {
        /* Ne pas modifier ce code */
        int m = grid.length, n = grid[0].length;

        Cell[][] costs = new Cell[m][n];
        for (Cell[] c : costs){
            for(int i = 0; i < c.length; i++){
                c[i] = new Cell(0,0,Integer.MAX_VALUE);
            }
        }
        costs[0][0].cost = 0;

        PriorityQueue<Cell> heap = new PriorityQueue<>();
        heap.offer(new Cell(0,0,0));
        /* Ne pas modifier ce code */

        while (!heap.isEmpty()) {
            Cell curr = heap.poll();
            int x = curr.xPos, y = curr.yPos, cost = curr.cost;

            if (x==m-1 && y ==n-1)
                return cost;


            for (int i = 0; i < 4; i++) {
                int[] dir = DIRECTIONS[i];
                int newX = x + dir[1], newY = y + dir[0];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                int direction = grid[x][y].cost;
                int newCost = cost + (i + 1 == direction ? 0:1);
                if (costs[newY][newX].cost > newCost) {
                    costs[newY][newX].cost = newCost;
                    heap.offer(new Cell(newX,newY,newCost));
                }
            }
        }

        return -1;
    }
}
