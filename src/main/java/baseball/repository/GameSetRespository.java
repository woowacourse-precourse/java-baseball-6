package baseball.repository;

import static baseball.message.Message.BEGIN_RANGE;
import static baseball.message.Message.CAPACITY_STR;
import static baseball.message.Message.END_RANGE;
import static baseball.message.Message.GAME_STATUS_STR;

import java.util.HashMap;

public class GameSetRespository {

    // 게임 관련 환경 설정
    private static final HashMap<String, Integer> gameSetStore = new HashMap<>();

    // 게임 상태
    private static final HashMap<String, Boolean> gameStatus = new HashMap<>();

    // 해당 리포지토리는 최초 생성 될 때만 초기화
    static {
        saveGameSet(CAPACITY_STR, 3);
        saveGameSet(BEGIN_RANGE, 1);
        saveGameSet(END_RANGE, 9);
    }

    public GameSetRespository() {
        gameStatusBegin();  // 게임 상태 초기화
    }

    public static void saveGameSet(String key, Integer num) {
        gameSetStore.put(key, num);
    }

    public static Integer getGameSet(String key) {
        if (!gameSetStore.containsKey(key)) {
            throw new IllegalArgumentException("해당 옵션은 존재 하지 않는 옵션 입니다.");
        }
        return gameSetStore.get(key);
    }

    public static boolean isGameStatus() {
        return gameStatus.get(GAME_STATUS_STR);
    }

    public static void gameStatusBegin() {
        gameStatus.put(GAME_STATUS_STR, true);
    }

    public static void gameStatusEnd() {
        gameStatus.put(GAME_STATUS_STR, false);
    }

}
