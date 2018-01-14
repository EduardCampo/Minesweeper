package minesweeper;

import java.util.HashMap;
import java.util.Map;

public class GetWinnersDBMock implements GetWinnersDB{
	
	//Mock de GetWinnersDB para simular una query a la database que 
	//devuelve un Map con los ganadores. Se utiliza en la función ShowWinners
	@Override
	public Map<String, Integer> getWinners(){
		Map<String, Integer> winners = new HashMap<>();
		winners.put("Javi",5);
		winners.put("Eduard",7);
		winners.put("Robert",4);
		
		return winners;
	}

	
}
