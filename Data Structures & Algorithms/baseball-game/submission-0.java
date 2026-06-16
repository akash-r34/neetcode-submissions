class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> scores = new ArrayDeque<>();
        for(int i=0; i<operations.length; i++){
            if(operations[i].equals("+")){
                int a = scores.pop();
                int b = scores.peek();
                scores.push(a);
                scores.push(a+b);
            } else if(operations[i].equals("D")){
                scores.push(2*scores.peek());
            } else if(operations[i].equals("C")){
                scores.pop();
            } else{
                scores.push(Integer.parseInt(operations[i]));
            }
            System.out.println("Step "+i);
            System.out.println(scores);
        }
        int finalScore=0;
        while(!scores.isEmpty())
            finalScore+=scores.pop();
        return finalScore;
    }
}