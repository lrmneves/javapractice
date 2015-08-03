package datastructures;

import java.util.LinkedHashMap;

public class LRUCache {
    int capacity;
    LinkedHashMap<Integer,Integer> LRUMap;
    
    public LRUCache(int capacity) {
        LRUMap = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(LRUMap.containsKey(key)){
        	int value = LRUMap.get(key);
        	LRUMap.remove(key);
         	LRUMap.put(key, value);
         	return value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
    	if(LRUMap.containsKey(key)){
         	LRUMap.remove(key);
         	LRUMap.put(key, value);
        }else{
        	if(capacity <= LRUMap.size()){
        		int eldestKey = LRUMap.keySet().iterator().next();
        		LRUMap.remove(eldestKey);
        	}
        	LRUMap.put(key, value);
        }
    }
}