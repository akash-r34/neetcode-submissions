class Solution {

    public boolean isNumsValid(char[] nums){
        Set<Character> numSet = new HashSet<>(List.of('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        for(int i=0; i<nums.length; i++){
            if(numSet.contains(nums[i]) || nums[i]=='.'){
                if(nums[i]!='.')
                    numSet.remove(nums[i]);
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public boolean isRowValid(int row, char[][] board){
        char[] nums = new char[board[row].length];
        for(int j=0; j<board[row].length; j++){
            nums[j] = board[row][j];
        }
        return isNumsValid(nums);
    }
    public boolean isColumnValid(int col, char[][] board){
        char[] nums = new char[board.length];
        for(int i=0; i<board.length; i++){
            nums[i] = board[i][col];
        }
        return isNumsValid(nums);
    }
    public boolean isSubBoxValid(char[][] board, int toplefti, int topleftj, int subboxdim){
        char[] nums = new char[subboxdim*subboxdim];
        int k=0;
        for(int i=toplefti; i<toplefti+subboxdim; i++){
            for(int j=topleftj; j<topleftj+subboxdim; j++){
                nums[k++] = board[i][j];
            }
        }
        return isNumsValid(nums);
    }
    public boolean isValidSudoku(char[][] board) {
        int subboxdim=3;
        for(int i=0; i<board.length; i++){
            if(!isRowValid(i, board))
                return false;
        }
        for(int j=0; j<board[0].length; j++){
            if(!isColumnValid(j, board))
                return false;
        }
        for(int i=0; i<board.length; i=i+subboxdim){
            for(int j=0; j<board[0].length; j=j+subboxdim){
                if(!isSubBoxValid(board, i, j, subboxdim))
                    return false;
            }
        }
        return true;
    }
}
