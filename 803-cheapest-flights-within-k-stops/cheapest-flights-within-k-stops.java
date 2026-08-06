import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});

        int stops = 0;

        while (!queue.isEmpty() && stops <= k) {
            int size = queue.size();

            while (size-- > 0) {
                int[] curr = queue.poll();
                int u = curr[0];
                int currentCost = curr[1];

                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int price = neighbor[1];

                    if (currentCost + price < minCost[v]) {
                        minCost[v] = currentCost + price;
                        queue.add(new int[]{v, minCost[v]});
                    }
                }
            }
            stops++;
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}