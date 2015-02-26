package factorypattern;

public class EnemyShipFactory {
	public static EnemyShip makeEnemyShip(String newShipType){
		EnemyShip enemy = null;
		if("U".equals(newShipType))
			enemy = new UFOEmemyShip();
		else if("R".equals(newShipType))
			enemy = new RocketEnemyShip();
		
		return enemy;
	}
}
