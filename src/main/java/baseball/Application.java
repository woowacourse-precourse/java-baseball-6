package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;
import java.util.Set;

public class Application {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String GAME_RESTART = "1";
    private static final String GAME_FINISH = "2";
    private static final Set<String> INPUT_RESTARTS = Set.of(GAME_RESTART, GAME_FINISH);

    public static void main(String[] args) {
        System.out.println(GAME_START_MESSAGE);
        
        boolean whetherPlay = true;
        while (whetherPlay) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();

            // TODO: 인터페이스 경계 분리
            System.out.println(GAME_RESTART_MESSAGE);
            // TODO: 외부 라이브러리 의존성 제거
            String inputRestart = Console.readLine();

            if (!INPUT_RESTARTS.contains(inputRestart)) {
                throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
            }

            if (Objects.equals(inputRestart, GAME_FINISH)) {
                whetherPlay = false;
            }
        }

    }

}
