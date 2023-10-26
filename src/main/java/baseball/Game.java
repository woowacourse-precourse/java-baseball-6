package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Game {
    Inspection inspection = new Inspection();
    private final int[] comNumbers = new int[3];
    public void playGame() {
        compPick();
        while (true) {
            int[] userNumbers = inspection.getUserInput();
            int[] result = calculateResult(userNumbers);
            if(result[0] > 0 && result[1] > 0) {
                System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
            } else if (result[0] >0) {
                System.out.println(result[0] + "볼 ");
            } else if (result[1] >0){
                System.out.println(result[1] + "스트라이크");
                if (result[1] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            } else {
                System.out.println("낫싱");
            }
        }
        inspection.askForRestart();
    }
    private void compPick() {
        Set<Integer> pickedNumbers = new HashSet<>();
        while (pickedNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            pickedNumbers.add(randomNumber);
        }
        int index = 0;
        for (Integer number : pickedNumbers) {
            comNumbers[index] = number;
            index++;
        }
    }
    private int[] calculateResult(int[] userNumbers) {
        int[] result = new int[2];
        int[] secretCopy = Arrays.copyOf(comNumbers, comNumbers.length);
        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == secretCopy[i]) {
                result[1]++;
                userNumbers[i] = -1;
                secretCopy[i] = -2;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (userNumbers[i] == secretCopy[j]) {
                    result[0]++;
                    userNumbers[i] = -1;
                    secretCopy[j] = -2;
                }
            }
        }
        return result;
    }
}
