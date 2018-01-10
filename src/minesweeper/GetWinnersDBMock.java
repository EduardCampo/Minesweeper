package minesweeper;

import java.util.Hashtable;

public class GetWinnersDBMock implements GetWinnersDB{
	
	@Override
	public String[] getWinners(){
		String [] winners =  {"Javi","Eduard","Doctor Cebolla"};
		return winners;
	}

	
}
