package characters;
//done
// This is an abstract class for beings present in the game. 
// It will be used by both heroes and monsters.
public abstract class Being {
protected String name;      
protected int level;         
protected int hp;           
protected int defense;       
protected boolean isFainted; 
    // Initializes the name, level, hp, defense, and isFainted properties.
    public Being(String name, int level, int defense) {
        this.name = name;
        this.level = level;
        this.hp = level * 100;
        this.defense = defense;
        this.isFainted = false;
    }
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public int getHp() {
        return hp;
    }
    public int getDefense() {
        return defense;
    }
    public boolean getIsFainted() {
        return isFainted;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public void setIsFainted() {
        isFainted = true;
    }
}
