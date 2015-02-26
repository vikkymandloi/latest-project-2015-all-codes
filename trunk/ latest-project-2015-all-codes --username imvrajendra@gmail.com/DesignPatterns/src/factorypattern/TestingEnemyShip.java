package factorypattern;

import java.util.Scanner;

public class TestingEnemyShip {

	public static void main(String[] args) {
		EnemyShip ship = null;
		Scanner scan = new Scanner(System.in);
		String val = scan.nextLine();
		ship = EnemyShipFactory.makeEnemyShip(val);
		doStuffEnemy(ship);
	}
	
	public static void doStuffEnemy(EnemyShip enemy) {
		enemy.displayEnemyShip();
		enemy.followHeroShiop();
		enemy.shootHeroShiop();
	}
	
}
