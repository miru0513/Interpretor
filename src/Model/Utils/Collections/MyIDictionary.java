package Model.Utils.Collections;

import java.util.List;
import java.util.Map;

public interface MyIDictionary<K,V>{
    void put(K key,V value);
    V lookUp(K key);
    boolean isDefined(K key);
    void update(K key,V value);
    void remove(K key);
    public List<K> getKeys();
    void clear();
    public Map<K,V> getContent();
}
