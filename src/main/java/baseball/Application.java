package baseball;

import baseball.domain.answer.Answer;
import baseball.domain.number.Number;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static final Answer ANSWER = new Answer();

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요. : ");

        String readLine = Console.readLine();
        Number number = new Number(readLine);

    }
}
