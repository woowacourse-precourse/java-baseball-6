package baseball.repository;

import static baseball.message.Message.COMPUTER;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerRepository {
    private final Map<String, List<Integer>> store = new HashMap<>();

    public ComputerRepository() {
        System.out.println("=====컴퓨터 초기화 시작=====");
        store.put(COMPUTER, null);
        System.out.println("=====컴퓨터 초기화 완료=====");
    }

    public void saveComputer(String key, List<Integer> obj) {
        store.put(key, obj);
    }

    public List<Integer> getComputer(String key) {
        return store.get(key);
    }
}
