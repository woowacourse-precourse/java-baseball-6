package baseball.repository;

import java.util.HashMap;

public class GameSetRespository {

    private static final HashMap<String, Integer> gameSetStore = new HashMap<>();

    static {
        // 게임 설정 초기화
        System.out.println("게임 설정 초기화 시작");
        gameSetStore.put("capacity", 3);
        gameSetStore.put("startRange", 1);
        gameSetStore.put("endRange", 9);
        System.out.println("게임 설정 초기화 완료");
    }

    public void save(String key, Integer num) {
        gameSetStore.put(key, num);
    }

    public Integer get(String key) {
        return gameSetStore.get(key);
    }

}
