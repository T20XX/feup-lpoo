package maze.test;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import maze.logic.*;
import maze.logic.game.gameState;
public class TestMazeWithStaticDragon {
	@Test
	public void testMoveHeroToFreeCell() throws IOException {
		game g = new game("Test.txt",1);
		assertEquals(1, g.getHero().getY());
		assertEquals(3, g.getHero().getX());
		g.update('A');
		assertEquals(1, g.getHero().getY());
		assertEquals(2, g.getHero().getX());
	}
	@Test
	public void testMoveHeroToWall() throws IOException {
		game g = new game("Test.txt",1);
		assertEquals(1, g.getHero().getY());
		assertEquals(3, g.getHero().getX());
		g.update('W');
		assertEquals(1, g.getHero().getY());
		assertEquals(3, g.getHero().getX());
	}
	@Test
	public void testHeroDies() throws IOException {
		game g = new game("Test.txt",1);
		assertEquals(gameState.RUNNING,g.getState());
		g.update('S');
		assertEquals(gameState.GAMEOVER,g.getState());
	}
	@Test
	public void testExitsafterKillDragon() throws IOException{
		game g = new game("Test.txt",1);
		g.update('A');
		g.update('A');
		g.update('S');
		g.update('S');
		g.update('D');
		g.update('D');
		g.update('W');
		g.update('W');
		g.update('D');
		assertEquals(gameState.WIN, g.getState());
	}
	@Test
	public void testExitsbeforeSword() throws IOException{
		game g = new game("Test.txt",1);
		g.update('D');
		assertEquals(gameState.RUNNING, g.getState());
	}
	@Test
	public void testExitsafterSwordBe4Dragon() throws IOException{
		game g = new game("Test.txt",1);
		g.update('A');
		g.update('A');
		g.update('S');
		g.update('S');
		g.update('W');
		g.update('W');
		g.update('D');
		g.update('D');
		g.update('D');
		assertEquals(gameState.RUNNING, g.getState());
	}
}