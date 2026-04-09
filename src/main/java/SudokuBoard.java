/**
 * SudokuBoard.java
 *
 * A demonstration of 2-dimensional arrays in Java.
 *
 * This class shows how to:
 *   1. DECLARE and INITIALIZE a 2D array (the board)
 *   2. READ values from a 2D array (display)
 *   3. WRITE values into a 2D array (fill the board)
 *   4. TRAVERSE a 2D array to verify rules (validation)
 *
 * A standard Sudoku board is a 9x9 grid.
 * In Java, this is: int[9][9] -- an array of 9 rows, each with 9 columns.
 *
 * Key vocabulary:
 *   board[row][col]  -- row is the first index, column is the second
 *   board.length     -- number of rows (9)
 *   board[0].length  -- number of columns in row 0 (9)
 */
public class SudokuBoard {

    /** The fixed size of a standard Sudoku board (9x9). */
    private static final int SIZE = 9;

    /** The size of each 3x3 sub-box. */
    private static final int BOX_SIZE = 3;


    /**
     * The 2D array that stores the Sudoku board.
     * board[row][col] holds the digit (1-9) or 0 for an empty cell.
     *
     * Memory layout (conceptual):
     *
     *   board[0] --> [ _, _, _, _, _, _, _, _, _ ]  // row 0
     *   board[1] --> [ _, _, _, _, _, _, _, _, _ ]  // row 1
     *   ...
     *   board[8] --> [ _, _, _, _, _, _, _, _, _ ]  // row 8
     *
     * Access pattern:  board[row][col]
     *                  board[0][0] = top-left cell
     *                  board[8][8] = bottom-right cell
     */
    private int[][] board;

    /**
     * Creates a new, empty Sudoku board.
     *
     * "new int[SIZE][SIZE]" allocates a 9x9 grid.
     * Java automatically fills every cell with 0, representing an empty cell.
     */
    public SudokuBoard() {
        board = new int[SIZE][SIZE]; // All cells start at 0
    }

    public SudokuBoard(int[][] board){
        /*
         * This constructor does not check if the board being
         * passed in has the right size.
         */
        this.board = new int[SIZE][SIZE];
        for(int row=0; row < SIZE; row++){
            for(int col=0; col < SIZE; col++){
                this.board[row][col] = board[row][col];
            }
        }
    }


    /**
     * Returns the Sudoku board.
     *
     * 2D ARRAY SKILL: We use a nested for-loop to visit every cell.
     *   - The outer loop iterates over ROWS    (board.length     = 9)
     *   - The inner loop iterates over COLUMNS (board[row].length = 9)
     */
    public String display() {
        String boardRep = "+-------+-------+-------+\n";
        // TODO: replace this line with your code.

        return boardRep;
    }


    /**
     * Places a digit into a specific cell on the board.
     *
     * 2D ARRAY SKILL: We WRITE to a specific [row][col] position.
     *
     * @param row   The row index (0-8)
     * @param col   The column index (0-8)
     * @param digit The digit to place (1-9); use 0 to clear a cell
     * @return true if the placement was accepted, false if out of range
     */
    public boolean setCell(int row, int col, int digit) {
        if (row < 0 || row > SIZE-1 || col < 0 || col > SIZE-1 ){
            return false;
        }

        if (digit < 1 || digit > 9){
            return false;
        }
        board[row][col] = digit;
        return true;
    }

    /**
     * Returns the digit stored at a specific cell.
     *
     * 2D ARRAY SKILL: We READ from a specific [row][col] position.
     *
     * @param row The row index (0-8)
     * @param col The column index (0-8)
     * @return The digit at that cell (0 means empty)
     */
    public int getCell(int row, int col) {
        return board[row][col];     // READ from the 2D array
    }

