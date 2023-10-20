package baseball.view;


import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String insertBallNum() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String insertNewGameOrGameOver() {
        return Console.readLine();
    }
}
