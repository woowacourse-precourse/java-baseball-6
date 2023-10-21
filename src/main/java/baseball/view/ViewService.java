package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ViewService {

    public void printReadMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public String readNumber() {
        return readLine();
    }

    public void printRetryMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}