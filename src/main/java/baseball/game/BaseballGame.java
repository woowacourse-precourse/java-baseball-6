package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;


public class BaseballGame implements Game {
    private static final int NUMBER_OF_TARGET = 3;
    private HashMap<Integer, Integer> targetMap;

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void initGame() {
        targetMap = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_TARGET; ++i) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            while (targetMap.containsKey(randomNumber)) {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            }
            targetMap.put(randomNumber, i);
        }
    }

    public void start() {
        while (true) {
            boolean playerWin = this.roundStart();
            if (playerWin) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private boolean roundStart() {
        ArrayList<Integer> predictionList = readPrediction();
        int numberOfStrike = gradePrediction(predictionList);
        return numberOfStrike == NUMBER_OF_TARGET;
    }

    private ArrayList<Integer> readPrediction() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return convertToList(input);
    }

    private ArrayList<Integer> convertToList(String input) {
        if (input.length() != NUMBER_OF_TARGET) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> predictionList = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_TARGET; ++i) {
            char ch = input.charAt(i);
            if ('1' > ch || '9' < ch) {
                throw new IllegalArgumentException();
            }
            Integer prediction = Character.getNumericValue(ch);
            if (predictionList.contains(prediction)) {
                throw new IllegalArgumentException();
            }
            predictionList.add(prediction);
        }
        return predictionList;
    }

    private int gradePrediction(ArrayList<Integer> predictionList) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < NUMBER_OF_TARGET; ++i) {
            if (targetMap.containsKey(predictionList.get(i))) {
                if (targetMap.get(predictionList.get(i)) == i) {
                    ++strikeCount;
                    continue;
                }
                ballCount++;
            }
        }
        printGrade(ballCount, strikeCount);

        return strikeCount;
    }

    private void printGrade(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ballCount != 0) {
            System.out.print(ballCount + "볼");
            if (strikeCount != 0) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
        if (strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        }
    }
}