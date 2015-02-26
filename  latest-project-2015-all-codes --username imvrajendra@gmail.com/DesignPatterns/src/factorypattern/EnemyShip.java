package factorypattern;

public abstract class EnemyShip {
	private String name;
	private double amtDamage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmtDamage() {
		return amtDamage;
	}
	public void setAmtDamage(double amtDamage) {
		this.amtDamage = amtDamage;
	}
	
	public void followHeroShiop(){
		System.out.println(getName()+" Following Hero Ship");
	}
	public void displayEnemyShip(){
		System.out.println(getName()+" is on Screen");
	}
	public void shootHeroShiop(){
		System.out.println(getName()+" shooting Hero Ship damage "+getAmtDamage());
	}
}
