class Pair
{
    int node;
    int distance;
 
    public Pair(int n , int d)
    {
        node = n;
        distance = d;
    }
}
class Solution {
 
    public void dijkstraUsingTreeSet(int [] distance , boolean[] visited , int src , Map<Integer , List<Pair>> adj)
    {
        TreeSet<Integer> set = new TreeSet<>((p1 , p2) -> {
            int diff = distance[p1] - distance[p2];
            if(diff == 0)
                return p1 - p2;
            return diff;
            });
        int n = visited.length;
        Arrays.fill(distance , Integer.MAX_VALUE);
        distance[src] = 0;
        set.add(src);
 
        while(!set.isEmpty())
        {
            int node = set.pollFirst();
 
            for(Pair nextNodePair : adj.computeIfAbsent(node , f -> new ArrayList<>()))
            { 
                if(distance[node] + nextNodePair.distance < distance[nextNodePair.node])
                {
                    set.remove(nextNodePair.node);
                    distance[nextNodePair.node] = distance[node] + nextNodePair.distance;
                    set.add(nextNodePair.node);
                }
            }
        }
    }
 
    public void dijkstra(int [] distance , boolean[] visited , int src , Map<Integer , List<Pair>> adj)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1 , p2) -> p1.distance - p2.distance);
        int n = visited.length;
        Arrays.fill(distance , Integer.MAX_VALUE);
        distance[src] = 0;
        pq.add(new Pair(src , 0));
 
        int visitedNodes = 0;
        while(!pq.isEmpty() && visitedNodes < (n - 1))
        {
            Pair pair = pq.poll();
            if(visited[pair.node]) continue;
            visited[pair.node] = true;
            visitedNodes ++;
 
            for(Pair nextNodePair : adj.computeIfAbsent(pair.node , f -> new ArrayList<>()))
            {
                if(pair.distance + nextNodePair.distance < distance[nextNodePair.node])
                {
                    distance[nextNodePair.node] = pair.distance + nextNodePair.distance;
                    pq.add(new Pair(nextNodePair.node , distance[nextNodePair.node]));
                }
            }
        }
    }
 
    public int networkDelayTime(int[][] times, int n, int src) {
        int distance[] = new int[n + 1];
        boolean visited[] = new boolean[n + 1];
 
        Map<Integer , List<Pair>> adj = new HashMap<>();
        for(int edge[] : times)
            adj.computeIfAbsent(edge[0] , f -> new ArrayList<>()).add(new Pair(edge[1] , edge[2]));
 
        dijkstraUsingTreeSet(distance , visited , src , adj);
 
        int maxTime = 0;
        for(int i = 1 ; i <= n ; i ++)
            if(distance[i] == Integer.MAX_VALUE)
                return -1;
            else
                maxTime = Math.max(distance[i] , maxTime);
 
        return maxTime;
 
    }
}