package TicTacToe;

public class TicTacToeViewModel {
    private TicTacToe ticTacToe;

    public TicTacToeViewModel(TicTacToe ticTacToe) {
        this.ticTacToe=ticTacToe;
    }

    public char[][] generateBoard() {
        char[][] board=new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]='_';
            }
        }

        return board;
    }

    public void playerMove(char[][] board, int rowX, int colX, char symbol) {
        board[rowX][colX]=symbol;
    }

    public boolean isPlayerWon(char[][] board, char symbol) {
        //check row wise
        boolean isRowFilled=true;
        for(int i=0;i<3;i++){
            isRowFilled=true;
            for(int j=0;j<3;j++){
                if(board[i][j]!=symbol){
                    isRowFilled=false;
                    break;
                }
            }

            if(isRowFilled){
                return true;
            }
        }

        //check column wise
        boolean isColFilled=true;
        for(int i=0;i<3;i++){
            isColFilled=true;
            for(int j=0;j<3;j++){
                if(board[j][i]!=symbol){
                    isColFilled=false;
                    break;
                }
            }

            if(isColFilled){
                return true;
            }

        }

        //check diagonal wise
        //top left to bottom right diagonal
        boolean isDiagonalFilled=true;
        int i=0,j=0;
        while(i<3 && j<3){
            if(board[i][j]!=symbol){
                isDiagonalFilled=false;
                break;
            }
            i++;
            j++;
        }
        if(isDiagonalFilled){
            return true;
        }

        //top right to bottom left diagonal
        isDiagonalFilled=true;
        i=0;
        j=2;
        while(i<3 && j>=0){
            if(board[i][j]!=symbol){
                isDiagonalFilled=false;
                break;
            }
            i++;
            j--;
        }
        if(isDiagonalFilled){
            return true;
        }

        return false;
    }

    public boolean isValidMove(char[][] board, int row, int col, char symbol) {
        if(row<0 || row>3 || col<0 || col>3){
            ticTacToe.printOutOfBoundMove();
            return false;
        }

        if(board[row][col]!='_'){
            ticTacToe.printAlreadyThereIsASymbol();
            return false;
        }

        return true;
    }

    public boolean isBoardFull(char[][] board) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='_'){
                    return false;
                }
            }
        }
        return true;
    }
}
