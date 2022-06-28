package TrisManager;

import java.util.ArrayList;
import java.util.Scanner;

import Grid.Grid;
import Player.Player;

public class TrisManager {

	Grid grid;
	ArrayList<Player> players;

	public TrisManager() {
		players = new ArrayList<Player>();
		players.add(new Player(1, "X"));
		players.add(new Player(2, "O"));
		grid = new Grid();

	}

	public void initGrid(String[][] grid) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				grid[i][j] = " ";

			}

		}

	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public void makeGrid(String[][] grid) {

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {
				if (j <= 2) {

					System.out.print(" " + grid[i][j]);
					System.out.print(" |");
				}

			}
			if (i < 2) {
				System.out.print("\n");
				System.out.print("---+---+---");
				System.out.print("\n");
			}

		}
		System.out.print("\n");

	}

	public boolean makeChoise(Player player, String[][] grid) {
		int x = 0, y = 0;

		System.out.println("scegli in che punto applicare il simbolo");
		System.out.println("riga:");
		Scanner s1 = new Scanner(System.in);
		x = s1.nextInt();
		System.out.println("colonna:");
		Scanner s = new Scanner(System.in);
		y = s.nextInt();

		try {
			if (grid[x - 1][y - 1].equals(" ")) {
				grid[x - 1][y - 1] = player.getSimbol();
			} else {

				System.out.println("cella gia occupata");
				return makeChoise(player, grid);

			}
		} catch (Exception e) {
			System.out.println("scelta non consentita");

			return makeChoise(player, grid);
		}

		if (checkWin(player, grid)) {
			makeGrid(grid);
            System.out.println("il giocatore " + player.getN() + " HA VINTO ");
			return true;
		}

		return false;
	}

	boolean checkWin(Player player, String[][] grid) {

		if (grid[0][0].equals(player.getSimbol()) && grid[0][1].equals(player.getSimbol())
				&& grid[0][2].equals(player.getSimbol())) {

			return true;

		} else if (grid[1][0].equals(player.getSimbol()) && grid[1][1].equals(player.getSimbol())
				&& grid[1][2].equals(player.getSimbol())) {

			return true;

		} else if (grid[2][0].equals(player.getSimbol()) && grid[2][1].equals(player.getSimbol())
				&& grid[2][2].equals(player.getSimbol())) {

			return true;

		} else if (grid[0][0].equals(player.getSimbol()) && grid[1][0].equals(player.getSimbol())
				&& grid[2][0].equals(player.getSimbol())) {

			return true;

		} else if (grid[0][1].equals(player.getSimbol()) && grid[1][1].equals(player.getSimbol())
				&& grid[2][1].equals(player.getSimbol())) {

			return true;

		} else if (grid[0][2].equals(player.getSimbol()) && grid[1][2].equals(player.getSimbol())
				&& grid[2][2].equals(player.getSimbol())) {

			return true;

		} else if (grid[0][0].equals(player.getSimbol()) && grid[1][1].equals(player.getSimbol())
				&& grid[2][2].equals(player.getSimbol())) {

			return true;

		}
		return false;

	}

	/////////////////////////////////////////////// gettter and setters

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

}
