// this class deals with the battle of hero and monster
//done
package gameplay;
import java.util.ArrayList;
import java.util.Scanner;
import board.Cell;
import characters.DataHeroes;
import characters.DataMonsters;
import characters.Hero;
import characters.Monster;
import java.util.Random;
public class Battle {
private ArrayList<Hero> heros;
private ArrayList<Monster> monsters;
private DataMonsters enemy;
private int roundNum;
private boolean fightOver;
private Random random;
private Scanner scan = new Scanner(System.in);
public Battle(ArrayList<Hero> heros)
	{
		this.heros = heros;
		this.monsters = new ArrayList<>();
		this.enemy = new DataMonsters();
		this.roundNum = 0;
		this.fightOver = false;
		this.random = new Random();
	}
	// the main function of battle
	public void battle(){
		generateMonster(heros.size());
		round();
	}
	// each round of the fight
	public void round(){
		roundNum += 1;
		System.out.println("Round " + roundNum + " of the fight");
		// show information before each round of the fight
		showHeroInfo(heros);
		showMonsterInfo(monsters);
		// heros take turns to choose an action
		for (int i = 0; i < heros.size(); i++){
			if(!heros.get(i).getIsFainted()){
				action(i);
			}
		}
		// check if the battle is over
		battleIsOver();
		// monsters take turns to attack back
		for (int m = 0; m < monsters.size(); m++){
			if (!monsters.get(m).getIsFainted()) {
				int monsterTarget = m;
				// get the attack target
				if(!heros.get(monsterTarget).getIsFainted()){
					monsters.get(m).attack(heros.get(monsterTarget));
				}else{
					for (int j = 0; j < heros.size(); j++){
						if (!heros.get(j).getIsFainted()) {
							monsterTarget = j;
							break;
						}
					}
					monsters.get(m).attack(heros.get(monsterTarget));
				}
			}
		}
		// check if the battle is over
		battleIsOver();

		if (fightOver){
			return;
		}
		// heros recover some hp and mana after each round
		else{
			for (Hero h: heros){
				if(!h.getIsFainted()){
				 	h.setHp((int)(h.getHp()*1.1));
					h.setMana((int)(h.getMana()*1.1));
				}
			}
			// proceed to the next round
			round();
		}
	}
	public void battleIsOver() {
        boolean allHeroesFaint = true;
        boolean allMonstersFaint = true;
        for (Hero h : heros) {
            if (!h.getIsFainted()) {
                allHeroesFaint = false;
                break;
            }
        }
        for (Monster m : monsters) {
            if (!m.getIsFainted()) {
                allMonstersFaint = false;
                break;
            }
        }
        if (allHeroesFaint) {
            System.out.println("All heroes are faint! Game Over!");
            fightOver = true; 
        }
        if (allMonstersFaint && !allHeroesFaint) {
            System.out.println("Team Hero wins!");
            fightOver = true; 
        }
    }
	// This function is in charge of heros' action in each round
public void action(int heroIndex) {
	System.out.println("It's hero " + heros.get(heroIndex).getName() + "'s turn!");
	MandH.colorDisplay(Cell.ANSI_CYAN, "Below are the operations you can choose during the fight:");
	DataHeroes.linePattern.printPattern();
	MandH.colorDisplay(Cell.ANSI_YELLOW, "1: Attack" + "           ");
	MandH.colorDisplay(Cell.ANSI_YELLOW, "2: Change Weapon");
	MandH.colorDisplay(Cell.ANSI_YELLOW, "3: Change Armor" + "     ");
	MandH.colorDisplay(Cell.ANSI_YELLOW, "4: Use potion");
	MandH.colorDisplay(Cell.ANSI_YELLOW, "5: Cast a spell" + "     ");
	MandH.colorDisplay(Cell.ANSI_RED, "6: Quit.");
	DataHeroes.linePattern.printPattern();
	
		// get hero's target
		int heroTarget = getHeroTarget(heroIndex);
	
		int temp = getUserInput();
		switch (temp) {
			// attack
			case 1:
				System.out.println("Hero " + heros.get(heroIndex).getName() + " attacks!");
				heros.get(heroIndex).attack(monsters.get(heroTarget));
				break;
			// change weapon
			case 2:
				System.out.println("Hero " + heros.get(heroIndex).getName() + "  changes weapon!");
				heros.get(heroIndex).changeWeapon();
				break;
			//  change armor
			case 3:
				System.out.println("Hero " + heros.get(heroIndex).getName() + " changes armor!");
				heros.get(heroIndex).changeArmour();
				break;
			//  use a potion
			case 4:
				System.out.println("Hero " + heros.get(heroIndex).getName() + " uses a potion!");
				heros.get(heroIndex).potion();
				break;
			// cast a spell
			case 5:
				System.out.println("Hero " + heros.get(heroIndex).getName() + " casts a spell!");
				heros.get(heroIndex).BuySpell(monsters.get(heroTarget));
				break;
			// quit 
			case 6:
				System.out.println("Goodbye!");
				System.exit(0);
		}
	}
	private int getHeroTarget(int heroIndex) {
		// get hero's target
		return monsters.get(heroIndex).getIsFainted() ? getLivingMonsterIndex() : heroIndex;
	}
	private int getLivingMonsterIndex() {
		for (int i = 0; i < monsters.size(); i++) {
			if (!monsters.get(i).getIsFainted()) {
				return i;
			}
		}
		return -1; // If all monsters are fainted
	}
	private int getUserInput() {
		int temp;
		while (true) {
			String input = scan.nextLine();
			if (input.equals("q")) {
				System.out.println("Goodbye!");
				System.exit(0);
			}
			try {
				temp = Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("Invalid input. Must be an integer.");
				continue;
			}
			if (temp < 1 || temp > 6) {
				System.out.println("Invalid input. Must be between 1 and 6.");
				continue;
			}
			break;
		}
		return temp;
	}
	public void generateMonster(int size){
		MandH.colorDisplay(Cell.ANSI_RED, "FIGHT!!!");
		MandH.colorDisplay(Cell.ANSI_CYAN, "Monster Info: ");
		while (monsters.size() < size){
			int i = random.nextInt(size);
			monsters.add(enemy.getBeast().get(i));
		}
		showMonsterInfo(monsters);
	}
	public void showMonsterInfo(ArrayList<Monster> monsters) {
		MandH.colorDisplay(Cell.ANSI_CYAN, "Monster Info: ");
		DataHeroes.linePattern.printPattern();
		MandH.colorDisplay(Cell.ANSI_GREEN, "No |      Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status");
		
		for (int i = 0; i < monsters.size(); i++) {
			Monster currentMonster = monsters.get(i);
			System.out.printf("%-3s %-20s", (i + 1), currentMonster.getName());
			System.out.printf("%-10s", currentMonster.getHp());
			System.out.printf("%-10s", currentMonster.getLevel());
			System.out.printf("%-10s", currentMonster.getDamage());
			System.out.printf("%-10s", currentMonster.getDefense());
			System.out.printf("%-10s", currentMonster.getDodge());
			System.out.printf("%-10s", currentMonster.getIsFainted() ? "Fainted" : "Alive");
			System.out.println();
		}
		DataHeroes.linePattern.printPattern();
	}
	public void showHeroInfo(ArrayList<Hero> heroes) {
		int num = 0;
		MandH.colorDisplay(Cell.ANSI_CYAN, "Hero Info: ");
		DataHeroes.linePattern.printPattern();
		MandH.colorDisplay(Cell.ANSI_GREEN, "No |        Name       | HP | Mana | Strength | Agility | Dexterity | Money | experience | Type | Status");
	
		for (Hero hero : heroes) {
			System.out.printf("%-4s %-22s", (++num), hero.getName());
			System.out.printf("%-10s", hero.getHp());
			System.out.printf("%-10s", hero.getMana());
			System.out.printf("%-10s", hero.getStrength());
			System.out.printf("%-10s", hero.getAgility());
			System.out.printf("%-10s", hero.getDexterity());
			System.out.printf("%-10s", hero.getMoney());
			System.out.printf("%-10s", hero.getExp());
			System.out.printf("%-10s", hero.getIsFainted() ? "Fainted" : "Alive");
			System.out.println();
		}
		DataHeroes.linePattern.printPattern();
	}
}
