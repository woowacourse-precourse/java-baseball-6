package baseball;

import java.util.List;

public class Game {
    private final String START_GAME_COMMENT = "숫자 야구 게임을 시작합니다.";
    private final String PLAY_GAME_COMMENT = "숫자를 입력해주세요 : ";

    private final Player player;
    private final List<Integer> answer;

    public Game(Player player, List<Integer> answer) {
        this.player = player;
        this.answer = answer;
    }

    public void start() {
        System.out.println(START_GAME_COMMENT);
    }
}
