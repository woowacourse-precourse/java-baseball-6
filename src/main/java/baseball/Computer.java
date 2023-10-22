package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    private final Count answer;

    public Computer(Count answer) {
        this.answer = answer;
    }

    public Computer(){
        this.answer = Count.provideCount(generateRandomCount());
    }
    private String generateRandomCount(){
        List<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < 3; i++) {
            int deleteIndex = Randoms.pickNumberInRange(0, numbers.size()-1);
            sb.append(numbers.remove(deleteIndex));
        }

        return sb.toString();
    }

    public String judgeGameResult(Count guess) {
        String guessNumber = guess.toString();
        String answerNumber = answer.toString();
        StringBuilder gameResult = new StringBuilder();
        gameResult.append(isBall(guessNumber, answerNumber)).append(" ");
        gameResult.append(isStrike(guessNumber, answerNumber)).append(" ");
        gameResult.append(isNothing(gameResult.toString()));
        return gameResult.toString().trim();
    }

    private String isStrike(String guessNumber, String answerNumber) {
        int count =0;
        for (int i = 0; i < guessNumber.length(); i++) {
            if(guessNumber.charAt(i) == answerNumber.charAt(i)){
                count++;
            }
        }
        return count + "스트라이크";
    }

    private String isBall(String guessNumber, String answerNumber){
        int count =0;
        for (int i = 0; i < guessNumber.length(); i++) {
            count = isPresentOtherDigit(guessNumber, answerNumber, i)? count+1 : count;
        }
        return count + "볼";
    }

    private String isNothing(String result){
        return (result.isEmpty()) ? "낫싱 ": "";
    }

    private static boolean isPresentOtherDigit(String guessNumber, String answerNumber, int i) {
        for(int j = 0; j< answerNumber.length(); j++){
            if(i == j){
                continue;
            }
            if(guessNumber.charAt(i) == answerNumber.charAt(j)){
                return true;
            }
        }
        return false;
    }
}
