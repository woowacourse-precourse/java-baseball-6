package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Hint;

public class ViewService {

    public void printReadMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public String readNumber() {
        return readLine();
    }

    public void printHintMessage(Hint hint) {
        System.out.println(hint.toString());

        if (hint.isThreeStrike()) {
            printGameEndMessage();
        }
    }

    private void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        printRetryMessage();
    }

    public void printRetryMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}