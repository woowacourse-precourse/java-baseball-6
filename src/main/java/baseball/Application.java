package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static boolean checkNumCorrect(String strValue) {
        //길이가 3이 아닌 경우 여부
        if (strValue.length() != 3)
            return false;
        //같은 숫자 반복 여부
        else if (strValue.charAt(0) == strValue.charAt(1) || strValue.charAt(0) == strValue.charAt(2) || strValue.charAt(1) == strValue.charAt(2))
            return false;

        //정수가 아닌 다른 것이 입력된 경우 여부
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static int[] makeArray() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        if (!checkNumCorrect(userInput)) {
            throw new IllegalArgumentException();
        }

        //입력값 배열에 담음
        int[] userDigits = new int[userInput.length()];
        for (int i = 0; i < userInput.length(); i++) {
            userDigits[i] = userInput.charAt(i) - '0';    //char형의 숫자에서 '0'의 아스키코드 값 빼서 숫자로 변환
        }

        return userDigits;
    }

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        //게임 계속 실행
        while (true) {

            //컴퓨터 수 생성
            List<Integer> computerDigits = new ArrayList<>();
            while (computerDigits.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerDigits.contains(randomNumber)) {
                    computerDigits.add(randomNumber);
                }
            }

            while (true) {
                //유저의 수 입력
                int[] userDigits = makeArray();

                int strike = 0;
                int ball = 0;
                //비교 반복문
                for (int userIndex = 0; userIndex < 3; userIndex++) {
                    for (int comIndex = 0; comIndex < 3; comIndex++) {
                        if (userDigits[userIndex] == computerDigits.get(comIndex)) {
                            if (userIndex == comIndex)
                                strike += 1;
                            else
                                ball += 1;
                        }
                    }
                }

                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }


            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String choice = Console.readLine();
            if (choice.equals("2")) {
                break;
            }

        }
    }
}
