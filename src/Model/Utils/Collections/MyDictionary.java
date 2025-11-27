package Model.Utils.Collections;

import java.util.*;

public class MyDictionary<K,V> implements MyIDictionary<K,V> {
    private Map<K,V> map;

    public MyDictionary(){this.map = new HashMap<>();}

    @Override
    public void put(K key, V value) { map.put(key,value); }


    @Override
    public V lookUp(K key) {return map.get(key);}

    @Override
    public boolean isDefined(K key) {return map.containsKey(key);}

    @Override
    public void update(K key, V value) {map.put(key,value);}

    @Override
    public void remove(K key) {map.remove(key);}

    @Override
    public String toString() {return map.toString();}

    @Override
    public List<K> getKeys(){return new ArrayList<>(map.keySet());}

    @Override
    public void clear(){
        map.clear();
    }

    @Override
    public Map<K,V> getContent()
    {
        return this.map;
    }
}
