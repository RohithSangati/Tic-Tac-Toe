
public class Main {

	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		System.out.println("TicTacToe Game started........");
		String result = game.startGame();
		if(result.equals("tie")) {
			System.out.println("Game tied");
		}else {			
			System.out.println(result+" won the game");
		}
	}

}
