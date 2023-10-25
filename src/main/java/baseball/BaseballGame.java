package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    private enum BaseBallType {
      NOTHING,
      BALL,
      STRIKE
    }

    private List<Integer> computerBallList;
    private int totalNumber;

    public BaseballGame(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    private void initBallNumbers() {
        this.computerBallList = new ArrayList<>();
        while (computerBallList.size() < this.totalNumber) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBallList.contains(randomNumber)) {
                computerBallList.add(randomNumber);
            }
        }
    }

    private List<Integer> stringToIntList(String numberString) {
        List<Integer> numberList = new ArrayList<>();
        int inputNumber;

        // 입력값이 숫자로 구성했는지 검사
        try {
            inputNumber = Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        // 입력값이 원하는 자릿수인지 검사
        if (numberString.length() != totalNumber) {
            throw new IllegalArgumentException();
        }

        // 입력값이 중복했는지 검사
        for (int i = 0; i < this.totalNumber; i++) {
            int nowInt = inputNumber % 10;
            if (!numberList.contains(nowInt)) {
                numberList.add(0, nowInt);
            } else {
                throw new IllegalArgumentException();
            }
            inputNumber = inputNumber / 10;
        }

        return numberList;
    }

    private BaseBallType gradeOneNumber(int userNumber, int nowIndex) {
        if (this.computerBallList.get(nowIndex) == userNumber) {
            return BaseBallType.STRIKE;
        } else {
            for (int computerInt : this.computerBallList) {
                if (computerInt == userNumber) {
                    return BaseBallType.BALL;
                }
            }
            return BaseBallType.NOTHING;
        }
    }

    private void printResult(int ballTimes, int strikeTimes) {
        if (ballTimes > 0) System.out.print(ballTimes + "볼 ");
        if (strikeTimes > 0) System.out.print(strikeTimes + "스트라이크");
        if (ballTimes + strikeTimes == 0) System.out.print("낫싱");
        System.out.println();
    }

    private boolean gradeAllNumber(String userInput) {
        int ballTimes = 0;
        int strikeTimes = 0;

        // 사용자 입력 검증 부분
        List<Integer> userInputNumberList = stringToIntList(userInput);

        // 숫자 판단 부분
        for (int i = 0; i < this.totalNumber; i++) {
            BaseBallType result = gradeOneNumber(userInputNumberList.get(i), i);
            switch (result) {
              case STRIKE -> strikeTimes += 1;
              case BALL -> ballTimes += 1;
              default -> {}
            }
        }

        // 결과 출력 부분
        printResult(ballTimes, strikeTimes);
        if (strikeTimes == this.totalNumber) {
            System.out.println(this.totalNumber + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public void play() {
        initBallNumbers();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();
            boolean gameResult = gradeAllNumber(userInput);
            if (gameResult) return;
            else continue;
        }
    }

    @Override
    public String toString() {
        return "숫자 야구 게임";
    }
}
