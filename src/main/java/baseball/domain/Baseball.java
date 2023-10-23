package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;


public class Baseball {

    private ArrayList<Integer> computerNumber;
    private final int MAKE_NUMBER_SIZE_MIN = 3;
    private final int RANDOM_NUMBER_MIN_RAGE = 1;
    private final int RANDOM_NUMBER_MAX_RAGE = 9;
    private final String STRIKE = "strike";
    private final String BALL = "ball";


    public Baseball() {
        computerNumber = generateComputerNumber();
    }

    public ArrayList<Integer> generateComputerNumber() {
        ArrayList<Integer> arrayRandomNumber = new ArrayList<>();
        while (arrayRandomNumber.size() < MAKE_NUMBER_SIZE_MIN) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_RAGE, RANDOM_NUMBER_MAX_RAGE);
            if (!arrayRandomNumber.contains(randomNumber)) {
                arrayRandomNumber.add(randomNumber);
            }
        }
        return arrayRandomNumber;
    }

    public Map<String, Integer> checkToStrikeAndBall(List<Integer> insertUserNumber) {
        int strikeCount = checkStrike(insertUserNumber);
        int ballCount = checkBall(insertUserNumber);

        Map<String, Integer> result = new HashMap<>();
        result.put(STRIKE, strikeCount);
        result.put(BALL, ballCount);
        return result;
    }

    private int checkStrike(List<Integer> insertUserNumber) {
        int strikeCount = 0;
        for (int i = 0; i < insertUserNumber.size(); i++) {
            int currentComputerNumber = computerNumber.get(i);
            int currentUserNumber = insertUserNumber.get(i);
            if (checkStrike(currentComputerNumber, currentUserNumber)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private boolean checkStrike(int computerNumber, int userNumber) {
        return Objects.equals(computerNumber, userNumber);
    }

    private int checkBall(List<Integer> insertUserNumber) {
        int ballCount = 0;
        for (int i = 0; i < insertUserNumber.size(); i++) {
            int currentComputerNumber = computerNumber.get(i);
            int currentUserNumber = insertUserNumber.get(i);
            if (!checkStrike(currentComputerNumber, currentUserNumber) && computerNumber.contains(currentUserNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public ArrayList<Integer> getComputerNumber() {
        return computerNumber;
    }
}
