package board;
// building block of the board, it has a type and content in it.
public class Cell{
    // ANSI color code constants
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private String color; // This will store the ANSI color code
    private char content; 
    private char type;
    public Cell(char content, char type){//constructor
        this.type = type;
        this.content = content;
        this.color = ANSI_RESET;
    }


    //getters and setters
    public char getContent(){
        return content;
    }
    public char getType(){
        return type;
    }
    public void setContent(char content){
        this.content = content;
    }
    public void setType(char type) {
        this.type = type;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }   

    public void printCell() {
        System.out.print(color + content + ANSI_RESET);
    }
}