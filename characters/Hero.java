//this is the calss for heroes in the game
package characters;
//done
import java.util.*;
import items.AllSpells;
import items.Armory;
import items.Potions;
import items.Weapons;
public class Hero extends Being {
private int mana;
private int strength;
private int agility;
private int dexterity;
private int money;
private int exp;
private int hands = 2;// every hero has 2 hands to equip two items
private String type; // type of hero
private Weapons weapon;
private Armory armor;
private ArrayList<Armory> armors;
private ArrayList<Weapons> weapons;
private ArrayList<Potions> potions;
private ArrayList<AllSpells> spells;

	public Scanner sc = new Scanner(System.in);
	public Hero(String name, int level, int defense,
				int mana, int strength, int agility, int dexterity, int money, int exp, String type)
	{
		super(name, level, defense);
		this.mana = mana;
		this.strength = strength;
		this.agility = agility;
		this.dexterity = dexterity;
		this.money = money;
		this.exp = exp;
		this.type = type;
		this.weapon = null;
		this.armor = null;

		armors = new ArrayList<>();
		weapons = new ArrayList<>();
		potions = new ArrayList<>();
		spells = new ArrayList<>();
	}
	//getters and setters
	public int getMana(){
		return mana;
	}
	public int getStrength(){
		return strength;
	}
	public int getAgility(){
		return agility;
	}
	public int getDexterity(){
		return dexterity;
	}
	public int getMoney(){
		return money;
	}
	public int getExp(){
		return exp;
	}
	public int getHands(){
		return hands;
	}
	public String getType(){// this is the hero type
		return type;}
	public Weapons getWeapon(){
		return weapon;
	}
	public Armory getArmor(){
		return armor;
	}
	public void setMana(int mana){
		this.mana = mana;
	}
	public void setStrength(int strength){
		this.strength = strength;
	}
	public void setAgility(int agility){
		this.agility = agility;
	}
	public void setDexterity(int dexterity){
		this.dexterity = dexterity;
	}
	public void setMoney(int money){
		this.money = money;
	}
	public void setExp(int exp){
		this.exp = exp;
	}
	public void setHands(int hand){
		this.hands = hand;
	}
	public void setWeapon(Weapons weapon){
		this.weapon = weapon;
	}
	public void setArmor(Armory armor){
		this.armor = armor;
	}
	public void setType(String type){
		this.type = type;
	}
	public ArrayList<Armory> getArmors()
	{
		return armors;
	}
	public ArrayList<Weapons> getWeapons()
	{
		return weapons;
	}
	public ArrayList<Potions> getPotions()
	{
		return potions;
	}
	public ArrayList<AllSpells> getSpells()
	{
		return spells;
	}
	public void setArmory(ArrayList<Armory> armors){
		this.armors = armors;
	}
	public void setPotions(ArrayList<Potions> potions){
		this.potions = potions;
	}
	public void setSpells(ArrayList<AllSpells> spells){
		this.spells = spells;
	}
	public void setWeaponry(ArrayList<Weapons> weapons){
		this.weapons = weapons;
	}
	// now we will do hero level up depending on the information in the assignment. the level up is based on the exp gained
	public void levelUp() {
		// The mana will be increased by 10% and rounded up to the nearest integer
		mana = (int) Math.ceil(mana * 1.1);
	
		// For each level, we will reset the experience level to 0
		exp = 0;
	
		double strengthMultiplier = 1.0;
		double agilityMultiplier = 1.0;
		double dexterityMultiplier = 1.0;
	
		if (type.equals("sorcerer")) {
			// if hero = sorcerer, strength gain = 10%, agility gain = 30%, dexterity gain = 30%
			agilityMultiplier = 1.3;
			dexterityMultiplier = 1.3;
		} else if (type.equals("paladins")) {
			// if hero = paladin, strength gain = 30%, agility gain = 30%, dexterity gain = 10%
			strengthMultiplier = 1.3;
			agilityMultiplier = 1.3;
		} else if (type.equals("warrior")) {
			// if hero = warrior, strength gain = 30%, agility gain = 10%, dexterity gain = 30%
			strengthMultiplier = 1.3;
			dexterityMultiplier = 1.3;
		}
	
		// Apply the multiplier to the existing attributes and round to the nearest integer
		strength = (int) Math.round(strength * strengthMultiplier);
		agility = (int) Math.round(agility * agilityMultiplier);
		dexterity = (int) Math.round(dexterity * dexterityMultiplier);
	}
	
	
	// when heroes attack monsters
    public void attack(Monster monster) {
        int damage = (this.weapon != null) ? (int) ((this.weapon.getDamage() + this.strength) * 0.05) : (int) (this.strength * 0.05);

        if (!monster.tryDodge()) {
            int actualDamage = monster.Monsterdefense(damage);
            System.out.println(this.getName() + " attacked " + monster.getName() + " with " + 
                               (this.weapon != null ? this.weapon.getName() : "fists") + 
                               ", causing " + actualDamage + " damage.");
        } else {
            System.out.println(monster.getName() + " dodged the attack from " + this.getName() + ".");
        }
    }
	// when monsters attack heroes.
	public int Herodefense(int damage){
		int effect = 0; // initialize
		Random random = new Random();
		int temp = random.nextInt(10) + 1; // randomly simulating dodging from 1-10
	
		// hero's agility helps in dodging
		if (temp < (int) (agility * 0.002)) {
			System.out.println("Attack is dodged by hero: " + name);
		} else {
			// Check if armor is not null before accessing its methods
			if (armor != null) {
				effect = (int) (damage - armor.getDamageReduction() * 0.01);
			} else {
				// No armor equipped, so full damage is taken
				effect = damage;
			}
	
			if (effect > 0) { // Damage should not be less than 0
				hp -= effect; // update the hp
			}
			
			// Check if hero has been knocked out
			if (hp <= 0) {
				setIsFainted();
				System.out.println("Hero " + name + " has been knocked out!");
			}
		}
		return effect;
	}
	// heroes changing armours
public void changeArmour(){
	if (armors.isEmpty()){
		System.out.println("No armor in the inventory, buy one from the market");
	} else {
		System.out.println("Choose an armor.");
		for (int i = 0; i < armors.size(); i++) {
			System.out.printf("%d. %s%n", i + 1, armors.get(i).getName());
		}
		System.out.printf("Enter the index of the armor to equip with. (1 to %d)%n", armors.size());
		int num = sc.nextInt();
		
		// Check if the entered index is valid
		if (num >= 1 && num <= armors.size()) {
			armor = armors.get(num - 1);
			System.out.println("Your current armor is " + armor.getName() + " now!");
		 } else {
			System.out.println("Invalid index. Please try again.");
		}
	}
}
	

