class Solution {
    int mod = 1000000000 + 7;

    public int countGoodNumbers(long n) {
        return (int)((findPow(5,(n+1)/2) * findPow(4,n/2)) % mod);
    }

    public long findPow(long a, long b){
        if(b==0){
            return 1;
        }
        long half = findPow(a, b/2);
        long res = (half * half) % mod;
        if(b%2==1) res = (res * a) % mod;
        return res;
    }

}