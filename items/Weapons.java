package items;
// this class is responsible for attributes of weapons
import characters.DataHeroes;
public class Weapons extends Items {
    private int damage;
    private int reqHand;
    // constructor
    public Weapons(String name, int cost, int level, int damage, int requiredHand) {
        super(name, cost, level);
        this.damage = damage;
        this.reqHand = requiredHand;
    }

    public int getDamage() {
        return damage;
    }

    public int getReqHand() {
        return reqHand;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setReqHand(int reqHand) {
        this.reqHand = reqHand;
    }

    public void showInfo() {
        printItemInfo("Name", "Price", "Level", "Damage", "Required_Hands");
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
            case "Price":
                return String.valueOf(getCost());
            case "Level":
                return String.valueOf(getReqLevel());
            case "Damage":
                return String.valueOf(getDamage());
            case "Required_Hands":
                return String.valueOf(getReqHand());
            default:
                return ""; 
        }
    }
}
