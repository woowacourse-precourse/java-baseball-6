package baseball.game;

import baseball.model.Score;
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
        Score score = gradePrediction(predictionList);
        printScore(score);
        return score.getStrike() == NUMBER_OF_TARGET;
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

    private Score gradePrediction(ArrayList<Integer> predictionList) {
        Score score = new Score();

        for (int i = 0; i < NUMBER_OF_TARGET; ++i) {
            if (targetMap.containsKey(predictionList.get(i))) {
                if (targetMap.get(predictionList.get(i)) == i) {
                    score.incrementStrike();
                    continue;
                }
                score.incrementBall();
            }
        }
        return score;
    }

    private void printScore(Score score) {
        if (score.getBall() == 0 && score.getStrike() == 0) {
            System.out.println("낫싱");
            return;
        }
        if (score.getBall() != 0) {
            System.out.print(score.getBall() + "볼");
            if (score.getStrike() != 0) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
        if (score.getStrike() != 0) {
            System.out.println(score.getStrike() + "스트라이크");
        }
    }
}