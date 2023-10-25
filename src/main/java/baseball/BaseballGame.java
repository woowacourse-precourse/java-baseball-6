package baseball;

import baseball.exception.ErrorMessage;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    List<Integer> randomNum;

    // 랜덤 세자리 수 생성
    public List<Integer> getRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        randomNum = getRandomNumber();
    }

    public void play() {
        while (true) {
            List<Integer> input = stringToList(getInputNumber());
            boolean result = Result.checkStrikeBallCount(randomNum, input);

            if (result) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public String getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine().trim();
        return input;
    }

    public List<Integer> stringToList(String stringInput) {
        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < stringInput.length(); i++) {
            int number = stringInput.charAt(i) - '0';

            if (number < 100 || number > 999) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
            }
            intList.add(number);
        }
        return intList;
    }

    public boolean isFinish() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }

        if (input.equals("1")) {
            return false;
        }
        return true;
    }
}
