package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    // 문자열에 중복되는 문자가 존재하는지 확인하는 함수
    public static boolean isDuplicating(String str) {
        char ch;

        // 중복되는 문자가 존재하면 true 리턴
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if(str.indexOf(ch) != i) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // 맞춘 횟수, 게임이 진행될 라운드 수
        int numOfWin = 0, round = 3;

        String continueValue;
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            // 컴퓨터가 랜덤으로 생성할 값들을 담는 integer 배열
            List<String> computer = new ArrayList<>();

            // 랜덤으로 round 만큼의 값을 받아서 배열에 받는다.
            while (computer.size() < round) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(String.valueOf(randomNumber));
                    System.out.println(randomNumber);
                }
            }

            // 결과 값이 담길 int array(win, lose)
            int[] result = {0, 0};

            do {
                System.out.print("숫자를 입력해주세요 : ");

                String input = Console.readLine();
                // 잘못된 값이 입력되었을 경우 Exception
                if (!Pattern.matches("^[1-9]{" + String.valueOf(round) + "}$", input) || isDuplicating(input))
                    throw (new IllegalArgumentException());

                // computer list 순회
                for (int i = 0; i < round; i++) {
                    int index = input.indexOf(computer.get(i));

                    if (index > -1) {
                            if (i == index) {
                                ++result[1];
                            } else {
                                ++result[0];
                            }
                        }
                    }

                if (result[0] > 0) {
                    System.out.print(String.valueOf(result[1]) + "볼 ");
                }
                if (result[1] > 0) {
                    System.out.print(String.valueOf(result[1]) + "스트라이크");
                }
                if (result[0] + result[1] == 0) {
                    System.out.print("낫싱");
                }
                System.out.println();
            } while(result[1] < 3);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            continueValue = Console.readLine();
            // 잘못된 값이 입력되었을 경우 Exception
            if (!Pattern.matches("^[1-2]$", continueValue))
                throw (new IllegalArgumentException());
        } while (continueValue.equals("1"));
    }
}