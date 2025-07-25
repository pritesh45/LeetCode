class RandomizedSet {

public HashSet<Integer> hs;
public Random random;
    public RandomizedSet() {
        hs=new HashSet<>();
        random=new Random();
        
    }
    
    public boolean insert(int val) {
        if(hs.contains(val)){
            return false;
        }
        hs.add(val);
        return true;
        
    }
    
    public boolean remove(int val) {
        if(!hs.contains(val)){
            return false;
        }
        hs.remove(val);
        return true;
        
    }
    
    public int getRandom() {
        Integer[] arrayNum=hs.toArray(new Integer[hs.size()]);
        return arrayNum[random.nextInt(hs.size())];
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */