package baseball;

import camp.nextstep.edu.missionutils.Console;

public class RestartGame {

    public boolean restartGame() throws IllegalArgumentException {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int answer = getAnswer();
            if (answer == ConstantVO.RESTART) {
                return true;
            } else if (answer == ConstantVO.GAME_OVER) {
                return false;
            } else {
                System.out.println("유효한 입력이 아닙니다. 다시 입력하세요");
            }
        }
    }

    private int getAnswer() throws IllegalArgumentException {
        int answer = Integer.parseInt(Console.readLine());

        if(answer == 0 || answer > ConstantVO.GAME_OVER) {
            throw new IllegalArgumentException();
        }
        return answer;
    }
}
