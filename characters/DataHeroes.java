// this contains the data of heroes, reading and printing
//done
package characters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class DataHeroes implements FileDataInput<Hero> {
	
	public static final Patterns linePattern = new Patterns("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

	public static class Patterns {
        public String pattern;

        public Patterns(String pattern) {
            this.pattern = pattern;
        }

        public void printPattern() {
            System.out.println(pattern);
        }
    }
	private ArrayList<Hero> hero;
	public DataHeroes()
	
	{
		this.hero = new ArrayList<>();
		hero.addAll(readBeingFromFile("Paladins.txt"));
        hero.addAll(readBeingFromFile("Sorcerers.txt"));
        hero.addAll(readBeingFromFile("Warriors.txt"));
	}
	@Override
	public ArrayList<Hero> readBeingFromFile(String filePath) {
		ArrayList<Hero> heroes = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			boolean isFirstLine = true; // flag to skip the first line (header)
	
			while ((line = reader.readLine()) != null) {
				if (isFirstLine) {
					isFirstLine = false; // skip the first line
					continue;
				}
				if (line.trim().isEmpty()) { // Skip any empty lines
					continue;
				}
				String[] parts = line.trim().split("\\s+"); // Trim and split the line based on whitespace
	
				// Check if parts array has the expected number of elements
				if (parts.length < 7) { // Adjust the expected number of elements if necessary
					// If you don't want to print this error, simply continue to the next iteration
					continue;
				}
	
				try {
					// Assuming the file does not contain 'experience' and 'type' fields
					Hero hero = new Hero(parts[0], // Name
										1, // Level, assuming default level is 1
										0, // Experience, assuming default experience is 0
										Integer.parseInt(parts[1]), // Strength
										Integer.parseInt(parts[2]), // Agility
										Integer.parseInt(parts[3]), // Dexterity
										Integer.parseInt(parts[4]), // Money
										Integer.parseInt(parts[5]), // Starting (perhaps this should be something else?)
										0, parts[6]); // Type (assuming the last part is the type)
					heroes.add(hero);
				} catch (NumberFormatException nfe) {
					// If you don't want to print this error, simply continue to the next iteration
					continue;
				}
			}
		} catch (IOException e) {
			System.err.println("An error occurred while trying to read the file: " + filePath);
			e.printStackTrace();
		}
		return heroes;
	}
	public ArrayList<Hero> getHero(){
		return hero;
	}
	public void printChampion(){
		linePattern.printPattern();
		System.out.println("No |\t Name\t| Strength | Agility | Dexterity | Money | experience | Type");
		linePattern.printPattern();
		int i = 1;
        for (Hero hero : hero) {
            System.out.printf("%-3d %-18s | %-8d | %-7d | %-9d | %-5d | %-10d | %-10s%n",
                              i++, 
                              hero.getName(), 
                              hero.getStrength(), 
                              hero.getAgility(), 
                              hero.getDexterity(), 
                              hero.getMoney(), 
                              hero.getExp(), 
                              hero.getType());
		}
		linePattern.printPattern();
	}
}
