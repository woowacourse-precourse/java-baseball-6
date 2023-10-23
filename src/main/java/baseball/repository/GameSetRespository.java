package baseball.repository;

import java.util.HashMap;

public class GameSetRespository {

    // 게임 관련 환경 설정
    private static final HashMap<String, Integer> gameSetStore = new HashMap<>();

    // 게임 상태
    private static final HashMap<String, Boolean> gameStatus = new HashMap<>();

    // 해당 리포지토리는 최초 생성 될 때만 초기화
    static {
        // 게임 설정 초기화
        System.out.println("=====게임 설정 초기화 시작=====");
        gameStatusBegin();  // 게임 상태 초기화
        saveGameSet("capacity", 3);
        saveGameSet("beginRange", 1);
        saveGameSet("endRange", 9);
        System.out.println("=====게임 설정 초기화 완료=====");
    }

    public static void saveGameSet(String key, Integer num) {
        gameSetStore.put(key, num);
    }

    public static Integer getGameSet(String key) {
        if (!gameSetStore.containsKey(key)) {
            throw new IllegalArgumentException("해당 옵션은 존재하지 않는 옵션 입니다.");
        }
        return gameSetStore.get(key);
    }

    public static boolean isGameStatus() {
        return gameStatus.get("status");
    }

    public static void gameStatusBegin() {
        gameStatus.put("status", true);
    }

    public static void gameStatusEnd() {
        gameStatus.put("status", false);
    }

}
