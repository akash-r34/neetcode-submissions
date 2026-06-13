class Solution {
    // Compile the pattern ONCE and reuse it
    private static final Pattern INT_PATTERN = Pattern.compile("-?\\d+");

    public static boolean isInteger(String str) {
        if (str == null) return false;
        return INT_PATTERN.matcher(str).matches();
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String tok: tokens){
            if(isInteger(tok)){
                int num = Integer.parseInt(tok);
                stack.push(num);
            }
            else{
                int first = stack.pop();
                int second = stack.pop();
                if(tok.equals("+")){
                    int res = second + first;
                    stack.push(res);
                }
                else if(tok.equals("-")){
                    int res = second - first;
                    stack.push(res);
                }
                else if(tok.equals("*")){
                    int res = second * first;
                    stack.push(res);
                }
                else if(tok.equals("/")){
                    int res = second / first;
                    stack.push(res);
                }
            }
            System.out.println(stack);
        }
        return stack.pop();
    }
}
