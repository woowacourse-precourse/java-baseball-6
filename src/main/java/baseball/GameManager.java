package baseball;

import baseball.game.InputManager;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameManager {

    public List<Integer> createRandNumber() {
        List<Integer> randNumbers = new ArrayList<>();
        while (randNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randNumbers.contains(randomNumber)) {
                randNumbers.add(randomNumber);
            }
        }
        System.out.print("randNumber: ");
        for (Integer randNumber : randNumbers) {
            System.out.print(randNumber);
        }
        return randNumbers;
    }
    public String calculateHint(List<Integer> randBaseballNumber, String userBaseballNumber) {
        int strike = 0;
        int ball = 0;
        System.out.println("userBaseballNumber = " + userBaseballNumber);
        for (int i = 0; i < randBaseballNumber.size(); i++) {
            System.out.println(String.format("test: %s %s", randBaseballNumber.get(i), Integer.valueOf(String.valueOf(userBaseballNumber.charAt(i))) ));
            if (randBaseballNumber.get(i).equals(Integer.valueOf(String.valueOf(userBaseballNumber.charAt(i))))) {
                strike++;
                continue;
            }

            if (randBaseballNumber.contains(Integer.valueOf(String.valueOf(userBaseballNumber.charAt(i))))) {
                ball++;
            }
        }
        return String.format("%s 스트라이크 %s 볼", strike, ball);
    }

    public void playGame() {
        InputManager inputManager = new InputManager();

        List<Integer> randBaseballNumber = createRandNumber();
        while (true) {
            String userBaseballNumber = inputManager.getBaseballNumberFromUser(inputManager);
            System.out.println(calculateHint(randBaseballNumber, userBaseballNumber));

            if (isEnd(randBaseballNumber, userBaseballNumber)) {
                break;
            }
        }
    }

    private boolean isEnd(List<Integer> randBaseballNumber, String userBaseballNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : randBaseballNumber) {
            stringBuilder.append(integer);
        }

        return stringBuilder.toString().equals(userBaseballNumber);
    }


}
