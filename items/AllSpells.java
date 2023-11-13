package items;
// this class deals with common attributes of all types of spells
import characters.DataHeroes;

public class AllSpells extends Items {
    private String type;
    private int damage;
    private int manaCost;

    public AllSpells(String name, int cost, int requiredLevel, int damage, int manaCost, String type) {
        super(name, cost, requiredLevel);
        this.damage = damage;
        this.manaCost = manaCost;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public void showInfo() {
        printItemInfo("Name", "Cost", "Level", "Damage", "Mana_Cost", "Type");
    }

    private void printItemInfo(String... attributes) {
        DataHeroes.linePattern.printPattern();
        for (String attribute : attributes) {
            showInfoColumn(getAttribute(attribute));
        }
        System.out.println();
        DataHeroes.linePattern.printPattern();
    }

    private void showInfoColumn(String value) {
        System.out.printf("%-20s", value);
    }

    private String getAttribute(String attributeName) {
        switch (attributeName) {
            case "Name":
                return getName();
            case "Cost":
                return String.valueOf(getCost());
            case "Level":
                return String.valueOf(getReqLevel());
            case "Damage":
                return String.valueOf(getDamage());
            case "Mana_Cost":
                return String.valueOf(getManaCost());
            case "Type":
                return getType();
            default:
                return ""; 
        }
    }
}
