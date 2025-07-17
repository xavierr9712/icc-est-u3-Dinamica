// import java.util.ArrayList;
// import java.util.List;

// public class MaseSolverRecursivo implements MazeSolver{

//     @Override
//     public List<Cell> getPath(boolean[] grid, Cell start, Cell end) {
//         if (grid == null || grid.length == 0) {
//             return new ArrayList<>();
//         }
//         List<Cell> path = new ArrayList<>();
//         if (findPath(grid, start, end, path)){
//             return path;
//         }
//         return new ArrayList<>();
//     } 
          
    
// }
import java.util.ArrayList;
import java.util.List;
import java.util.Collections; // Import Collections for reverse

public class MaseSolverRecursivo implements MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        if (grid == null || grid.length == 0 || start == null || end == null) {
            return new ArrayList<>();
        }

        List<Cell> path = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        if (findPath(grid, start, end, path, visited)) {
            // The path is built from end to start, so reverse it
            Collections.reverse(path);
            return path;
        }

        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (current.row < 0 || current.row >= rows ||
            current.col < 0 || current.col >= cols ||
            !grid[current.row][current.col] || visited[current.row][current.col]) {
            return false;
        }

        visited[current.row][current.col] = true;

        if (current.row == end.row && current.col == end.col) {
            path.add(new Cell(current.row, current.col)); // Add the end cell
            return true;
        }

        int[] dr = {-1, 1, 0, 0}; 
        int[] dc = {0, 0, -1, 1}; 

        for (int i = 0; i < 4; i++) {
            Cell nextCell = new Cell(current.row + dr[i], current.col + dc[i]);
            if (findPath(grid, nextCell, end, path, visited)) {
                path.add(new Cell(current.row, current.col)); 
                return true;
            }
        }

        return false; 
    }
}