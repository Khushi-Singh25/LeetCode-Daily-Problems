class Solution {
    public boolean checkPowersOfThree(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n > 0){
            int c = 0;
            while(n >= (int)Math.pow(3,c)){
                c++;
            }
            if(set.contains(c-1)){
                return false;
            }
            set.add(c-1);
            n = n - (int)Math.pow(3,c-1);
        }
        if(n==0) return true;
        return false;
    }
}