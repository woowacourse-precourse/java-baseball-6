package baseball.repository;

import static baseball.message.Message.BALL;
import static baseball.message.Message.PLAYER;
import static baseball.message.Message.STRIKE;
import static baseball.message.Message.SUCCESS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerRepository {

    private final Map<String, Object> store = new HashMap<>();

    public PlayerRepository() {
        store.put(PLAYER, null);
        store.put(BALL, 0);
        store.put(STRIKE, 0);
        store.put(SUCCESS, false);
    }

    public void playerReset() {
        // 플레이어 초기화
        setStore(PLAYER, null);
        setStore(BALL, 0);
        setStore(STRIKE, 0);
        setStore(SUCCESS, false);
    }

    private void setStore(String key, Object obj) {
        store.put(key, obj);
    }

    public Object getStore(String key) {
        return store.get(key);
    }

    public void addPlayer(List<Integer> obj) {
        setStore(PLAYER, obj);
    }

    public void addBall() {
        setStore(BALL, (Integer) getStore(BALL) + 1);
    }

    public void addStrike() {
        setStore(STRIKE, (Integer) getStore(STRIKE) + 1);
    }

    public void success() {
        setStore(SUCCESS, true);
    }

    public void fail() {
        setStore(SUCCESS, false);
    }

    public boolean isSuccess() {
        return (boolean) getStore(SUCCESS);
    }
}
