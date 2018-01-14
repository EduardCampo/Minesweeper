package minesweeper;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class LoopTesting {


	//Test del loop de toString haciendo 0,1,2 o 3 iteraciones (no upper bound)
	//comprueba que el string que devuelve la funcion es igual al esperado
	@Test
	public void toStringLoopTest() {
		Utilities util = new Utilities();
		Map<String, Integer> winners = null;
		String test = null;
		String test2 = null;
		test = MapUtil.toString(winners);
		assertEquals(test,null);
		
		Map<String, Integer> winners2 = new HashMap<>();
		winners2.put("Javi",5);
		test = MapUtil.toString(winners2);
		test2 = "Javi=5\n";
		assertEquals(test,test2);
		
		Map<String, Integer> winners3 = new HashMap<>();
		winners3.put("Javi",5);
		winners3.put("Eduard",7);
		test = MapUtil.toString(winners3);
		System.out.println(test);
		test2 = "Javi=5\nEduard=7\n";
		assertEquals(test,test2);
		
		Map<String, Integer> winners4 = new HashMap<>();
		winners4.put("Roberto",4);
		winners4.put("Javi",5);
		winners4.put("Eduard",7);
		test = MapUtil.toString(winners4);
		System.out.println(test);
		test2 = "Roberto=4\nJavi=5\nEduard=7\n";
		assertEquals(test,test2);

	}



}
