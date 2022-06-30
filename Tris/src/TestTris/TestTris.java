package TestTris;

import Player.Player;
import TrisManager.TrisManager;

public class TestTris {

	public static void main(String[] args) {
		boolean winner=false;
		int turn=1;
		TrisManager tm =new TrisManager();
		
		
		tm.initGrid(tm.getGrid().getRows());
		
		
		
		
	  while(!winner && turn<5) {
		 tm.makeGrid(tm.getGrid().getRows());
		
		 System.out.println("turno "+ turn);
		 System.out.println("il giocatore 1 comincia");
		
		winner= tm.makeChoise(tm.getPlayers().get(0), tm.getGrid().getRows(),turn);
		if(!winner) {
			
	     tm.makeGrid(tm.getGrid().getRows());	
			
		 System.out.println(" giocatore 2 tocca a te");
		
		 winner= tm.makeChoise(tm.getPlayers().get(1), tm.getGrid().getRows(),turn);
	
		}
		 turn++;
		
		}
		
		
		
		
		
	}

}
