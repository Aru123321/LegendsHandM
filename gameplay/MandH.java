//done
package gameplay;
import java.util.*;
import board.Cell;
import board.GameWorld;
import characters.DataHeroes;
import characters.Hero;
public class MandH {
	
	private MarketPlace market;
	private GameWorld gameworld;
	private DataHeroes datahero;
	private ArrayList<Hero> heros;//hero team
	private Battle battle;

	public MandH() {
		this.market = new MarketPlace();
		this.gameworld = new GameWorld(8);
		this.datahero = new DataHeroes();
		this.heros = new ArrayList<>();
		this.battle = new Battle(heros);
	}
    private Scanner sc = new Scanner(System.in);
	private Random random = new Random();

public static void colorDisplay(String ansiColorCode, String printStr) {
	System.out.printf("%s%s\u001b[0m\n", ansiColorCode, printStr);
}
public void play() {

	colorDisplay(Cell.ANSI_CYAN, "Welcome to: 'Legends: Heros and Monsters'!");
	colorDisplay(Cell.ANSI_CYAN, "choose 1-3 heros as a team.");
	colorDisplay(Cell.ANSI_RED, "\"'X: ' inaccessible spot, 'M: ' market, \" + \"'H: 'heros' position\"");
	colorDisplay(Cell.ANSI_CYAN, "choose 1-3 heros as a team and explore the world.");
	colorDisplay(Cell.ANSI_CYAN, "movements: ");
	DataHeroes. linePattern.printPattern();
	colorDisplay(Cell.ANSI_YELLOW, "W/w: Move up." + "            ");
	colorDisplay(Cell.ANSI_YELLOW, "S/s: Move down." + "            ");
	colorDisplay(Cell.ANSI_YELLOW, "A/a: Move left." + "            ");
	colorDisplay(Cell.ANSI_YELLOW, "D/d: Move right");
	colorDisplay(Cell.ANSI_CYAN, "I/i: Show information.");
	colorDisplay(Cell.ANSI_RED, "Q/q: quit");
	DataHeroes. linePattern.printPattern();
		chooseHero();
		gameworld.worldInitialize();//initialize the world
		gameworld.printWorld();// print world

		// player decides what to do
		while(true){
			System.out.println("Press i: information/ m: to move your hero!");
			String input = sc.nextLine();

			// player chooses to move the team
			if (input.equalsIgnoreCase("m")){
				int mov = movement();
				// 3 cases
				if (mov == 1){// player in the market
					for (Hero h: heros) {
						market.trade(h);
					}
				}
				else if (mov == 2){// player in battle scenario
					battle.battle();
				}
				else if (mov == -1){// invalid move validation
					movement();
				}
			}
			else if (input.equalsIgnoreCase("i")){
				showCurrentInfo(heros);
			}
			else if (input.equalsIgnoreCase("q")){
				System.out.println("Goodbye!");
				System.exit(0);
			}
		}
	}
	public int movement(){
		int mov = -1;
		System.out.println("Choose a direction to move:");
		DataHeroes. linePattern.printPattern();
		System.out.print("W/w: Move up." + "            ");
		System.out.println("S/s: Move down.");
		System.out.print("A/a: Move left." + "          ");
		System.out.println("D/d: Move right");
		DataHeroes. linePattern.printPattern();
		gameworld.printWorld();// print the world everytime
		String ip = sc.nextLine();

		// choose to move up
		if (ip.equalsIgnoreCase("W")) {
			int targetX = gameworld.getX() - 1;
			int targetY = gameworld.getY();
		
			if (targetX < 0) {
				System.out.println("Try another direction.");// Can't move up, at the edge
			} else {
				char targetType = gameworld.getBoard()[targetX][targetY].getType();
		
				if (targetType == 'X') {
					System.out.println("Inaccessible area. Try another direction.");
				} else {
					// Move to the target position and update the gameworld's state
					gameworld.getBoard()[gameworld.getX()][gameworld.getY()].setContent(' ');
					gameworld.getBoard()[targetX][targetY].setContent('H');
					gameworld.setX(targetX);
		
					if (targetType == 'M') {
						// Move into the market
						mov = 1; // a successful move to the market
					} else if (targetType == ' ') {
						// Move to an empty space
						mov = (random.nextInt(10) < 3) ? 2 : 0; // 30% chance of encountering monsters
					}
				}
			}
		}
		
// Attempt to move left if 'A' or 'a' is inputted
else if (ip.equalsIgnoreCase("A")) {
    int targetX = gameworld.getX();
    int targetY = gameworld.getY() - 1;
    if (targetY < 0) {
        System.out.println("Try another direction."); // Can't move left, at the edge
    } else {
        char targetType = gameworld.getBoard()[targetX][targetY].getType();
        // Check if an inaccessible area
        if (targetType == 'X') {
            System.out.println("Inaccessible area. Try another direction.");
        } else {
            gameworld.getBoard()[gameworld.getX()][gameworld.getY()].setContent(' ');
            gameworld.getBoard()[targetX][targetY].setContent('H');
            gameworld.setY(targetY);
            if (targetType == 'M') {
                // Move into the market
                mov = 1; // Indicate a successful move to the market
            } else if (targetType == ' ') {
                // Move to an empty space
                mov = (random.nextInt(10) < 3) ? 2 : 0; // 30% chance of encountering monsters
            }
        }
    }
}
// Attempt to move down if 'S' or 's' is inputted
else if (ip.equalsIgnoreCase("S")) {
    int targetX = gameworld.getX() + 1;
    int targetY = gameworld.getY();
    // Check if the current position is at the bottom boundary of the game world
    if (targetX == gameworld.getBoardSize()) {
        System.out.println("Try another direction."); // Can't move down, at the edge
    } else {
        char targetType = gameworld.getBoard()[targetX][targetY].getType();
        if (targetType == 'X') {
            System.out.println("Inaccessible area. Try another direction."); // Can't move into the area
        } else {
            gameworld.getBoard()[gameworld.getX()][gameworld.getY()].setContent(' ');
            gameworld.getBoard()[targetX][targetY].setContent('H');
            gameworld.setX(targetX); 
            if (targetType == 'M') {
                // Move into the market
                mov = 1; // Indicate a successful move to the market
            } else if (targetType == ' ') {
                // Move to an empty space
                mov = (random.nextInt(10) < 3) ? 2 : 0; // 30% chance of encountering monsters
            }
        }
    }
}

// Attempt to move right if 'D' or 'd' is inputted
else if (ip.equals("D") || ip.equals("d")) {
    // Check if the current position is at the right boundary of the game world
    if (gameworld.getY() == (gameworld.getBoardSize() - 1)) {
        System.out.println("Try another direction."); // Can't move right, at the edge
    } else {
        if (gameworld.getBoard()[gameworld.getX()][gameworld.getY() + 1].getType() == 'X') {
            System.out.println("Inaccessible area. Try another direction."); // Can't move into the area
        }
        else if (gameworld.getBoard()[gameworld.getX()][gameworld.getY() + 1].getType() == 'M') {
            gameworld.getBoard()[gameworld.getX()][gameworld.getY()].setContent(' ');
            gameworld.getBoard()[gameworld.getX()][gameworld.getY() + 1].setContent('H');
            mov = 1; // Indicate a successful move to the market
            gameworld.setY(gameworld.getY() + 1); // Update the player's Y-coordinate
        }
        // Check if the target position is an empty space
        else if (gameworld.getBoard()[gameworld.getX()][gameworld.getY() + 1].getType() == ' ') {
            // Move to the empty space and update the game world's state
            gameworld.getBoard()[gameworld.getX()][gameworld.getY()].setContent(' ');
            gameworld.getBoard()[gameworld.getX()][gameworld.getY() + 1].setContent('H');
            gameworld.setY(gameworld.getY() + 1); 
            int i = random.nextInt(10);
            if (i < 3) {
                mov = 2;
            } else {
                mov = 0; 
            }
        }
			}
		}
		return mov;
	}
	// This function prompts the user to set the number of heroes in the team
	public void chooseHero() {
    int heroNum; 
    while (true) {
        System.out.println("enter no. of heros:(1-3)"); 
        String input = sc.nextLine(); 

        // Check for a quit command
        if (input.equals("q")) {
            System.out.println("Goodbye!");
            System.exit(0); 
        }

        try {
            heroNum = Integer.parseInt(input); 
        } catch (Exception e) { 
            System.out.println("Invalid input. Enter an integer.");
            continue; 
        }
        if (heroNum < 1 || heroNum > 3) { 
            System.out.println("Invalid input. Enter between 1 and 3."); 
            continue; // Skip to the next iteration of the loop for a retry
        }

        break;
    }
    // Inform the user of the number of heroes chosen
    System.out.println("There are " + heroNum + " hero(s) in your team");

    chooseHero(heroNum);
}
	// This function is in charge of choosing heroes to form the team
	public void chooseHero(int heroNum){
		System.out.println("Please choose " + heroNum + " heroes to make the team");
		// print the hero list for player to choose
		datahero.printChampion();
		int temp = 0;
		for(int i = 0; i < heroNum; i++){
			while (true) {
				System.out.println("enter hero no.: (1-18)");
				String input = sc.nextLine();
				if (input.equals("q")) {
					System.out.println("Goodbye!");
					System.exit(0);
				}
				try {
					temp = Integer.parseInt(input);
				} catch (Exception e) {
					System.out.println("Invalid input. Enter an integer.");
					continue;
				}
				heros.add(datahero.getHero().get(temp));
				break;
			}
		}

		showCurrentInfo(heros);
	}

	// This function is in charge of showing hero information
	public void showCurrentInfo(ArrayList<Hero> hero){
		int num = 0;
		DataHeroes. linePattern.printPattern();
		System.out.println("No |        Name       | Strength | Agility | Dexterity | Money | experience | Type | Status");
		DataHeroes. linePattern.printPattern();
		for (Hero h:hero){
			System.out.printf("%-4s %-22s",(++num), h.getName());
			System.out.printf("%-10s",h.getStrength());
			System.out.printf("%-10s",h.getAgility());
			System.out.printf("%-11s",h.getDexterity());
			System.out.printf("%-12s",h.getMoney());
			System.out.printf("%-10s",h.getExp());
			System.out.printf("%-10s",h.getType());
			System.out.printf("%-10s",h.getIsFainted());
			System.out.println();

			if (h.getArmor() != null) {
				System.out.println("Armour: ");
				h.getArmor().showInfo();
			}else{
				System.out.println("No Armor!");
			}

			if (h.getWeapon() != null) {
				System.out.println("Weapon: ");
				h.getWeapon().showInfo();
			}else{
				System.out.println("No Weapon!");
			}
		}
	}
}

