class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(supplies));
        HashMap<String,List<Integer>> adj = new HashMap<>();
        
        int inDeg[] = new int[n];
        for(int i=0; i<n; i++){
            for(String ing : ingredients.get(i)){
                if(!set.contains(ing)){
                    adj.putIfAbsent(ing, new ArrayList<>());
                    adj.get(ing).add(i);
                    inDeg[i]++;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int i = q.remove();
            String rec = recipes[i];
            ans.add(rec);
            set.add(rec);
            if(!adj.containsKey(rec)){
                continue;
            }
            for(int nb : adj.get(rec)){
                inDeg[nb]--;
                if(inDeg[nb]==0){
                    q.add(nb);
                }
            }
        }
        return ans;
    }
}