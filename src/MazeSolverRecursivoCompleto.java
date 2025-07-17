import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazeSolverRecursivoCompleto implements MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        // Basic validation for the input grid, start, and end cells.
        if (grid == null || grid.length == 0 || grid[0].length == 0 || start == null || end == null) {
            return new ArrayList<>();
        }

        int rows = grid.length;
        int cols = grid[0].length;

        if (start.row < 0 || start.row >= rows || start.col < 0 || start.col >= cols ||
            !grid[start.row][start.col]) {
            return new ArrayList<>();
        }
        if (end.row < 0 || end.row >= rows || end.col < 0 || end.col >= cols ||
            !grid[end.row][end.col]) {
            return new ArrayList<>();
        }

        List<Cell> path = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];

       
        if (findPathRecursive(grid, start, end, path, visited)) {
            Collections.reverse(path);
            return path;
        }

        return new ArrayList<>();
    }

   
    private boolean findPathRecursive(boolean[][] grid, Cell current, Cell end, List<Cell> path, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (current.row < 0 || current.row >= rows ||
            current.col < 0 || current.col >= cols) {
            return false;
        }

        if (!grid[current.row][current.col]) {
            return false;
        }

        if (visited[current.row][current.col]) {
            return false;
        }

        visited[current.row][current.col] = true;

        if (current.row == end.row && current.col == end.col) {
            path.add(new Cell(current.row, current.col)); 
            return true;
        }

        int[] dr = {-1, 1, 0, 0}; // Delta for rows
        int[] dc = {0, 0, -1, 1}; // Delta for columns

        for (int i = 0; i < 4; i++) {
            Cell nextCell = new Cell(current.row + dr[i], current.col + dc[i]);

            if (findPathRecursive(grid, nextCell, end, path, visited)) {
               
                path.add(new Cell(current.row, current.col));
                return true; 
            }
        }

        
        return false; 
    }
}