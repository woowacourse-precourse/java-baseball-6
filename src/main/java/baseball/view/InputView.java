package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = readLine();
        validateThreeDigitNumber(number);
        return number;
    }

    public void validateThreeDigitNumber(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 3자리의 숫자를 입력하여야 합니다.");
        }
    }

    public int inputRestartChoice() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(readLine());
    }

}
