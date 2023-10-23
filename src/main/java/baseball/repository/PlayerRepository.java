package baseball.repository;

import static baseball.message.Message.BALL;
import static baseball.message.Message.COMPUTER;
import static baseball.message.Message.PLAYER;
import static baseball.message.Message.STRIKE;

import java.util.HashMap;
import java.util.Map;

public class PlayerRepository {

    private final Map<String, Object> store = new HashMap<>();

    public PlayerRepository() {
        System.out.println("===== 초기화 시작=====");
        store.put(COMPUTER, null);
        store.put(PLAYER, null);
        store.put(BALL, 0);
        store.put(STRIKE, 0);
        System.out.println("===== 초기화 완료=====");
    }

    public void playerReset() {
        // 플레이어 초기화
        System.out.println("=====플레이어 초기화 시작=====");
        store.put(PLAYER, null);
        store.put(BALL, 0);
        store.put(STRIKE, 0);
        System.out.println("=====플레이어 초기화 시작=====");
    }

    public void save(String key, Object obj) {
        store.put(key, obj);
    }

    public Object get(String key) {
        return store.get(key);
    }
}
