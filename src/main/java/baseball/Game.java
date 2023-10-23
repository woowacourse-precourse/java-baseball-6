package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE3 = "3스트라이크";
    private List<Integer> computerNumber;
    private List<Integer> playerNumber;
    private boolean exit = false;
    private NumberGenerator numberGenerator = new NumberGenerator();
    private HintGenerator hintGenerator = new HintGenerator();

    public void gameStart() {
        System.out.println(GAME_START_MESSAGE);
        computerNumber = numberGenerator.setComputerNumber(); // 최초 컴퓨터 번호 셋팅
        while (!exit) {
            playerNumber = numberGenerator.setPlayerNumber(); // 플레이어 번호 셋팅
            String hint = hintGenerator.getHint(computerNumber, playerNumber); // Hint 결과 확인
            System.out.println(hint);
            if (hint.equals(STRIKE3)) {
                decideNextStep();
            }
        }
    }

    public void decideNextStep() {
        System.out.println(GAME_OVER_MESSAGE);
        String num = Console.readLine();
        if (!num.equals("1") && !num.equals("2")) { // 예외 처리
            throw new IllegalArgumentException();
        }
        if (num.equals("1")) { // 게임 재시작
            computerNumber = numberGenerator.setComputerNumber(); // 컴퓨터 번호 새로 셋팅
        }
        if (num.equals("2")) { // 게임 종료
            exit = true;
        }
    }
}
