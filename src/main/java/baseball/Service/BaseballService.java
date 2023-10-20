package baseball.Service;

import java.util.List;

import baseball.Entity.InputNumber;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballService {

    public boolean GameLogic(List<Character> randomNumberList, String input) {
        InputNumber inputNumber = new InputNumber(createInputNumberList(input));
        List<Character> inputNumberList = inputNumber.getInputNumberList();
        int strikeCount = getStrikeCount(randomNumberList, inputNumberList);
        int ballCount = getBallCount(randomNumberList, inputNumberList);
        System.out.println(getResult(strikeCount, ballCount));
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }

    public List<Character> createRandomNumberList() {
        List<Character> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            char randomNumber = (char) (Randoms.pickNumberInRange(1, 9) + '0');
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    public static List<Character> createInputNumberList(String input) {
        List<Character> inputNumberList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            inputNumberList.add(input.charAt(i));
        }
        return inputNumberList;
    }

    public static int getStrikeCount(List<Character> randomNumberList, List<Character> inputNumberList) {
        int strikeCount = 0;
        for (int i = 0; i < randomNumberList.size(); i++) {
            if (inputNumberList.get(i) == randomNumberList.get(i)) {
                strikeCount++;
                inputNumberList.set(i, 's');
                continue;
            }
        }
        return strikeCount;
    }

    public static int getBallCount(List<Character> randomNumberList, List<Character> inputNumberList) {
        int ballCount = 0;
        for (int i = 0; i < inputNumberList.size(); i++) {
            if (inputNumberList.get(i) == 's') {
                continue;
            }
            for (int j = 0; j < randomNumberList.size(); j++) {
                if (inputNumberList.get(j) == 's' || inputNumberList.get(j) == 'b') {
                    continue;
                }
                if (inputNumberList.get(i) == randomNumberList.get(j)) {
                    ballCount++;
                    char changeChar = inputNumberList.get(j);
                    inputNumberList.set(i, changeChar);
                    inputNumberList.set(j, 'b');
                    continue;
                }
            }
        }
        return ballCount;
    }

    public static String getResult(int strikeCount, int ballCount) {

        if (strikeCount == 3) {
            return strikeCount + "스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if (strikeCount != 0 && ballCount == 0) {
            return strikeCount + "스트라이크";
        }
        if (strikeCount == 0 && ballCount != 0) {
            return ballCount + "볼";
        }
        if (strikeCount != 0 && ballCount != 0) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }

        return "낫싱";

    }

}
