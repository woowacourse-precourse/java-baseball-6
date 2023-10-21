package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        int goal = Randoms.pickNumberInRange(0, 999);
        System.out.println("goal = " + goal);

        String input = Console.readLine();
        validation(input);
    }

    public static void validation(String input){
        String pattern = "^[1-9]*$";

        boolean regex = Pattern.matches(pattern, input);
        boolean length = input.length() == 3;

        if (!regex && !length) throw new IllegalArgumentException();
    }

    public static void strike(String goal, String input){
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(3);

    }

}