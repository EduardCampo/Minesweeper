package minesweeper;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class ExploratoryTesting {
	
	// Test exploratori
	// Hi ha comentaris de tot el que s'ha anat pensant
	// i trobant durant el test per facilitar el seguiment
	
	@Test
	public void test() {
		// Nova instància board per testejar
		Board board = new Board();
		
		// Nova instància utilities per testejar
		Utilities util = new Utilities();
		
		// Iniciem la simulació de inputs
		ByteArrayInputStream in;
		
		// Només entrar es demana el nombre de mines que volem posar
		// Si escric algo que no sigui un nombre, hauria de controlar-se
		in = new ByteArrayInputStream("error!error!".getBytes());
		System.setIn(in);
		assertEquals(0,util.getNumberOfMines());
		
		// Perfecte, em torna demanar un altre input
		// I si intento posar més mines de les que hi caben?
		in = new ByteArrayInputStream("100".getBytes());
		System.setIn(in);
		assertEquals(0,util.getNumberOfMines());
		
		// Altre cop em demana un altre input
		// I si vull posar mines negatives? 
		in = new ByteArrayInputStream("-5".getBytes());
		System.setIn(in);
		assertEquals(0,util.getNumberOfMines());
		
		// També m'ho torna a demanar, funciona correctament
		// Li direm doncs que volem 7 mines
		in = new ByteArrayInputStream("7".getBytes());
		System.setIn(in);
		assertEquals(7,util.getNumberOfMines());
		
		// Cap problema fins aqui
		// Em demana la posició x i y de la primera mina
		// I si poso coordenades fora dels límits?
		assertFalse(board.placeMine(-3, 10));
		
		// Altre cop em demana que intenti posar la mina 1
		// La posaré a la ubicació 1 1
		assertTrue(board.placeMine(1, 1));
		
		// A veure si s'ha posat bé
		assertEquals('M',board.getChar(1, 1));
		
		// Doncs sí, hi ha una mina a la casella 1 1
		// Poso la segona mina a la ubicació 0 1
		assertTrue(board.placeMine(0, 1));
		assertEquals('M',board.getChar(0, 1));
		
		// Es controla un error si poso la mina numero 3
		// a sobre de la mina numero 2?
		assertFalse(board.placeMine(0, 1));
		
		// Exactament, no em deixa posar la mina i em demana
		// un altre cop que indiqui on vull posar la mina 3
		// Posem les 5 mines restants (3,4,5,6,7) al taulell
		assertTrue(board.placeMine(3, 3));
		assertEquals('M',board.getChar(3, 3));
		assertTrue(board.placeMine(3, 1));
		assertEquals('M',board.getChar(3, 1));
		assertTrue(board.placeMine(5, 5));
		assertEquals('M',board.getChar(5, 5));
		assertTrue(board.placeMine(2, 3));
		assertEquals('M',board.getChar(3, 3));
		assertTrue(board.placeMine(0, 5));
		assertEquals('M',board.getChar(0, 5));
		
		board.printBoard();
		// A les caselles hi ha les mines que hem posat
		// Ara em demana una opció, 1 o 2
		// I si escric algo que no sigui una opció?
		in = new ByteArrayInputStream("opcio 1 siusplau".getBytes());
		System.setIn(in);
		assertEquals(0,util.getOption());
		
		// Em demana la opció un altre cop
		// Probaré amb nombres que no siguin 1 i 2
		in = new ByteArrayInputStream("5".getBytes());
		System.setIn(in);
		assertEquals(0,util.getOption());
		in = new ByteArrayInputStream("-2".getBytes());
		System.setIn(in);
		assertEquals(0,util.getOption());
		
		// Seleccionarem ara la opció de posar banderes
		in = new ByteArrayInputStream("2".getBytes());
		System.setIn(in);
		assertEquals(2,util.getOption());
		
		// Hem de dir-li on volem posar la bandera
		// La posarem sobre la casella 1 1, que sabem que hi ha una mina
		assertTrue(board.setFlag(1,1));
		
		// La casella 1 1 ara hauria de contenir la lletra F
		assertEquals('F',board.getChar(1,1));
		
		// Ara posarem una bandera sobre la casella 0 0, on NO hi ha una mina
		assertTrue(board.setFlag(0,0));
		
		// La casella 0 0 ara hauria de contenir la lletra I
		assertEquals('I',board.getChar(0,0));
		
		// Probem doncs de treure la bandera de la casella 1 1
		// Hauria d'acabar tenint el M que indica que la casella és una mina
		assertTrue(board.setFlag(1,1));
		assertEquals('M',board.getChar(1,1));
		
		// També podem treure la bandera de la casella 0 0
		// Hauria d'acabar tenint el · que indica que la casella NO és una mina
		assertTrue(board.setFlag(0,0));
		assertEquals('·',board.getChar(0,0));
		
		// Probarem doncs si funciona el sistema d'obrir caselles
		// Seleccionarem la opció 1 al menú
		in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		assertEquals(1,util.getOption());
		
		// Obrirem la casella 0 0 on hi ha d'aparèixer un 2, ja que té
		// dues mines concurrents: a les caselles 1 1 i 0 1
		assertEquals(2,board.checkMinesAround(0, 0));
		assertEquals('2',board.getChar(0, 0));
		
		// La casella 1 0 també ha de contenir un 2
		assertEquals(2,board.checkMinesAround(1, 0));
		assertEquals('2',board.getChar(1, 0));
		
		// La casella 2 2 té 5 mines al voltant, a veure si funciona
		assertEquals(4,board.checkMinesAround(2, 2));
		assertEquals('4',board.getChar(2, 2));
		
		// La casella 0 3 no té cap mina al voltant. Això significa que s'haurien
		// d'obrir les caselles que tingui al voltant, anem a veure si funciona
		assertEquals(0,board.checkMinesAround(0, 3));
		assertEquals('-',board.getChar(0, 3));
		assertEquals('2',board.getChar(0, 2));
		assertEquals('3',board.getChar(1, 2));
		assertEquals('1',board.getChar(1, 3));
		assertEquals('1',board.getChar(0, 4));
		assertEquals('2',board.getChar(1, 4));
		
		// S'ha obert correctament el que estava buit i els del voltant.
		// Ara mirarem de perdre el joc, però apretant una casella on hi hagi
		// una bandera sobre una mina a veure si també funciona així
		assertTrue(board.setFlag(1,1));
		assertEquals('F',board.getChar(1,1));
		assertFalse(board.openSquare(1,1));
		
		// Hem vist el Game Over i el taulell Per tant ha detectat que hem perdut
		// Aquí acaba el test exploratori
		
	}

}
