package intermedioClase9;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ejercicio1 {

    @Test
    public void mapa(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(123456789,"Juancito");
        map.put(48933968,"Emiliano");
        map.put(987654321,"Pedro");
        map.put(1122334455,"Jack");

        System.out.println(map.get(123456789));

    }
}
