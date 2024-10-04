package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    private TicTacToeViewModel ticTacToeViewModel;

    public TicTacToe(){
        ticTacToeViewModel=new TicTacToeViewModel(this);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe Game");

        TicTacToe ticTacToe=new TicTacToe();

        char[][] board=ticTacToe.ticTacToeViewModel.generateBoard();

        ticTacToe.displayBoard(board);

        Scanner scanner=new Scanner(System.in);

        while(true){
            int rowX=-1,colX=-1;
            do{
                System.out.println("Player 1(X),enter your move(row and column)");
                rowX = scanner.nextInt();
                colX = scanner.nextInt();
            }while(!ticTacToe.ticTacToeViewModel.isValidMove(board,rowX,colX,'X'));

            ticTacToe.ticTacToeViewModel.playerMove(board,rowX,colX,'X');

            ticTacToe.displayBoard(board);

            if(ticTacToe.ticTacToeViewModel.isPlayerWon(board,'X')){
                System.out.println("Congratulations, Player 1 (X) wins!");
                break;
            }

            if(ticTacToe.ticTacToeViewModel.isBoardFull(board)){
                System.out.println("No More Moves!It's a Draw");
                break;
            }

            int rowO=-1,colO=-1;
            do{
                System.out.println("Player 2(O),enter your move(row and column)");
                rowO=scanner.nextInt();
                colO=scanner.nextInt();
            }while(!ticTacToe.ticTacToeViewModel.isValidMove(board,rowO,colO,'O'));


            ticTacToe.ticTacToeViewModel.playerMove(board,rowO,colO,'O');

            ticTacToe.displayBoard(board);

            if(ticTacToe.ticTacToeViewModel.isPlayerWon(board,'O')){
                System.out.println("Congratulations, Player 2 (O) wins!");
                break;
            }

            if(ticTacToe.ticTacToeViewModel.isBoardFull(board)){
                System.out.println("No More Moves!It's a Draw");
                break;
            }

        }
    }

    private void displayBoard(char[][] board) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void printOutOfBoundMove() {
        System.out.println("ERROR:Your Move is Out Of the Grid,Please enter a valid move!");
    }

    public void printAlreadyThereIsASymbol() {
        System.out.println("ERROR:There is Already a symbol at that point,Please enter a valid move!");
    }
}
