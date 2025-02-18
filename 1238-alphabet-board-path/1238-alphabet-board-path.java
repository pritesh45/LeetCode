class Solution {
    public String alphabetBoardPath(String target) {
        //StringBuilder to store the answer of the path
        StringBuilder sb=new StringBuilder();
        int currentx=0; 
        int currenty=0;
        //Iterate over each character in the target string
        for(char ch:target.toCharArray()){
            int targetx=(ch-'a')/5;  //Row
            int targety=(ch-'a')%5;  //Col


            if(ch== 'z'){
                while(currenty > targety){
                    sb.append("L");
                    currenty--;
                }
                while(currentx < targetx){
                    sb.append("D");
                    currentx++;
                }
            }
            else{
                while(currentx > targetx){
                    sb.append("U");
                    currentx--;
                }
                while(currentx<targetx){
                    sb.append("D");
                    currentx++;
                }
                while(currenty>targety){
                    sb.append("L");
                    currenty--;
                }
                while(currenty < targety){
                    sb.append("R");
                    currenty++;
                }

            }
            sb.append("!");
        }
        return sb.toString();

    }
}