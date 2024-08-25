package Model;

public class Board {
	public int size;
	public PlayingPiece board[][];

	public Board(int size) {
		super();
		this.size = size;
		this.board = new PlayingPiece[size][size];
	}

	public void prinBoard() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				var symbol = this.board[i][j] != null ? this.board[i][j].type : " ";
				System.out.print(" " + symbol  + " |");
			}
			System.out.println();
		}
	}

	public boolean addStep(int i, int j, PlayingPiece piece) {
		if (i < this.size && j < this.size && this.board[i][j] == null) {
			this.board[i][j] = piece;
			return true;
		}
		return false;
	}

	public boolean hasSpace() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (this.board[i][j] == null) {
					return true;
				}
			}
		}
		return false;
	}
}
