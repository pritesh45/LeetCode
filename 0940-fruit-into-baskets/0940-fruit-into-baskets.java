class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> basket = new HashMap<>();
        int left=0;
        int maxFruits=0;
        for(int right=0;right<fruits.length;right++){
            int fruit=fruits[right];
            basket.put(fruit,basket.getOrDefault(fruit,0)+1);

            while(basket.size()>2){
                int leftfruit=fruits[left];
                basket.put(leftfruit,basket.get(leftfruit)-1);

                if(basket.get(leftfruit)==0){
                    basket.remove(leftfruit);
                }
                left++;
            }
            maxFruits=Math.max(maxFruits,right-left+1);
        }
        return maxFruits;
    }
}