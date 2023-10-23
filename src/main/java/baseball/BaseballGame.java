package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public void playGame() {
        List<Integer> computerNumbers = createRandomNumList();
        boolean isRun = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isRun) {
            int ballCount = 0;
            int strikeCount = 0;

            String inputStr = Console.readLine();

            if (isInvalidInput(inputStr)) {
                throw new IllegalArgumentException("1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력해주세요.");
            }

            String[] userNumbers = inputStr.split("");

            // 숫자 정답여부 확인
            for (int i = 0; i < 3; i++) {
                int userNum = Integer.parseInt(userNumbers[i]);
                if (computerNumbers.contains(userNum)) {
                    if (computerNumbers.get(i) == userNum) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }

            displayResult(ballCount, strikeCount);

            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isRun = false;
            }
        }
    }

    // 잘못된 입력값인지 확인
    private boolean isInvalidInput(String inputStr) {
        return inputStr == null
                || !inputStr.matches("[1-9]+") // 1~9까지의 숫자
                || inputStr.length() != 3
                || hasDuplicateNumber(inputStr);
    }

    // 중복된 문자를 가졌는지를 확인
    private boolean hasDuplicateNumber(String inputStr) {
        // chars(): 문자열 스트림화
        // distinct(): 스트림에서 중복된 문자 제거
        // count(): 문자 수 (= length)
        return inputStr.chars().distinct().count() != 3;
    }

    // 게임 결과 출력
    private void displayResult(int ballCount, int strikeCount) {
        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (ballCount != 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }

    private List<Integer> createRandomNumList() {
        List<Integer> numList = new ArrayList<>();
        while (numList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber);
            }
        }
        return numList;
    }

}
