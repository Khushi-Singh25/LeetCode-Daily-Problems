class Pair{
    int node, tm;
    Pair(int node, int tm){
        this.node = node;
        this.tm = tm;
    }
}
class Pair2{
    long tm; int node;
    Pair2(long tm, int node){
        this.tm = tm;
        this.node = node;
    }
}
class Solution {
    static int mod = 1000000000+7;
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int r[] : roads){
            adj.get(r[0]).add(new Pair(r[1], r[2]));
            adj.get(r[1]).add(new Pair(r[0], r[2]));
        }
        PriorityQueue<Pair2> pq = new PriorityQueue<>((a,b) -> Long.compare(a.tm,b.tm));
        pq.add(new Pair2(0,0));
        
        int ways[] = new int[n];
        ways[0] = 1;
        long time[] = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        time[0] = 0;

        while(!pq.isEmpty()){
            int nd = pq.peek().node;
            long ndTm = pq.poll().tm;
            for(Pair nbr : adj.get(nd)){
                int nb = nbr.node;
                int nbTm = nbr.tm;
                if(ndTm + nbTm < time[nb]){
                    time[nb] = ndTm + nbTm;
                    ways[nb] = ways[nd];
                    pq.add(new Pair2(ndTm+nbTm, nb));
                }
                else if(ndTm + nbTm == time[nb]){
                    ways[nb] = (ways[nb] + ways[nd]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}