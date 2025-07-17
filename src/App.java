import java.math.BigInteger;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        //runEjerciciosPD();
        runMaze();
    }

    private static void runMaze(){
        boolean [][] predefinedMaze = {
            {true, true, true, true},
            {false, true, true, true},
            {true, true, false, false},
            {true, true, true, true},
            
        };

        Maze maze = new Maze(predefinedMaze);
        System.out.println("Laberinto cargado");
        maze.printMaze();

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);

        List<MazeSolver> solvers = Arrays.asList(
            new MaseSolverRecursivo(),
            new MazeSolverRecursivoCompleto()
            );
        MazeSolver solver = solvers.get(0);
        List<Cell> path;
        path = solver.getPath(maze.getGrid(), start, end);
        System.out.println(path);

    }
    // public static void runEjerciciosPD() {
    //     EjerciciosPD ejerciciosPD = new EjerciciosPD();

    //     System.out.println("Calculando con Fibonacci Recursivo...");
        
        
    //     long start = System.nanoTime();
    //     long resultadoRecursivo = ejerciciosPD.getFibonaci(5);
    //     long end = System.nanoTime();
    //     long duration = end - start;

    //     System.out.println("Resultado para n=" + resultadoRecursivo + " es " + duration);
    //     System.out.println("Tiempo de ejecución: " + duration + " nanosegundos (" + duration / 1_000_000 + " milisegundos).\n");

    //     System.out.println("--------------------------------------------------\n");

    //     System.out.println("Fibonacci recursivo caching");
       
    //     long startPD = System.nanoTime();
    //     long resultadoPD = ejerciciosPD.getFibonaciPD(100, new HashMap<Integer, Long>());
    //     long endPD = System.nanoTime();
    //     long durationPD = (end - start);

    //     System.out.println("Resultado para n=" + resultadoPD + " es " + durationPD);
    //     System.out.println("Tiempo de ejecución: " + durationPD + " nanosegundos (" + durationPD / 1_000_000 + " milisegundos).");
    // }
    // public static void runEjerciciosPD(){
    //     EjerciciosPD ejerciciosPD = new EjerciciosPD();
    //     System.out.println("Fibonacci Recursivo");
    //     innt start = 0;
    //     int resultado = ejerciciosPD.getFibonaci(100);
    //     int end = 0;
    //     int duration = end - start;
    //     System.out.println("Resultado =" + resultado + " en tiempo = " + duration);

    //     System.out.println("Fibonacci recursivo caching");
   
    //     EjerciciosPD ejerciciosPD = new EjerciciosPD();
    //     System.out.println("Fibonacci Recursivo");
    //     innt start = 0;
    //     int resultado = ejerciciosPD.getFibonaciPD(100);
    //     int end = 0;
    //     int duration = end - start;
    //     System.out.println("Resultado =" + resultado + " en tiempo = " + duration);
    // }


}
