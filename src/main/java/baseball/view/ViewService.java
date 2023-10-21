package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ViewService {

    public void printReadMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public String readNumber() {
        return readLine();
    }
}