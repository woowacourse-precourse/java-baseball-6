package baseball.entity;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public UserInput() {
    }

    // 게임중 입력을 받기 위한 함수
    public String receiveInputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();

        UserInputHandler.validInputNumber(inputNumber);

        return inputNumber;
    }

    // 게임 종료후, 입력을 받기 위한 함수
    public String receiveRestartNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartNumber = Console.readLine();

        UserInputHandler.validRestartNumber(restartNumber);

        return restartNumber;
    }
}
