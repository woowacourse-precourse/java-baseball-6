package baseball;

import java.util.List;

public class GameManager {

    // 스트라이크 수 를 return 해주는 메소드
    public static int getStrikeCount(String inputNumberString, List<Integer> randomComputerList) {
        int strikeCount = 0; // 스트라이크 수
        char[] inputNumCharArray = inputNumberString.toCharArray();
        for (int i = 0; i < inputNumCharArray.length; i++) {

            int myNum = Character.getNumericValue(inputNumCharArray[i]);
            for (int j = 0; j < randomComputerList.size(); j++) {
                int computerNum = randomComputerList.get(j);
                if (myNum == computerNum && i == j) {
                    strikeCount++;
                }
            }
        }

        return strikeCount;
    }

    // 볼 수 를 return 해주는 메소드
    public static int getBallCount(String inputNumberString, List<Integer> randomComputerList) {
        int ballCount = 0; // 볼 수
        char[] inputNumCharArray = inputNumberString.toCharArray();
        for (int i = 0; i < inputNumCharArray.length; i++) {

            int myNum = Character.getNumericValue(inputNumCharArray[i]);
            for (int j = 0; j < randomComputerList.size(); j++) {
                int computerNum = randomComputerList.get(j);
                if (myNum == computerNum && i != j) {
                    ballCount++;
                }
            }
        }

        return ballCount;
    }
}