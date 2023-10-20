package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Baseball {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다." );
        List<Integer> answerNumber = generateNumber();
        while (true) {
            List<Integer> userNumber = inputUserNumber();
            Integer strikeCount = getStrikeCount(answerNumber, userNumber);
            if (strikeCount == 3) {
                break;
            }
            Integer ballCount = getBallCount(answerNumber, userNumber);
            if (ballCount == 0 && strikeCount == 0) {
                System.out.println("낫싱" );
                continue;
            }
            StringBuilder outputString = new StringBuilder();
            if (ballCount > 0) {
                outputString.append(ballCount).append("볼 " );
            }
            if (strikeCount > 0) {
                outputString.append(strikeCount).append("스트라이크" );
            }
            System.out.println(outputString);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료" );
        restartGame();
    }

    public List<Integer> generateNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

    public boolean isNumeric(String strNum) {
        try {
            Integer number = Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public List<Integer> inputUserNumber() {
        System.out.println("숫자를 입력해주세요 : " );
        String inputNumber = Console.readLine();
        List<Integer> integerList = new ArrayList<>();
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
        if (!isNumeric(inputNumber)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; ++i) {
            if (integerList.contains(inputNumber.indexOf(i))) {
                throw new IllegalArgumentException();
            }
            integerList.add(inputNumber.indexOf(i));
        }

        return integerList;
    }

    public Integer getStrikeCount(List<Integer> answerNumber, List<Integer> userNumber) {
        Integer strikeCount = 0;
        for (int i = 0; i < 3; ++i) {
            if (Objects.equals(answerNumber.get(i), userNumber.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public Integer getBallCount(List<Integer> answerNumber, List<Integer> userNumber) {
        Integer ballCount = 0;
        for (int i = 0; i < 3; ++i) {
            Integer number = userNumber.get(i);
            if (answerNumber.contains(number) && !answerNumber.get(i).equals(number)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public void restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." );
        String inputNumber = Console.readLine();
        if (!isNumeric(inputNumber)) {
            throw new IllegalArgumentException();
        }
        if (inputNumber.length() != 1) {
            throw new IllegalArgumentException();
        }
        Integer restartNumber = Integer.parseInt(inputNumber);
        if (restartNumber > 3 || restartNumber <= 0) {
            throw new IllegalArgumentException();
        }
        if (restartNumber == 2) {
            return;
        }
        if (restartNumber == 1) {
            startGame();
        }
    }

}
