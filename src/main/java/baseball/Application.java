package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }

    private static void playGame() {
        System.out.println("숫자를 입력해주세요");
        String input = Console.readLine();
        validation(input);
    }

    private static void validation(String input){
        String pattern = "[1-9]{1,3}";

        boolean regex = Pattern.matches(pattern, input);
        if ( !regex ) throw new IllegalArgumentException();

        boolean isDuplicated = duplicateCheck(input);
        if ( isDuplicated ) throw new IllegalArgumentException();
    }

    private static boolean duplicateCheck(String input) {
        Set<Character> characters = new HashSet<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }
        return characters.size() != input.length();
    }

}
