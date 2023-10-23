package baseball.repository;

import java.util.HashMap;
import java.util.Map;

public class MemoryRepository {

    private final Map<String, Object> store = new HashMap<>();

    public void save(String key, Object obj) {
        store.put(key, obj);
    }

    public Object get(String key) {
        return store.get(key);
    }
}
