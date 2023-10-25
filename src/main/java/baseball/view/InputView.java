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
        int choice = Integer.parseInt(readLine());
        validateIsOneOrTwo(choice);
        return choice;
    }

    public void validateIsOneOrTwo(int choice) {
        if (choice != 1 && choice != 2) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2의 숫자만 선택해야 합니다.");
        }
    }

}
