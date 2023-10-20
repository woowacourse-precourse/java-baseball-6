package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");

            String userInput = Console.readLine();

            if(!checkIsNumber(userInput)
                    || checkIsDuplicated(userInput)
                    || !checkInputLength(userInput)
                    || checkIsZero(userInput)) {
                throw new IllegalArgumentException();
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int endGame = Integer.parseInt(Console.readLine());

            if(endGame == 1) {
                continue;
            } else if (endGame == 2) {
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static boolean checkIsNumber(String userInput) {
        System.out.println("1 = " + 1);
        for(int i = 0; i < userInput.length(); i++) {
            char digitChar = userInput.charAt(i);
            if(!Character.isDigit(digitChar)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIsDuplicated(String userInput) {
        System.out.println("2" );
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < userInput.length(); i++) {
            if(!set.add(userInput.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkInputLength(String userInput) {
        System.out.println("3" );
        if(userInput.length() != 3) {
            return false;
        }
        return true;
    }

    public static boolean checkIsZero(String userInput) {
        System.out.println("4" );
        if(userInput.contains("0")) {
            return true;
        }
        return false;
    }
}

