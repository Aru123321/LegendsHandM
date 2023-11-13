package characters;
// this class deals with the capabilities of monsters
import java.util.*;
public class Monster extends Being {
	private int damage;
	private double dodge;
	public Monster(String name, int level, int damage, int defense, double dodge)
	{
		super(name, level, defense);
		this.damage = damage;
		this.dodge = dodge;
	}
	public boolean tryDodge() {
        Random random = new Random();
        int dodgeChance = 20; // Dodge chance in percent
        int dodgeRoll = random.nextInt(100) + 1; 
        return dodgeRoll <= dodgeChance; // If roll is within dodge chance, dodge is successful
    }
	public int Monsterdefense(int damage) {
        int damageReduction = (int)(this.getDefense() * 0.01); 
        int finalDamage = damage - damageReduction;
        finalDamage = Math.max(finalDamage, 0);
        this.setHp(this.getHp() - finalDamage);
        System.out.println(this.getName() + " takes " + finalDamage + " damage.");
        return finalDamage;
    }
	//getters and setters
	public int getDamage(){
		return damage;
	}
	public double getDodge(){
		return dodge;
	}
	public void setDamage(int damage){
		this.damage = damage;
	}
	public void setDodge(double dodge){
		this.dodge = dodge;
	}
	// monster attacking a hero
	public void attack(Hero hero) {
		int effect = hero.Herodefense(damage);
		if (effect != 0) {
			System.out.println("Monster " + name + " caused " + damage + " damage to the hero " + hero.getName());
		}
	}
	// hero attacking monster
	public int defense(int damage){
		int effect = 0;// 0 damage if attack misses
		Random random = new Random();
		int temp = random.nextInt(10) + 1;
		// monster dodging attack
		if (temp < (int) (dodge*0.1)){
			System.out.println("Monster " + name + " dodged the attack");
			return effect;

		} else{
			hp = hp-damage;
			if(hp <= 0){// if the monster gets attacked
				setIsFainted();
				System.out.println("Monster " + name + " has been knocked out");
			}
		}
		return effect;
	}
}
