package baseball.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CheckNumber {

    private static List<Integer> convertStrToIntList(String input) {
        return input.chars().mapToObj(Character::getNumericValue).collect(Collectors.toList());
    }

    private static boolean isValidNumber(String input) {
        return Pattern.matches("^[1-9]{3}$", input);
    }

    private static boolean isUnique(String input) {
        List<Integer> intValues = convertStrToIntList(input);
        Set<Integer> uniqueValues = new HashSet<>(intValues);
        return uniqueValues.size() == input.length();
    }

    public boolean check(List<Integer> computer, String input){

        if(!isValidNumber(input) || !isUnique(input)){
            final String errorMessage = String.format("%s 올바른 숫자가 아닙니다.",input);
            throw new IllegalArgumentException(errorMessage);
        }
        final List<Integer> player = convertStrToIntList(input);
        int ball = 0;
        int strike = 0;
        for(int i = 0; i < player.size(); i++){
            for (int j = 0; j < computer.size(); j++){
                if(Objects.equals(player.get(i), computer.get(j))){
                    if(i == j){
                        strike++;
                        break;
                    }
                    ball++;
                    break;
                }
            }
        }

        final String ballText = String.format(" %d볼",ball);
        final String strikeText = String.format(" %d스트라이크",strike);
        final String nothingText = String.format(" 낫싱",strike);
        String result = "";
        if(ball != 0) result += ballText;
        if(strike != 0) result += strikeText;
        if(ball == 0 && strike == 0) result += nothingText;
        System.out.println(result.trim());
        return strike == 3;
    }
}
