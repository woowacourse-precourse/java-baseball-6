package baseball.domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    static List<Integer> numbers = new ArrayList<>();
    static final int MAX_NUMBERS = 3;
    static final int START_INCLUSIVE = 1;
    static final int END_INCLUSIVE = 9;

    public List <Integer> generateNumbers(){
        while(numbers.size() < MAX_NUMBERS){
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if(isNotDuplicated(randomNumber)) numbers.add(randomNumber);
        }
        return numbers;
    }

    private boolean isNotDuplicated(int randomNumber) {
        return !numbers.contains(randomNumber);
    }

    public List<Integer> parseInputToList(String input) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            userNumbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return userNumbers;
    }

    public int[] compare(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int[] result = new int[2]; // result[0] == strike, result[1] == ball
        for(int index = 0; index < MAX_NUMBERS; index++){
            if(isStrike(computerNumbers, userNumbers, index)) result[0]++;
            if(isBall(computerNumbers, userNumbers, index)) result[1]++;
        }
        return result;
    }

    private boolean isBall(List<Integer> computerNumbers, List<Integer> userNumbers, int index) {
        int number = userNumbers.get(index);
        return computerNumbers.contains(number) && !isStrike(computerNumbers, userNumbers, index);
    }

    private boolean isStrike(List<Integer> computerNumbers, List<Integer> userNumbers, int index) {
        return computerNumbers.get(index) ==  userNumbers.get(index);
    }

    public void printResult(int[] result){
        int strikes = result[0];
        int balls = result[1];

        String ballResult = printBalls(balls);
        String strikeResult = printStrikes(strikes);

        if(ballResult.isEmpty() && strikeResult.isEmpty()) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(ballResult + strikeResult);
    }

    private String printBalls(int balls){
        if(balls >= 1) return balls + "볼 ";
        return "";
    }

    private String printStrikes(int strikes){
        if(strikes >= 1) return strikes + "스트라이크";
        return "";
    }

}