    /**
     * Loads a predefined Sudoku puzzle into the board using a 2D array.
     *
     * @param puzzle a 2D array containing a predefined Sudoku puzzle
     * @return true if the puzzle loaded; false otherwise.
     */
    public boolean loadSamplePuzzle(int[][] puzzle) {
        if (puzzle.length != board.length){
            return false;
        }
        for (int row = 0; row < SIZE; row++) {
            if (puzzle[row].length != board[row].length){
                return false;
            }
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = puzzle[row][col];  // WRITE each cell
            }
        }
        return true;
    }

    /**
     * Verifies whether the current board is a valid, complete Sudoku solution.
     *
     * A valid solution requires that every ROW, every COLUMN, and every
     * 3x3 BOX contains each digit 1-9 exactly once.
     *
     * @return true if the board is a valid solution, false otherwise
     */
    public boolean isValidSolution() {
        return checkAllRows() && checkAllColumns() && checkAllBoxes();
    }

    /**
     * Checks that every row contains digits 1-9 with no repeats.
     *
     * 2D ARRAY SKILL: Outer loop picks the row; inner loop reads all cells in that row.
     */
    private boolean checkAllRows() {
        // TODO: replace this line with your code
        return true;
    }

    /**
     * Checks that every column contains digits 1-9 with no repeats.
     *
     * 2D ARRAY SKILL: We must COLLECT an entire column manually, because
     * Java stores 2D arrays as arrays of rows -- there is no board[col]
     * shortcut for columns. We loop over every row and pick board[row][col].
     */
    private boolean checkAllColumns() {
        // TODO: replace this line with your code
        return true;
    }

    /**
     * Checks that all nine 3x3 sub-boxes contain digits 1-9 with no repeats.
     *
     * 2D ARRAY SKILL: We use the top-left corner of each box as an anchor.
     * The nine boxes start at rows {0, 3, 6} and columns {0, 3, 6}.
     * Within each box we offset by (dr, dc) from 0 to 2.
     *
     *   Box anchor calculation:
     *     startRow = boxRow * BOX_SIZE    (0*3=0, 1*3=3, 2*3=6)
     *     startCol = boxCol * BOX_SIZE    (0*3=0, 1*3=3, 2*3=6)
     *
     *   Cell access inside the box:
     *     board[startRow + dr][startCol + dc]    dr, dc in {0, 1, 2}
     */
    private boolean checkAllBoxes() {
        // TODO: replace this line with your code
        return true;
    }

    /**
     * Helper: Returns true if the given 1D array contains each digit 1-9 exactly once.
     *
     * Uses a boolean[] of size 10 (indices 1-9) as a "seen" tracker.
     * This is a common pattern for Sudoku validation.
     *
     * @param startingRow index of starting row
     * @param endingRow index of ending row but not including ending row
     * @param startingCol index of starting column
     * @param endingCol index of ending column but not including ending column
     *
     * @return true if every digit 1-9 appears exactly once
     */
    private boolean hasAllDigits(int startingRow, int endingRow,
                                 int startingCol, int endingCol) {
        // TODO: repalce this line with your code.
        return true;

    }

    /**
     * Demonstrates all three operations: create, display, and verify.
     */
    public static void main(String[] args) {

        SudokuBoard sudoku = new SudokuBoard();

        // --- Step 1: LOAD and DISPLAY the puzzle ---
        System.out.println("=== SAMPLE PUZZLE ===");
        int[][] validBoard = {
                { 5, 3, 4,  6, 7, 8,  9, 1, 2 },
                { 6, 7, 2,  1, 9, 5,  3, 4, 8 },
                { 1, 9, 8,  3, 4, 2,  5, 6, 7 },

                { 8, 5, 9,  7, 6, 1,  4, 2, 3 },
                { 4, 2, 6,  8, 5, 3,  7, 9, 1 },
                { 7, 1, 3,  9, 2, 4,  8, 5, 6 },

                { 9, 6, 1,  5, 3, 7,  2, 8, 4 },
                { 2, 8, 7,  4, 1, 9,  6, 3, 5 },
                { 3, 4, 5,  2, 8, 6,  1, 7, 9 }
        };
        sudoku.loadSamplePuzzle(validBoard);
        System.out.println(sudoku.display());

        // --- Step 2: MANUALLY SET a specific cell (writing to the 2D array) ---
        System.out.println("\nSetting cell [0][2] to 4...");
        sudoku.setCell(0, 2, 4);
        System.out.println("Value at [0][2]: " + sudoku.getCell(0, 2));

        System.out.println("\n=== VALIDATING COMPLETE SOLUTION ===");
        boolean isValid = sudoku.isValidSolution();
        System.out.println("Is valid solution: " + isValid);

        // --- Step 5: Introduce an ERROR and verify again ---
        System.out.println("\n=== INTRODUCING AN ERROR (setting [0][0] to 9) ===");
        sudoku.setCell(0, 0, 9);   // Row 0 already has a 9 -- creates a duplicate
        isValid = sudoku.isValidSolution();
        System.out.println("Is valid solution: " + isValid);
    }
}
