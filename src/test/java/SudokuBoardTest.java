import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {
    private int[][] validBoard;
    private int[][] rowInvalidBoard;
    private int[][] colInvalidBoard;
    private int[][] boxInvalidBoard;

    @BeforeEach
    void setUp() {
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
        this.validBoard = validBoard;

        int[][] rowInvalidBoard = {
                { 5, 3, 9,  6, 7, 8,  9, 1, 2 },
                { 6, 7, 2,  1, 9, 5,  3, 4, 8 },
                { 1, 9, 8,  3, 4, 2,  5, 6, 7 },

                { 8, 5, 9,  7, 6, 1,  4, 2, 3 },
                { 4, 2, 6,  8, 5, 3,  7, 9, 1 },
                { 7, 1, 3,  9, 2, 4,  8, 5, 6 },

                { 9, 6, 1,  5, 3, 7,  2, 8, 4 },
                { 2, 8, 7,  4, 1, 9,  6, 3, 5 },
                { 3, 4, 5,  2, 8, 6,  1, 7, 9 }
        };
        this. rowInvalidBoard = rowInvalidBoard;

        int[][] colInvalidBoard = {
                { 5, 3, 4,  6, 7, 8,  9, 1, 2 },
                { 6, 7, 2,  1, 9, 5,  3, 4, 8 },
                { 1, 9, 8,  3, 4, 2,  5, 6, 7 },

                { 8, 5, 9,  7, 6, 1,  4, 2, 3 },
                { 4, 2, 6,  8, 5, 3,  7, 9, 1 },
                { 7, 1, 4,  9, 2, 3,  8, 5, 6 },

                { 9, 6, 1,  5, 3, 7,  2, 8, 4 },
                { 2, 8, 7,  4, 1, 9,  6, 3, 5 },
                { 3, 4, 5,  2, 8, 6,  1, 7, 9 }
        };
        this.colInvalidBoard = colInvalidBoard;

        int[][] boxInvalidBoard = {
                { 1, 2, 3,  4, 5, 6,  7, 8, 9 },
                { 2, 3, 4,  5, 6, 7,  8, 9, 1 },
                { 3, 4, 5,  6, 7, 8,  9, 1, 2 },

                { 4, 5, 6,  7, 8, 9,  1, 2, 3 },
                { 5, 6, 7,  8, 9, 1,  2, 3, 4 },
                { 6, 7, 8,  9, 1, 2,  3, 4, 5 },

                { 7, 8, 9,  1, 2, 3,  4, 5, 6 },
                { 8, 9, 1,  2, 3, 4,  5, 6, 7 },
                { 9, 1, 2,  3, 4, 5,  6, 7, 8 }
        };
        this.boxInvalidBoard = boxInvalidBoard;
    }

    @Test
    void isValidSolution() {
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.loadSamplePuzzle(validBoard);
        assertTrue(sudokuBoard.isValidSolution());
        sudokuBoard.loadSamplePuzzle(rowInvalidBoard);
        assertTrue(!sudokuBoard.isValidSolution());
        sudokuBoard.loadSamplePuzzle(colInvalidBoard);
        assertTrue(!sudokuBoard.isValidSolution());
        sudokuBoard.loadSamplePuzzle(boxInvalidBoard);
        assertTrue(!sudokuBoard.isValidSolution());
    }
}