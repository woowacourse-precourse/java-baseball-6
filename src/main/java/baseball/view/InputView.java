package baseball.view;

import baseball.validation.ExitValidation;
import baseball.validation.PickNumberValidation;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InputView {

    public void printStartGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public List<Integer> inputNumber() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String picks = Console.readLine();
            List<Integer> pickNumbers = Arrays.stream(picks.split(""))
                                    .map(Integer::parseInt)
                                    .collect(toList());
            PickNumberValidation.checkValidInput(pickNumbers);
            return pickNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
    public boolean askGameEnd() {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restartBtn = Integer.parseInt(Console.readLine());
            ExitValidation.checkValidExit(restartBtn);
            return restartBtn == 2;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
