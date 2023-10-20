package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballCalculator {

    public List<Integer> calculate(String input, List<Integer> computerNumbers) {
        List<Integer> inputList = convertToList(input);
        return compareToInputList(inputList, computerNumbers);
    }

    public List<Integer> convertToList(String input) {
        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            inputList.add(input.charAt(i) - '0');
        }
        return inputList;
    }

    public List<Integer> compareToInputList(List<Integer> inputList, List<Integer> computerNumbers) {
        /*
         * 1. 하나도 겹치는 값이 없을 경우, 낫딩 : [0,0,0] 반환
         * 2. 겹치는 값이 있지만 인덱스가 다를 경우, 볼 : 두 번째 인덱스 값 1 추가
         * 3. 겹치는 값이 있지만 인덱스가 같을 경우, 스트라이크 : 첫 번째 인덱스 값 1 추가
         */
        int countOfStrike = countStrike(inputList, computerNumbers);
        int countOfBall = countBall(inputList, computerNumbers);

        return new ArrayList<>(Arrays.asList(countOfStrike, countOfBall));
    }

    public int countStrike(List<Integer> inputList, List<Integer> computerNumbers) {
        int countOfStrike = 0;
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i).equals(computerNumbers.get(i))) {
                countOfStrike++;
            }
        }
        return countOfStrike;
    }

    public int countBall(List<Integer> inputList, List<Integer> computerNumbers) {
        int countOfBall = 0;
        for (int i = 0; i < inputList.size(); i++) {
            if (!inputList.get(i).equals(computerNumbers.get(i)) && computerNumbers.contains(inputList.get(i))) {
                countOfBall++;
            }
        }
        return countOfBall;
    }
}
