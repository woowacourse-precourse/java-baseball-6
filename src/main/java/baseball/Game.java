package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> generateRandomNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public List<Integer> inputPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> playerNumbers = new ArrayList<>();
        String inputNumber = Console.readLine();
        if(isDuplicate(inputNumber) || isIncorrectLength(inputNumber) || isIncorrectNum(inputNumber)) {
            throw new IllegalArgumentException();
        }
        for (char inputChar : inputNumber.toCharArray()) {
            int inputDigit = Character.getNumericValue(inputChar);
            playerNumbers.add(inputDigit);
        }
        return playerNumbers;
    }

    private boolean isDuplicate(String inputString) {
        Set<Character> set = new HashSet<>();
        for(char digit : inputString.toCharArray()) {
            set.add(digit);
        }
        return set.size() != inputString.length();
    }

    private boolean isIncorrectLength(String inputString) {
        return inputString.length() != 3;
    }

    private boolean isIncorrectNum(String inputString) {
        for (char num : inputString.toCharArray()) {
            if (num < '1' || num > '9') {
                return true;
            }
        }
        return false;
    }
}
