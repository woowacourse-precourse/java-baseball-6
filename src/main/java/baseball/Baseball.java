package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Baseball {
    private List<Integer> winningNumbers = new ArrayList<>();
    private List<Integer> guessingNumbers = new ArrayList<>();
    boolean running = true;

    Baseball() {
    }

    public void play() throws IllegalArgumentException {
        pickWinningNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (running) {
            int strike = 0;
            int ball = 0;
            System.out.print("숫자를 입력해주세요 : ");
            readInputNumbers();
            for (int i = 0; i < winningNumbers.size(); i++) {
                int winningNumber = winningNumbers.get(i);
                int guessingNumber = guessingNumbers.get(i);
                if (winningNumber == guessingNumber) {
                    strike++;
                }
                if (winningNumber != guessingNumber && winningNumbers.contains(guessingNumber)) {
                    ball++;
                }
            }
            if (ball == 0 && strike == 0) {
                System.out.print("낫싱");
            }
            if (ball != 0) {
                System.out.printf("%d볼 ", ball);
            }
            if (strike != 0) {
                System.out.printf("%d스트라이크", strike);
            }
            System.out.println();
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                running = false;
            }
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
        try {
            String inputString = Console.readLine();
            int inputNumber = Integer.parseInt(inputString);
            if (inputNumber != 1 && inputNumber != 2) {
                throw new IllegalArgumentException("1이나 2가 아닙니다.");
            }
            if (inputNumber == 1) {
                running = true;
                play();
            }
            if (inputNumber == 2) {
                return;
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("NumberFormatException");
        }
    }

    private void pickWinningNumbers() {
        if (winningNumbers.size() != 0) {
            winningNumbers.clear();
        }
        while (winningNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!winningNumbers.contains(randomNumber)) {
                winningNumbers.add(randomNumber);
            }
        }
    }

    private void readInputNumbers() throws IllegalArgumentException {
        try {
            String inputString = Console.readLine();
            int inputNumber = Integer.parseInt(inputString);
            if (inputNumber < 100 || 999 < inputNumber) {
                throw new IllegalArgumentException("세자리 정수가 아닙니다.");
            }
            if (guessingNumbers.size() != 0) {
                guessingNumbers.clear();
            }
            for (int i = 0; i < 3; i++) {
                String ithString = inputString.substring(i, i + 1);
                int guessingNumber = Integer.parseInt(ithString);
                if (guessingNumber == 0) {
                    throw new IllegalArgumentException("0이 포함되어 있습니다.");
                }
                if (!guessingNumbers.contains(guessingNumber)) {
                    guessingNumbers.add(guessingNumber);
                } else {
                    throw new IllegalArgumentException("중복된 숫자가 있습니다.");
                }
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("NumberFormatException");
        }
    }
}