package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class InputConsole {
    public String readPrediction(){
        String input = Console.readLine();
        return getValidated(input);
    }

    public String readUserIntentionForNewGame(){
        String input = Console.readLine();
        if (Objects.equals(input, "1") || Objects.equals(input, "2")){
            return input;
        } else throw new IllegalArgumentException("게임 재시작 여부는 1과 2만 받을 수 있습니다.");
    }

    private String getValidated(String input){
        validateLength(input);
        validateDigitOnly(input);
        validateNoDuplication(input);
        return input;
    }

    private void validateLength(String input){
        if (input.length() != 3) throw new IllegalArgumentException("입력길이는 3이어야 합니다.");
    }

    private void validateDigitOnly(String input){
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자가 아닌 입력이 있습니다.");
            }
        }
    }

    private void validateNoDuplication(String input){
        HashSet<Integer> result = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                result.add(digit);
            }
        }

        if (result.size() != 3) throw new IllegalArgumentException("중복된 숫자가 있습니다.");
    }
}
