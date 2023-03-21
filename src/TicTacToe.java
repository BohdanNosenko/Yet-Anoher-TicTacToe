import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] board = new char[3][3];
        initializeBoard(board);
        char currentPlayer = 'X';
        boolean gameEnded = false;
        while (!gameEnded) {
            displayBoard(board);
            System.out.print("It's " + currentPlayer + "'s turn. Enter the row (0-2) and column (0-2) to place your mark: ");
            int row = input.nextInt();
            int col = input.nextInt();
            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                if (isWinningMove(board, row, col)) {
                    displayBoard(board);
                    System.out.println(currentPlayer + " wins!");
                    gameEnded = true;
                } else if (isBoardFull(board)) {
                    displayBoard(board);
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
                }
            } else {
                System.out.println("That spot is already taken.");
            }
        }
    }

    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void displayBoard(char[][] board) {
        System.out.println("  0 1 2");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static boolean isWinningMove(char[][] board, int row, int col) {
        char player = board[row][col];
        return (board[row][0] == player && board[row][1] == player && board[row][2] == player)
                || (board[0][col] == player && board[1][col] == player && board[2][col] == player)
                || (row == col && board[0][0] == player && board[1][1] == player && board[2][2] == player)
                || (row + col == 2 && board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
