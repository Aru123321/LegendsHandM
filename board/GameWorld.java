//done
package board;
// this class deals with the whole world 
import java.util.*;
public class GameWorld extends Board{
    private static double inAccessprob = 0.2;// probability of area being inaccessible is 0.2
    private static double MKTprob = 0.3;// probability of area being market is 0.3

    private final Random random = new Random();
    private int x;
    private int y;

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public GameWorld(int boardSize){
        super(boardSize);
    }
    @Override
    protected void setColorForCell(Cell cell, int i, int j) {
        if (cell.getType() == 'X') { // Inaccessible area
            cell.setColor(Cell.ANSI_RED);
        } else if (cell.getType() == 'M') { // Market area
            cell.setColor(Cell.ANSI_GREEN);
        } else if (cell.getContent() == 'H') { // Hero's starting location
            cell.setColor(Cell.ANSI_BLUE);
        } else {
            cell.setColor(Cell.ANSI_RESET); // Default color for empty cells
        }
    }
    public void worldInitialize(){
        super.boardInitialize(getBoardSize());
        setMarket();
        setInaccess();
        while(true){
            int i = random.nextInt(getBoardSize());
            int j = random.nextInt(getBoardSize());
            if (getBoard()[i][j].getContent() == ' '){
                getBoard()[i][j].setContent('H');
                System.out.println("Your team is at: " + "(" + i + "," + j + ")" );
                setX(i);
                setY(j);
                break;
            }
        }
    }
    public void setInaccess() {
        int n = (int) (getBoardSize() * getBoardSize() * inAccessprob); // number of inaccessible areas
        int counter = 0;
    
        while (counter < n) {
            int i = random.nextInt(getBoardSize() * getBoardSize());
            int row = i / getBoardSize();
            int col = i % getBoardSize();
    
            if (getBoard()[row][col].getType() != 'X') {
                getBoard()[row][col].setType('X');
                getBoard()[row][col].setContent('X');
                getBoard()[row][col].setColor(Cell.ANSI_RED);
                counter++;
            }
        }
    }
    
    public void setMarket() {
        int m = (int) (getBoardSize() * getBoardSize() * MKTprob); // number of markets
        int counter = 0;
    
        while (counter < m) {
            int i = random.nextInt(getBoardSize() * getBoardSize());
            int row = i / getBoardSize();
            int col = i % getBoardSize();
    
            if (getBoard()[row][col].getType() != 'M') {
                getBoard()[row][col].setContent('M');
                getBoard()[row][col].setType('M');
                getBoard()[row][col].setColor(Cell.ANSI_YELLOW);
    
                counter++;
            }
        }
    }
    
//    print the world
        public void printWorld(){
        for (int i = 0; i < this.getBoardSize(); ++i) {
            System.out.print("+---");
        }
        System.out.println("+");

        for (int i = 0; i < this.getBoardSize(); ++i) {
            System.out.print("|");
            for (int j = 0; j < this.getBoardSize(); ++j){
                System.out.print(" " +this.getBoard()[i][j].getColor() + this.getBoard()[i][j].getContent() + Cell.ANSI_RESET + " |"); //how to add color?
            }
            System.out.println();
            for (int k = 0; k < this.getBoardSize(); ++k) {
                System.out.print("+---");
            }
            System.out.println("+");
        }
    }
}
