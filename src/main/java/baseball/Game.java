package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Game {
    Inspection inspection = new Inspection();
    private final int[] compArray = new int[3];

    public void playGame() {
        compPick();
        //컴퓨터 패 출력 확인
        for (int i = 0; i < compArray.length; i++) {
            System.out.println(compArray[i]);
        }
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
        for (int i = 0; i < 3; i++) {
            compArray[i] = Randoms.pickNumberInRange(1, 9);
        }

    }
    private int[] calculateResult(int[] userNumbers) {
        int[] result = new int[2];
        int[] secretCopy = Arrays.copyOf(compArray, compArray.length);

        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == secretCopy[i]) {
                result[1]++;
                // To avoid counting this digit again
                userNumbers[i] = -1;
                secretCopy[i] = -2;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (userNumbers[i] == secretCopy[j]) {
                    result[0]++;
                    // To avoid counting this digit again
                    userNumbers[i] = -1;
                    secretCopy[j] = -2;
                }
            }
        }
        return result;
    }


}
