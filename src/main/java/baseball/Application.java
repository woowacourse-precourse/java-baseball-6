package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String isRestart = "1";
        while (isRestart.equals("1")) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            // 숫자 입력
            System.out.print("숫자를 입력해주세요 : ");
            String inputString = Console.readLine();
            if (inputString.length() != 3) {
                throw new IllegalArgumentException();
            }
            // int 변수 초기화: Integer.valueOf() 메서드를 사용하여 문자를 정수로 변환할 때, 아스키 코드 값이 아니라 실제 숫자를 얻고자 한다면 해당 문자에 - '0'을 빼야 한다.
            int first = Integer.valueOf(inputString.charAt(0) - '0');   // 문자를 정수로 변환
            int second = Integer.valueOf(inputString.charAt(1) - '0');
            int third = Integer.valueOf(inputString.charAt(2) - '0');
            if (first == second || first == third || second == third) {
                throw new IllegalArgumentException();
            }
            List<Integer> inputNum = new ArrayList<>();
            inputNum.add(first);
            inputNum.add(second);
            inputNum.add(third);
            System.out.println(inputNum);

            // 랜덤하게 서로 다른 3자리 숫자 생성
            List<Integer> createNum = new ArrayList<>();
            while (createNum.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!createNum.contains(randomNumber)) {
                    createNum.add(randomNumber);
                }
            }
            System.out.println(createNum);

            // 입력 숫자 생성 숫자 비교


            // 재게임 여부
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isRestart = Console.readLine();
            if ( !((isRestart.equals("1") || (isRestart.equals("2")))) ) {
                throw new IllegalArgumentException();
            }
        };

    }
}
