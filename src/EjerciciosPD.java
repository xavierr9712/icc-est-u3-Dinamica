import java.util.HashMap;
import java.util.Map;

public class EjerciciosPD {

    private Map<Integer, Integer> cache = new HashMap<>();

    public int getFibonaci (int n){
         if (n <= 1) {
            return n;
        }
        return getFibonaci(n - 1) + getFibonaci(n - 2);
    }

    public long getFibonaciPD (int n, Map<Integer, Long> cache){
        if (n <= 1) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        long resultado = getFibonaciPD(n - 1, cache) + getFibonaciPD(n - 2, cache);
        cache.put(n, resultado);
        return resultado;
    }
    
}
