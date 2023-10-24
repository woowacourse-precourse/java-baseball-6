package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String readPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();
        return input;
    }

    public String readGameRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        return input;
    }
}

