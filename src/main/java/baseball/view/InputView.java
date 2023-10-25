package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    // player가 서로 다른 숫자 3가지 입력
    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        return readLine();
    }

    // player가 게임 종료 후 재시작/종료 선택
    public String endOrContinuePrompt() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return readLine();
    }
}
