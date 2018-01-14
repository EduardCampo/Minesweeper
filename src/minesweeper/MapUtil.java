package minesweeper;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MapUtil {
	//Ordena el Map con los ganadores por numero de victorias(value)
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
	    return map.entrySet()
	              .stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue, 
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              ));
	}
	//Transforma el Map a un string para imprimirlo
    public static String toString(Map map) {
    	if(map != null) {   	
	        StringBuilder sb = new StringBuilder();
	        Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
	        while (iter.hasNext()) {
	            Entry<String, Integer> entry = iter.next();
	            sb.append(entry.getKey());
	            sb.append('=');
	            sb.append(entry.getValue());
	            sb.append('\n');
	        }
	        return sb.toString();
    	}
    	return null;

    }
  
}