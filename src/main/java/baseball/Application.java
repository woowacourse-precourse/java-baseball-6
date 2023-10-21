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
            List<Integer> computer = new ArrayList<>();
            List<Integer> user = new ArrayList<>();

            while(computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1,9);
                if(!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while(true) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();

                if(!checkIsNumber(userInput)
                        || checkIsDuplicated(userInput)
                        || !checkInputLength(userInput)
                        || checkIsZero(userInput)) {
                    throw new IllegalArgumentException();
                }

                user = makeUserNumberList(userInput);
                int strikeCount = checkStrike(user, computer);
                int ballCount = checkBall(user, computer);

                if(strikeCount == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int endGame = Integer.parseInt(Console.readLine());

                    if(endGame == 1) {
                        break;
                    } else if (endGame == 2) {
                        return;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }
    }

    public static boolean checkIsNumber(String userInput) {
        for(int i = 0; i < userInput.length(); i++) {
            char digitChar = userInput.charAt(i);
            if(!Character.isDigit(digitChar)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIsDuplicated(String userInput) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < userInput.length(); i++) {
            if(!set.add(userInput.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkInputLength(String userInput) {
        if(userInput.length() != 3) {
            return false;
        }
        return true;
    }

    public static boolean checkIsZero(String userInput) {
        if(userInput.contains("0")) {
            return true;
        }
        return false;
    }

    public static List<Integer> makeUserNumberList(String userInput) {
        List<Integer> user = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            user.add(Character.getNumericValue(c));
        }
        return user;
    }

    public static int checkStrike(List<Integer> user, List<Integer> computer) {
        int strikeCount = 0;
        for(int i=0; i<3; i++) {
            if(user.get(i).equals(computer.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public static int checkBall(List<Integer> user, List<Integer> computer) {
        int ballCount = 0;
        for(int i=0; i<3; i++) {
            if(computer.contains(user.get(i)) && !user.get(i).equals(computer.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

}

