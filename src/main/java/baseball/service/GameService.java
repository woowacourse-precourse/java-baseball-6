package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameService {
    private final Scanner scanner = new Scanner(System.in);
    private List<Integer> computer;

    public void playGame() {

    }

    List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = scanner.nextLine();
        List<Integer> userNumber = new ArrayList<>();

        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            if (userInput.charAt(i) < '1' || userInput.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
            userNumber.add(userInput.charAt(i) - '0');
        }
        return userNumber;
    }
}
