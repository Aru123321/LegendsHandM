package items;
// this class is responsible for attributes of armours
import characters.DataHeroes;

public class Armory extends Items {
    private int reduction;

    public Armory(String name, int cost, int Req_level, int damage_reduction) {
        super(name, cost, Req_level);
        this.reduction = damage_reduction;
    }

    public int getDamageReduction() {
        return reduction;
    }

    public void setDamageReduction(int reduction) {
        this.reduction = reduction;
    }

    // print the information of the armor
    public void showInfo() {
        printItemInfo("Name", "Cost", "Req_Level", "Damage_Reduction");
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
            case "Req_Level":
                return String.valueOf(getReqLevel());
            case "Damage_Reduction":
                return String.valueOf(getDamageReduction());
            default:
                return "";
        }
    }
}
