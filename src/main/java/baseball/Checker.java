package baseball;

import java.util.ArrayList;
import java.util.List;

public class Checker {

    private List<Integer> computerNumbers;

    public void generateComputerNumbers() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = (int) (Math.random() * 9) + 1;
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public boolean checkGuess(List<Integer> userNumbers) {
        if (userNumbers.size() != 3 || !isValidInput(userNumbers)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 3자리 숫자를 입력하세요.");
        }

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }

        System.out.println(formatResult(strikes, balls));

        return strikes == 3;
    }

    private boolean isValidInput(List<Integer> userNumbers) {
        for (Integer number : userNumbers) {
            if (number < 1 || number > 9) {
                return false;
            }
        }
        return true;
    }

    private String formatResult(int strikes, int balls) {
        if (strikes == 3) {
            return "3스트라이크";
        } else if (strikes > 0 && balls > 0) {
            return balls + "볼 " + strikes + "스트라이크";
        } else if (balls > 0) {
            return balls + "볼";
        } else {
            return "낫싱";
        }
    }
}
