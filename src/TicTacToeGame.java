import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import Model.Board;
import Model.PieceType;
import Model.Player;
import Model.PlayingPiece;
import Model.PlayingPieceO;
import Model.PlayingPieceX;

public class TicTacToeGame {

	public Board gameBoard;
	public Deque<Player> players;

	TicTacToeGame() {
		initializeGame();
	}

	public void initializeGame() {
		players = new LinkedList<>();
		gameBoard = new Board(3);
		PlayingPiece pieceX = new PlayingPieceX();
		Player player1 = new Player("Rohith", pieceX);
		PlayingPiece pieceO = new PlayingPieceO();
		Player player2 = new Player("Raghu", pieceO);
		players.add(player1);
		players.add(player2);
	}

	@SuppressWarnings("resource")
	public String startGame() {
		while (true) {
			gameBoard.prinBoard();
			if (!gameBoard.hasSpace()) {
				return "tie";
			}
			Player playerTurn = players.removeFirst();
			Scanner s = new Scanner(System.in);
			System.out.print(playerTurn.name + " : Enter row and column numbers - ");
			String[] input = s.nextLine().split(",");
			int i = Integer.parseInt(input[0]);
			int j = Integer.parseInt(input[1]);
			if (!gameBoard.addStep(i, j, playerTurn.type)) {
				System.out.println("Incorrect row or column,Please enter valid numbers..");
				players.addFirst(playerTurn);
				continue;
			}
			if (checkWinner(i, j, playerTurn.type.type, this.gameBoard.size)) {
				return playerTurn.name;
			}
			players.addLast(playerTurn);
		}
	}

	private boolean checkWinner(int row, int col, PieceType type, int size) {
		for (int j = 0; j < size; j++) {
			if (this.gameBoard.board[row][j] == null || this.gameBoard.board[row][j].type != type) {
				break;
			}
			if (j == size - 1) {
				return true;
			}
		}
		for (int i = 0; i < size; i++) {
			if (this.gameBoard.board[i][col] == null || this.gameBoard.board[i][col].type != type) {
				break;
			}
			if (i == size - 1) {
				return true;
			}
		}
		for (int i = 0; i < size; i++) {
			if (this.gameBoard.board[i][i] == null || this.gameBoard.board[i][i].type != type) {
				break;
			}
			if (i == size - 1) {
				return true;
			}
		}
		for (int i = 0; i < size; i++) {
			if (this.gameBoard.board[size - 1 - i][i] == null || this.gameBoard.board[size - 1 - i][i].type != type) {
				break;
			}
			if (i == size - 1) {
				return true;
			}
		}
		return false;
	}

}