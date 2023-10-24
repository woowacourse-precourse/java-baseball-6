package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeRepository {

    private static Long sequence = 0L;
    private static Map<Long, Code> storage = new HashMap<>();

    public Long save(final List<Integer> code) {
        storage.put(++sequence, new Code(sequence, code));
        return sequence;
    }

    public Code findById(final Long id) {
        return storage.get(id);
    }

    public void delete(final Long id) {
        storage.remove(id);
    }

    public Long getSequence() {
        return sequence;
    }
}
