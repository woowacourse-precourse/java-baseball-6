package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    private static final Input input = new Input();
    private Input() {
    }
    public static Input getInput() {
        return input;
    }

    // 포함 관계
    GameException gameException = GameException.getMyException();
    Print print = Print.getPrint();

    // 게임 중
    public String doGame() {
        print.doGame();
        return gameException.checkAnswer(Console.readLine()); // 예외 처리 : 3 자리수, 동일숫자 안됨. 숫자만 들어올 것
    }
    // 정답 출력 후 게임 진행 여부 묻기
    public int finishGame(List<Integer> list) {
        print.finishGame();
        int choiceNum = gameException.checkFinishAnswer(Console.readLine()); // 예외 처리 : 1 혹은 2만 들어올 것
        if (choiceNum == 1) list.clear();
        return choiceNum;
    }
}
