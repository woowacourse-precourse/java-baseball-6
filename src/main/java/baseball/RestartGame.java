package baseball;

import camp.nextstep.edu.missionutils.Console;

public class RestartGame {

    public boolean isRestartGame() throws IllegalArgumentException {
        boolean restart = false;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int answer = getAnswer();

        if (answer == ConstantVO.RESTART) {
            restart = true;
        } else if (answer == ConstantVO.GAME_OVER) {
            restart = false;
        }
        return restart;
    }

    private int getAnswer() throws IllegalArgumentException {
        int answer = Integer.parseInt(Console.readLine());

        if (answer == 0 || answer > ConstantVO.GAME_OVER) {
            throw new IllegalArgumentException();
        }
        return answer;
    }
}
