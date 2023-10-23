package baseball.repository;

import static baseball.message.Message.BEGIN_RANGE;
import static baseball.message.Message.CAPACITY_STR;
import static baseball.message.Message.COMPUTER;
import static baseball.message.Message.END_RANGE;

import baseball.utils.RandomNumberUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerRepository {
    private final Map<String, List<Integer>> store = new HashMap<>();

    public ComputerRepository() {
        store.put(COMPUTER, null);
    }

    private void setStore(String key, List<Integer> obj) {
        store.put(key, obj);
    }

    public List<Integer> getStore(String key) {
        return store.get(key);
    }

    public void addComputer() {
        List<Integer> computer = RandomNumberUtils.pickNumberInRange(
                GameSetRespository.getGameSet(BEGIN_RANGE),
                GameSetRespository.getGameSet(END_RANGE),
                GameSetRespository.getGameSet(CAPACITY_STR)
        );
        setStore(COMPUTER, computer);
    }
}
