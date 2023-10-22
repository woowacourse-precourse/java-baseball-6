package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

public class ComputerNumbers {
    public final static int MIN_NUMBER_RANGE = 1;
    public final static int MAX_NUMBER_RANGE = 9;
    public final static int RANDOM_NUMBER_LENGTH = 3;

    // String으로 생성 : Player 입력값이 String이라 String으로 모두 처리하는 방법
    private String randomNumbers;

    public void setRandomNumber() {
        LinkedHashSet<String> randomNumberSet = new LinkedHashSet<String>();
        while (randomNumberSet.size() < RANDOM_NUMBER_LENGTH) {
            randomNumberSet.add(generateRandom());
        }

        this.randomNumbers = String.join("", randomNumberSet);
    }

    private String generateRandom() {
        return Integer.toString(Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE));
    }

/*    public List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < RANDOM_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }*/

}
