package board;
// abstract class for the game's board
public abstract class Board {
private int boardSize;
private Cell[][] board;

   // constructor
public Board(int boardSize){
    this.boardSize = boardSize;
    this.boardInitialize(boardSize);
   }
   //getters setters
public int getBoardSize(){
  return boardSize;
}
public void setBoardSize(int boardSize){
    this.boardSize = boardSize;
   }
public Cell[][] getBoard(){
    return this.board;
   }

    // abstract method to set color for a cell, to be implemented by subclasses
protected abstract void setColorForCell(Cell cell, int i, int j);

   // initializing the board with each empty cell as ' '
public void boardInitialize(int boardSize){
    this.board = new Cell[boardSize][boardSize];
    for(int i = 0; i < boardSize; i++){
        for(int j = 0; j < boardSize; j++){
            board[i][j] = new Cell(' ',' ');
            setColorForCell(board[i][j], i, j);
        }
    }
}

public void printBoard() {
  for(int i = 0; i < boardSize; i++) {
    for(int j = 0; j < boardSize; j++) {
        board[i][j].printCell();
        System.out.print(" "); // Space between cells for readability
           }
        System.out.println(); // New line after each row
}
   }
}

