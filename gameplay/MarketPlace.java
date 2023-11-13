// market with all the items
//done
package gameplay;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

import characters.DataHeroes;
import characters.Hero;
import items.AllSpells;
import items.Armory;
import items.Potions;
import items.Weapons;
public class MarketPlace {
	private ArrayList<Armory> armours;
	private ArrayList<AllSpells> spells;
	private ArrayList<Weapons> weapons;
	private ArrayList<Potions> potions;
	Scanner sc = new Scanner(System.in);
	public MarketPlace() {
		this.armours = new ArrayList<>();
		this.weapons = new ArrayList<>();
		this.potions = new ArrayList<>();
		this.spells = new ArrayList<>();
		// All types of armours stored in a list
        armours.addAll(readArmorsFromFile("Armory.txt"));

		// All types of weapons stored in a list
        weapons.addAll(readWeaponsFromFile("Weaponry.txt"));

		// potion list
		potions.addAll(readPotionsFromFile("Potions.txt"));

		// fire-spell list
        spells.addAll(readFireSpellsFromFile("FireSpells.txt"));
        spells.addAll(readIceSpellsFromFile("IceSpells.txt"));
        spells.addAll(readLighteningSpellsFromFile("LightningSpells.txt"));

	}
	
	private ArrayList<Armory> readArmorsFromFile(String filePath) {
		ArrayList<Armory> armorsList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			br.readLine(); // Skip the header line
	
			while ((line = br.readLine()) != null) {
				String[] parts = line.trim().split("\\s+");
				if (parts.length == 4) {
					String name = parts[0].trim().replace("_", " ");
					int cost = Integer.parseInt(parts[1].trim());
					int requiredLevel = Integer.parseInt(parts[2].trim());
					int damageReduction = Integer.parseInt(parts[3].trim());
					// Assuming there's a constructor in Armory class that matches these parameters
					Armory armor = new Armory(name, cost, requiredLevel, damageReduction);
					armorsList.add(armor);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return armorsList;
	}
	
	private ArrayList<Weapons> readWeaponsFromFile(String filePath) {
		ArrayList<Weapons> weaponsList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			br.readLine(); // Skip the header line
	
			while ((line = br.readLine()) != null) {
				String[] parts = line.trim().split("\\s+");
				if (parts.length >= 5) { // Adjusted the condition to check for at least 5 parts
					String name = parts[0].trim().replace("_", " ");
					int cost = Integer.parseInt(parts[1].trim());
					int requiredLevel = Integer.parseInt(parts[2].trim());
					int damage = Integer.parseInt(parts[3].trim());
					int requiredHands = Integer.parseInt(parts[4].trim());
					// Assuming there's a constructor in Weapons class that matches these parameters
					Weapons weapon = new Weapons(name, cost, requiredLevel, damage, requiredHands);
					weaponsList.add(weapon);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return weaponsList;
	}

	
	private ArrayList<Potions> readPotionsFromFile(String filePath) {
		ArrayList<Potions> potionsList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			br.readLine(); // Skip the header line
	
			while ((line = br.readLine()) != null) {
				String[] parts = line.trim().split("\\s+");
				if (parts.length >= 4) { // Adjusted the condition to check for at least 4 parts
					String name = parts[0].trim().replace("_", " ");
					int cost = Integer.parseInt(parts[1].trim());
					int requiredLevel = Integer.parseInt(parts[2].trim());
					int attributeIncrease = Integer.parseInt(parts[3].trim());
					String attributeAffected = parts[4].trim(); // This will only take the first attribute if there are multiple
					for (int i = 5; i < parts.length; i++) {
						attributeAffected += " " + parts[i].trim(); // Concatenate the rest of the attributes if present
					}
					// Assuming there's a constructor in Potions class that matches these parameters
					Potions potion = new Potions(name, cost, requiredLevel, attributeIncrease, attributeAffected);
					potionsList.add(potion);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return potionsList;
	}
	
	private ArrayList<AllSpells> readFireSpellsFromFile(String filePath) {
		ArrayList<AllSpells> spellsFire = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			br.readLine(); // Skip the header line
	
			while ((line = br.readLine()) != null) {
				String[] parts = line.trim().split("\\s+");
				if (parts.length >= 5) { // Check for 5 parts to match the spell attributes
					String name = parts[0].trim().replace("_", " ");
					int cost = Integer.parseInt(parts[1].trim());
					int requiredLevel = Integer.parseInt(parts[2].trim());
					int damage = Integer.parseInt(parts[3].trim());
					int manaCost = Integer.parseInt(parts[4].trim());
					// Assuming there's a constructor in AllSpells class that matches these parameters
					AllSpells spell = new AllSpells(name, cost, requiredLevel, damage, manaCost, "Fire");
					spellsFire.add(spell);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return spellsFire;
	}

	private ArrayList<AllSpells> readIceSpellsFromFile(String filePath) {
		ArrayList<AllSpells> spellsIce = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			br.readLine(); // Skip the header line
	
			while ((line = br.readLine()) != null) {
				String[] parts = line.trim().split("\\s+");
				if (parts.length >= 5) { // Check for 5 parts to match the spell attributes
					String name = parts[0].trim().replace("_", " ");
					int cost = Integer.parseInt(parts[1].trim());
					int requiredLevel = Integer.parseInt(parts[2].trim());
					int damage = Integer.parseInt(parts[3].trim());
					int manaCost = Integer.parseInt(parts[4].trim());
					// Assuming there's a constructor in AllSpells class that matches these parameters
					AllSpells spell = new AllSpells(name, cost, requiredLevel, damage, manaCost, "Fire");
					spellsIce.add(spell);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return spellsIce;
	}

		private ArrayList<AllSpells> readLighteningSpellsFromFile(String filePath) {
		ArrayList<AllSpells> spellsLightening = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			br.readLine(); // Skip the header line
	
			while ((line = br.readLine()) != null) {
				String[] parts = line.trim().split("\\s+");
				if (parts.length >= 5) { // Check for 5 parts to match the spell attributes
					String name = parts[0].trim().replace("_", " ");
					int cost = Integer.parseInt(parts[1].trim());
					int requiredLevel = Integer.parseInt(parts[2].trim());
					int damage = Integer.parseInt(parts[3].trim());
					int manaCost = Integer.parseInt(parts[4].trim());
					// Assuming there's a constructor in AllSpells class that matches these parameters
					AllSpells spell = new AllSpells(name, cost, requiredLevel, damage, manaCost, "Fire");
					spellsLightening.add(spell);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return spellsLightening;
	}
	


	//getters and setters
	public ArrayList<Armory> getArmours(){
		return armours;
	}
	public ArrayList<Potions> getPotions(){
		return potions;
	}
	public ArrayList<AllSpells> getSpells(){
		return spells;
	}
	public ArrayList<Weapons> getWeapons(){
		return weapons;
	}
	public void setArmours(ArrayList<Armory> armors){
		this.armours = armors;
	}
	public void setPotions(ArrayList<Potions> potions){
		this.potions = potions;
	}
	public void setSpells(ArrayList<AllSpells> spells){
		this.spells = spells;
	}
	public void setWeapons(ArrayList<Weapons> weapons){
		this.weapons = weapons;
	}
	
	public void printWeaponsSale(){// here we have weapons on sale
		System.out.println("Weaponry");
		DataHeroes. linePattern.printPattern();
		System.out.println("No |      Name     |  Cost  |  Required_Level  |  Damage  |  Required_Hand");
		for (int i = 0; i < weapons.size(); i++){
			System.out.printf("%-3s %-18s",(i+1), weapons.get(i).getName());
			System.out.printf("%-14s",weapons.get(i).getCost());
			System.out.printf("%-16s",weapons.get(i).getReqLevel());
			System.out.printf("%-14s",weapons.get(i).getDamage());
			System.out.printf("%-16s",weapons.get(i).getReqHand());
			System.out.println();
		}
		DataHeroes. linePattern.printPattern();
		System.out.println();
	}

	public void printArmoursSale(){//here we have armours on sale
		System.out.println("Armours");
		DataHeroes. linePattern.printPattern();
		System.out.println("No |      Name     |  Cost  |  Req_Level  |  Damage_Reduction");
		for (int i = 0; i < armours.size(); i++){
			System.out.printf("%-3s %-18s",(i+1), armours.get(i).getName());
			System.out.printf("%-14s",armours.get(i).getCost());
			System.out.printf("%-18s",armours.get(i).getReqLevel());
			System.out.printf("%-16s",armours.get(i).getDamageReduction());
			System.out.println();
		}
		DataHeroes. linePattern.printPattern();
	}
	
	public void printSpellSale(){// here we have spells on sale
		System.out.println("Spell");
		DataHeroes. linePattern.printPattern();
		System.out.println("No |      Name     |  Cost  |  Required_Level  |  Damage  |  Mana_Cost  |  Type");
		for (int i = 0; i < spells.size(); i++){
			System.out.printf("%-3s %-18s",(i+1), spells.get(i).getName());
			System.out.printf("%-14s",spells.get(i).getCost());
			System.out.printf("%-16s",spells.get(i).getReqLevel());
			System.out.printf("%-12s",spells.get(i).getDamage());
			System.out.printf("%-10s",spells.get(i).getManaCost());
			System.out.printf("%-14s",spells.get(i).getType());
			System.out.println();
		}
		DataHeroes. linePattern.printPattern();
		System.out.println();
	}

	public void printPotionSale(){// here we have potions on sale
		System.out.println("Potion");
		DataHeroes. linePattern.printPattern();
		System.out.println("No |      Name     |  Cost  |  Required_Level  |  Attribute_Increase    |   Attribute_Affect");
		for (int i = 0; i < potions.size(); i++){
			System.out.printf("%-3s %-18s",(i+1), potions.get(i).getName());
			System.out.printf("%-14s",potions.get(i).getCost());
			System.out.printf("%-16s",potions.get(i).getReqLevel());
			System.out.printf("%-28s",potions.get(i).getAttaffected());
			System.out.printf("%-16s",potions.get(i).getAttincreased());
			System.out.println();
		}
		DataHeroes. linePattern.printPattern();
		System.out.println();
	}

// heroes can trade their currency to buy several items in the market. 
	public void buy(Hero hero){
		while(true) {
			System.out.println("choose an item : 0(back) 1(Weapons), 2(Armours), 3(Spells), 4(Potions)");
			int buy = sc.nextInt();
			if (buy < 0 || buy > 4){//validation
				System.out.println("Invalid. Choose between 0 and 4.");
				continue;
			}
			int buyItem;
			switch (buy){
					// back to the menu
				case 0:
					return;

					// buy weapons
				case 1:
					System.out.println("Choose weapons to buy:(1:1st item, 2:2nd item.....)");
					printWeaponsSale();
					buyItem = sc.nextInt();

					if(hero.getMoney() < weapons.get(buyItem-1).getCost()){
						System.out.println("Insufficient balance");
					}
					else if(hero.getLevel() < weapons.get(buyItem-1).getReqLevel()){
						System.out.println("Inadequate hero level");
					}

					else{
						ArrayList<Weapons> temp = hero.getWeapons();
						temp.add(weapons.get(buyItem-1));
						hero.setWeaponry(temp);
						hero.setMoney(hero.getMoney() - weapons.get(buyItem-1).getCost());
						System.out.println("Succesful! You got: " + weapons.get(buyItem-1).getName());
					}
					break;
					
					// buy armours
				case 2:
					System.out.println("Choose armours to buy:(1:1st item, 2:2nd item.....)");
					printArmoursSale();
					buyItem = sc.nextInt();

					if(hero.getMoney() < armours.get(buyItem-1).getCost()){
						System.out.println("Insufficient balance");
					}
					else if(hero.getLevel() < armours.get(buyItem-1).getReqLevel()){
						System.out.println("Inadequate hero level");
					}
					else{
						ArrayList<Armory> temp = hero.getArmors();
						temp.add(armours.get(buyItem-1));
						hero.setArmory(temp);
						hero.setMoney(hero.getMoney() - armours.get(buyItem-1).getCost());
						System.out.println("Succesful! You got:  " + armours.get(buyItem-1).getName());
					}
					break;


					// buy potions
				case 3:
					System.out.println("Choose potions to buy:(1:1st item, 2:2nd item.....)");
					printPotionSale();
					buyItem = sc.nextInt();

					if(hero.getMoney() < potions.get(buyItem-1).getCost()){
						System.out.println("Insufficient balance");
					}
					else if(hero.getLevel() < potions.get(buyItem-1).getReqLevel()){
						System.out.println("Inadequate hero level");
					}
					else{
						ArrayList<Potions> temp = hero.getPotions();
						temp.add(potions.get(buyItem-1));
						hero.setPotions(temp);
						hero.setMoney(hero.getMoney() - potions.get(buyItem-1).getCost());
						System.out.println("Succesful! You got: " + potions.get(buyItem-1).getName());
					}
					break;

					// buy spells
				case 4:
					System.out.println("Choose spells to buy:(1:1st item, 2:2nd item.....)");
					printSpellSale();
					buyItem = sc.nextInt();

					if(hero.getMoney() < spells.get(buyItem-1).getCost()){
						System.out.println("Insufficient balance");
					}
					else if(hero.getLevel() < spells.get(buyItem-1).getReqLevel()){
						System.out.println("Inadequate hero level");
					}
					else{
						ArrayList<AllSpells> temp = hero.getSpells();
						temp.add(spells.get(buyItem-1));
						hero.setSpells(temp);
						hero.setMoney(hero.getMoney() - spells.get(buyItem-1).getCost());
						System.out.println("Succesful! You got: " + spells.get(buyItem-1).getName());
					}
					break;
			}
		}
	}

	public void sell(Hero hero){// heroes can sell their items in the market.
		while(true){
			System.out.println("what do you want to sell? :0(leave) 1(Armory), 2(Weaponry), 3(Potion), 4(Spell)");
			int sellType = sc.nextInt();
			if (sellType < 0 || sellType > 4){//input validation
				System.out.println("Invalid . Choose between 0 and 4.");
				continue;
			}
			int sellItem;
			switch (sellType) {
					// back to the menu
				case 0:
					return;

					// sell weapons
				case 1:

					if (hero.getWeapons().isEmpty()) {
						System.out.println("no weapons to sell.");
					} else {
						System.out.println("Choose weapon you wanna sell: (1: 1st item, 2: 2nd item...)");
						for (Weapons w:hero.getWeapons()) {
							System.out.println(w.getName());
						}
						sellItem = sc.nextInt();
						ArrayList<Weapons> temp = hero.getWeapons();
						temp.remove(hero.getWeapons().get(sellItem - 1));
						hero.setWeaponry(temp);
						hero.setMoney(hero.getMoney() + weapons.get(sellItem - 1).getCost());
						System.out.println("Successful Transaction! you sold: " + weapons.get(sellItem - 1).getName());
					}
					break;
					// sell armours
				case 2:

					if (hero.getArmors().isEmpty()) {
						System.out.println("no armours to sell.");
					} else {
						System.out.println("Choose armour you wanna sell: (1: 1st item, 2: 2nd item...)");
						for (Armory a:hero.getArmors()) {
							System.out.println(a.getName());
						}
						sellItem = sc.nextInt();
						ArrayList<Armory> temp = hero.getArmors();
						temp.remove(hero.getArmors().get(sellItem - 1));
						hero.setArmory(temp);
						hero.setMoney(hero.getMoney() + armours.get(sellItem - 1).getCost());
						System.out.println("Successful Transaction! you sold: " + armours.get(sellItem - 1).getName());
					}
					break;
					//sell spells
					case 3:
					if (hero.getSpells().isEmpty()) {
						System.out.println("no spells to sell.");
					} else {
						System.out.println("Choose armour you wanna sell: (1: 1st item, 2: 2nd item...)");
						for (AllSpells s:hero.getSpells()) {
							System.out.println(s.getName());
						}
						sellItem = sc.nextInt();
						ArrayList<AllSpells> temp = hero.getSpells();
						temp.remove(hero.getSpells().get(sellItem - 1));
						hero.setSpells(temp);
						hero.setMoney(hero.getMoney() + spells.get(sellItem - 1).getCost());
						System.out.println("Successful Transaction! you sold: " + spells.get(sellItem - 1).getName());
					}
					break;
					// sell potions
				case 4:
					if (hero.getPotions().isEmpty()) {
						System.out.println("no spells to sell.");
					} else {
						System.out.println("Choose armour you wanna sell: (1: 1st item, 2: 2nd item...)");
						for (Potions p:hero.getPotions()) {
							System.out.println(p.getName());
						}
						sellItem = sc.nextInt();
						ArrayList<Potions> temp = hero.getPotions();
						temp.remove(hero.getPotions().get(sellItem - 1));
						hero.setPotions(temp);
						hero.setMoney(hero.getMoney() + potions.get(sellItem - 1).getCost());
						System.out.println("Successful Transaction! you sold: " + potions.get(sellItem - 1).getName());
					}
					break;			
			}
		}
	}
	// heros can make a trade
	public void trade(Hero hero){
		int buyOrSell;

		System.out.println(hero.getName() + ": Welcome to market. buy/sell items here. 0 to leave.");
		while(true) {
			System.out.println("Do you want to buy or sell: 0: leave, 1: buy, 2: sell ");
			String input = sc.nextLine();
			if (input.equals("q")) {
				System.out.println("Goodbye!");
				System.exit(0);
			}
			try {
				buyOrSell = Integer.parseInt(input);
				// input size is not an integer
			} catch (Exception e){

				System.out.println("Invalid input. Must be an integer.");
				continue;
			}
			// input out of index
			if (buyOrSell < 0 && buyOrSell > 2) {
				System.out.println("Invalid input. Must be 1 or 2.");
				continue;
			}
			break;
		}
		// leave the market
		if (buyOrSell == 0){
			System.out.println("Thanks for trading!");
		}
		// trade items
		if (buyOrSell == 1){
			buy(hero);
		}
		// sell items
		else if (buyOrSell == 2){
			sell(hero);
		}
	}
}
