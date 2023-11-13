// list of all the monsters/beasts
//done
package characters;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class DataMonsters implements FileDataInput<Monster> {
	private ArrayList<Monster> beast;
	public DataMonsters()
	{
		this.beast = new ArrayList<>();
		beast.addAll(readBeingFromFile("Dragons.txt"));
        beast.addAll(readBeingFromFile("Exoskeletons.txt"));
        beast.addAll(readBeingFromFile("Spirits.txt"));
	}
    @Override
    public ArrayList<Monster> readBeingFromFile(String filePath) {
        ArrayList<Monster> monsters = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.trim().split("\\s+");

                if (parts.length < 5) { // Assuming the file format is Name, Level, Damage, Defense, DodgeChance
                    continue;
                }

                try {
                    Monster monster = new Monster(
                            parts[0], // Name
                            Integer.parseInt(parts[1]), // Level
                            Integer.parseInt(parts[2]), // Damage
                            Integer.parseInt(parts[3]), // Defense
                            Double.parseDouble(parts[4]) // DodgeChance
                    );
                    monsters.add(monster);
                } catch (NumberFormatException nfe) {
                    continue;
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while trying to read the file: " + filePath);
            e.printStackTrace();
        }
        return monsters;
    }
	public ArrayList<Monster> getBeast(){// get the list of monsters
		return beast; 
	}
	// printing the list of monsters
public void printEnemy(){
	DataHeroes. linePattern.printPattern();
	System.out.println("No |      Name     | Level  |  Damage  |  Defense | Dodge_Chance");
	DataHeroes. linePattern.printPattern();
	for (int i = 0; i < beast.size(); i++) {
		System.out.printf("%-3s %-20s", (i + 1), beast.get(i).getName());
		System.out.printf("%-10s", beast.get(i).getLevel());
		System.out.printf("%-10s", beast.get(i).getDamage());
		System.out.printf("%-10s", beast.get(i).getDefense());
		System.out.printf("%-12s", beast.get(i).getDodge()); 
		System.out.println();
	}
		DataHeroes. linePattern.printPattern();
	}
}
