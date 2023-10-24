package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;
public class InputView {
    private static final int NUM_LENGTH = 3;
    public static String inputUserNum() {
        String input;
        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();
        lengthChecker(input);
        duplicatedChecker(input);
        intChecker(input);
        return input;
    }

    public static String inputRetryNum() {
        String input;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = Console.readLine();
        retryNumChecker(input);
        return input;
    }

    public static void lengthChecker(String input) throws IllegalArgumentException {
        if(input.length() != NUM_LENGTH){
            throw new IllegalArgumentException("잘못된 입력 : 3자리 자연수가 아닙니다.");
        }
    }

    public static void duplicatedChecker(String input) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();
        for(char c : input.toCharArray()){
            if(!set.add(c)){
                throw new IllegalArgumentException("잘못된 입력 : 숫자가 중복되었습니다.");
            }
        }
    }

    public static void intChecker(String input) throws IllegalArgumentException {
        for(char c : input.toCharArray()){
            if((c - '0') > 9 || (c - '0') < 1) {
                throw new IllegalArgumentException("잘못된 입력 : 숫자가 아닌 것을 입력했습니다.");
            }
        }
    }

    public static void retryNumChecker(String input) throws IllegalArgumentException {
        if(!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("잘못된 입력 : 1 또는 2가 아닌 숫자를 입력했습니다.");
        }
    }
}
