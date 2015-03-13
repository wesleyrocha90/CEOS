package br.com.ceos.util;

import java.util.HashMap;
import java.util.Map;

public class Maps {
  
  public static <K, V> Map<K, V> asMap(Object... keyvals){
    Map<K, V> map = new HashMap<>(keyvals.length);
    if (keyvals.length > 0) {
      if (keyvals.length % 2 == 0) {
        for (int i = 0; i < keyvals.length; i += 2) {
          map.put((K)keyvals[i], (V)keyvals[i+1]);
        }
      }
    }
    return map;
  }
}
