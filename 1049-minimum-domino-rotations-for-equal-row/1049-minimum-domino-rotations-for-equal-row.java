class Solution {
        public int minDominoRotations(int[] tops, int[] bottoms) {
                int n = tops.length;
                        HashMap<Integer, Integer> map = new HashMap<>();
                                int max = 0;

                                        for(int i = 0; i < n; i++){
                                                    int w = map.getOrDefault(tops[i], 0);
                                                                int x = map.getOrDefault(bottoms[i], 0);

                                                                            if(tops[i] == bottoms[i]){
                                                                                            map.put(tops[i], w + 1);
                                                                                                        } else {
                                                                                                                        map.put(tops[i], w + 1);
                                                                                                                                        map.put(bottoms[i], x + 1);
                                                                                                                                                    }
                                                                                                                                                            }

                                                                                                                                                                    for(int key : map.keySet()){
                                                                                                                                                                                if(map.get(key) >= n){
                                                                                                                                                                                                max = key;
                                                                                                                                                                                                                break;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                            if(max == 0) return -1;

                                                                                                                                                                                                                                                    int rotateTop = 0;
                                                                                                                                                                                                                                                            int rotateBottom = 0;

                                                                                                                                                                                                                                                                    for(int i = 0; i < n; i++){
                                                                                                                                                                                                                                                                                if(tops[i] != max && bottoms[i] != max) return -1;
                                                                                                                                                                                                                                                                                            if(tops[i] != max) rotateTop++;
                                                                                                                                                                                                                                                                                                        if(bottoms[i] != max) rotateBottom++;
                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                        return Math.min(rotateTop, rotateBottom);
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                            }