	// heros changing and equipping weapons
public void changeWeapon() {
	if (weapons.isEmpty()) {
		System.out.println("No weapons in the inventory. Buy one from the market.");
	} else {
		System.out.println("Choose a weapon.");
			// Show the weapon inventory.
		for (int i = 0; i < weapons.size(); i++) {
			Weapons w = weapons.get(i);
			w.showInfo();
			System.out.println("Press " + (i + 1) + " for " + w.getName());
		}
		System.out.println("Choose a number corresponding to the weapon. (1 to " + weapons.size() + ")");
			
		int num = sc.nextInt();
	
		if (num < 1 || num > weapons.size()) {
			System.out.println("Invalid selection. Please choose a valid number.");
		} else {
			Weapons selectedWeapon = weapons.get(num - 1);	
				// Check if the hero has enough hands to equip the weapon.
			if (hands < selectedWeapon.getReqHand()) {
				System.out.println("Hands full, can't equip!");
			} else {
				weapon = selectedWeapon;
				System.out.println("Your current weapon: " + weapon.getName());
			}
		}
	}
}
	
public void BuySpell(Monster monster) {
    if (spells.isEmpty()) {
        System.out.println("No spells in the inventory. Buy from the market.");
    } else {
        System.out.println("Choose a spell.");
        // Show the spells in the inventory.
        for (int i = 0; i < spells.size(); i++) {
            AllSpells spell = spells.get(i);
            spell.showInfo();
            System.out.println("Press " + (i + 1) + " for " + spell.getName());
        }
        
        // Hero needs mana to cast a spell.
        int num = sc.nextInt();

        if (num < 1 || num > spells.size()) {
            System.out.println("Invalid selection. Please choose a valid number.");
        } else {
            AllSpells selectedSpell = spells.get(num - 1);

            // Check if the hero has enough mana to cast the spell.
            if (selectedSpell.getManaCost() > mana) {
                System.out.println("Not enough mana.");
            } else {
                int spellManaCost = selectedSpell.getManaCost();
                // Deduct the spell's mana cost from the hero's mana.
                mana -= spellManaCost;

                // Apply the spell effect based on its type.
                switch (selectedSpell.getType().toLowerCase()) {
                    case "fire":
                        monster.setDamage((int)(monster.getDamage() * 0.8));
                        break;
                    case "ice":
                        monster.setDefense((int)(monster.getDefense() * 0.8));
                        break;
                    case "lightning":
                        monster.setDefense((int)(monster.getDefense() * 0.8));
                        break;
                    default:
                        break;
                }

                // Calculate the damage of the spell to the monster.
                int effect = (int)(selectedSpell.getDamage() * (1 + dexterity / 10000));
                monster.defense(effect);

                System.out.println("You used spell " + selectedSpell.getName() + " on monster " + monster.getName());
                spells.remove(selectedSpell); // Remove the spell after using it.
            }
        }
    }
}

	
	// heros using potions 
	public void potion() {
		if (potions.isEmpty()) {
			System.out.println("No potions, buy from market.");
		} else {
			System.out.println("Choose a potion");
			// show all the potions
			for (Potions p : potions) {
				p.showInfo();
			}
			
			// choosing potions
			System.out.println("Choose a potion corresponding to the potion. (1 to " + potions.size() + ")");
			int num = sc.nextInt();
	
			// deal with the effect of the potion
			Potions selectedPotion = potions.get(num - 1);
			String affectedAttribute = selectedPotion.getAttaffected();
			int attributeIncrease = selectedPotion.getAttincreased();
	
			switch (affectedAttribute) {
				case "Health":
					hp += attributeIncrease;
					break;
				case "Strength":
					strength += attributeIncrease;
					break;
				case "Mana":
					mana += attributeIncrease;
					break;
				case "Agility":
					agility += attributeIncrease;
					break;
				case "Dexterity":
					dexterity += attributeIncrease;
					break;
				case "Defense":
					defense += attributeIncrease;
					break;
				default:
					break;
			}
	
			System.out.println(selectedPotion.getName() + " Used successfully");
			potions.remove(selectedPotion);
		}
	}
	
}
