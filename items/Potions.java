package items;
// this class is responsible for attributes of potions
import characters.DataHeroes;
public class Potions extends Items {
    private String attaffected;
    private int attincreased;

    public Potions(String name, int cost, int requiredLevel, int attIncreased, String attAffected) {
        super(name, cost, requiredLevel);
        this.attaffected = attAffected;
        this.attincreased = attIncreased;
    }

    public String getAttaffected() {
        return attaffected;
    }

    public int getAttincreased() {
        return attincreased;
    }

    public void setAttaffected(String attribute) {
        this.attaffected = attribute;
    }

    public void setAttincreased(int value) {
        this.attincreased = value;
    }

    public void showInfo() {
        printItemInfo("Name", "Price", "Required_Level", "Att_Increased", "Att_Affected");
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
            case "Required_Level":
                return String.valueOf(getReqLevel());
            case "Att_Increased":
                return String.valueOf(getAttincreased());
            case "Att_Affected":
                return getAttaffected();
            default:
                return ""; 
        }
    }
}
