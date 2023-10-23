package baseball;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseballGameController {

    public int[] guess(BaseballGame baseballGame, String input){
        NumberBoard computerAnswer = baseballGame.getNumberBoard();
        int size = computerAnswer.size();

        validateInput(input, size);
        int[] inputToArray = input.chars()
                .map(i -> i - '0')
                .toArray();
        NumberBoard myAnswer = new NumberBoard(inputToArray);

        int[] result = CountBallByAnswer(computerAnswer, myAnswer);
        return result;
    }

    private static int[] CountBallByAnswer(NumberBoard computerAnswer, NumberBoard myAnswer) {
        int strike = 0;
        int ball = 0;

        for(int i = 0; i< myAnswer.size(); i++){
            for(int j = 0; j< computerAnswer.size(); j++){
                if(myAnswer.posNumber(i) == computerAnswer.posNumber(j) && i==j) {
                    strike++;
                    break;
                }
                if(myAnswer.posNumber(i) == computerAnswer.posNumber(j) && i!=j) {
                    ball++;
                    break;
                }
            }
        }

        int[] result = new int[3];
        result[0] = strike;
        result[1] = ball;
        result[2] = computerAnswer.size();
        return result;
    }

    private void validateInput(String input, int size){
        if (validateInputByTypeSize(input, size) || nonDuplicateNumber(input, size)) {
            throw new IllegalArgumentException("길이가 " + size + "인 중복되지 않는 숫자를 입력해주세요.");
        }
    }
    private static boolean nonDuplicateNumber(String input, int size) {
        return input.chars()
                .distinct()
                .count() != size;
    }
    private static boolean validateInputByTypeSize(String input, int size) {
        String regex = String.format("[0-9]{%d}", size);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return !matcher.matches();
    }
}
