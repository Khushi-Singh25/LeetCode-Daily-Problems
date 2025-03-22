class DisjointSet {                        
    List<Integer> size = new ArrayList<>();
    List<Integer> par = new ArrayList<>();

    public DisjointSet(int n){     
        for(int i=0; i<n; i++){
            size.add(1);
            par.add(i);
        }
    }
    public int findUltPar(int node){
        if(node == par.get(node)){
            return node;
        }
        int ulp = findUltPar(par.get(node));
        par.set(node, ulp);
        return par.get(node);
    }
    public void unionBySize(int u, int v){
        int ulp_u = findUltPar(u);
        int ulp_v = findUltPar(v);
        if(ulp_u == ulp_v){
            return;
        }
        if(size.get(ulp_u) < size.get(ulp_v)){
            par.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }else{
            par.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        DisjointSet dsu = new DisjointSet(n);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] ed : edges){
            dsu.unionBySize(ed[0], ed[1]);
        }
        for(int[] ed : edges){
            int root = dsu.findUltPar(ed[0]);
            map.put(root, map.getOrDefault(root,0)+1);
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            if(dsu.findUltPar(i) == i){
                int v = dsu.size.get(i);
                int e = map.getOrDefault(i,0);
                if((v*(v-1)/2) == e){
                    ans++;
                }
            }
        }
        return ans;
    }
}