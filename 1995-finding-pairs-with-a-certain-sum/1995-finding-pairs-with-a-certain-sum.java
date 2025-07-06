class FindSumPairs {
    int[] n,m;
    Map<Integer,Integer> mp=new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        n=nums1;
        m=nums2;
        for(int x:m)
        mp.put(x,mp.getOrDefault(x,0)+1);
    }
    
    public void add(int index, int val) {
        mp.put(m[index],mp.get(m[index])-1);
        m[index]+=val;
        mp.put(m[index],mp.getOrDefault(m[index],0)+1);
        
    }
    
    public int count(int tot) {
        int c=0;
        for(int x:n)c+=mp.getOrDefault(tot-x,0);
        return c;
        
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */