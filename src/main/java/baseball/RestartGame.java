package baseball;

import camp.nextstep.edu.missionutils.Console;

public class RestartGame {

<<<<<<< HEAD
    public boolean isRestartGame() throws IllegalArgumentException {
        boolean isRestart = false;
        int answer = getAnswer();
        if (answer == ConstantVO.RESTART) {
            isRestart = true;
        } else if (answer == ConstantVO.GAME_OVER) {
            isRestart = false;
        }
        return isRestart;
=======
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
>>>>>>> parent of 57b5d2f (refactor. mvc 패턴 적용 시도)
    }

    private int getAnswer() throws IllegalArgumentException {
        int answer = Integer.parseInt(Console.readLine());

<<<<<<< HEAD
        if (answer == 0 || answer > ConstantVO.GAME_OVER) {
=======
        if(answer == 0 || answer > ConstantVO.GAME_OVER) {
>>>>>>> parent of 57b5d2f (refactor. mvc 패턴 적용 시도)
            throw new IllegalArgumentException();
        }
        return answer;
    }
}
