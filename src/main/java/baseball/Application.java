package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.ArrayList;

public class Application {
    private static final boolean DEFAULT_STATE = false;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1. 세 자리 수 만들기

        /*
            # 하나의 수를 고르는 방법.
            pickNumberInRange(1,9) => 9 - 1 + 1 => 0~8 사이의 랜덤 수를 고름
            (0~8) + 1 => (1~9)
        */

        // computer : 랜덤으로 생성한 세 자리 수를 저장할 list
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1,9) + 1;
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        // 2. 숫자 야구 게임 진행하기
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 정답 여부를 확인하는 변수
        boolean isGameClear = DEFAULT_STATE;

        while(!isGameClear) {
            System.out.print("숫자를 입력해주세요 : ");

            /*
            TODO: 사용자 입력 예외처리
            - 1) 숫자입니까?
                yes : inputNumber에 문자열을 정수형으로 변환해서 넣기
            - 2) 3자리입니까?
                yes : player 배열에 자릿수 분해해서 하나씩 넣기
            - 3) 서로 다른 숫자로 이루어졌습니까?
                yes : 야구 게임 처리를 시작합니다!
            => 하나라도 NO 라면 IllegalArgumentException 예외를 발생시키자!
            */

            // 플레이어가 입력한 문자열
            String inputString = readLine();

            // 입력 예외처리 - 플레이어가 세 자리 서로 다른 숫자로 구성된 정수형 숫자를 입력했는지 확인
            if (!isNumber(inputString)) {
                throw new IllegalArgumentException();
            }
            else if (!isThreeDigitNumber(inputString)) {
                throw new IllegalArgumentException();
            }
            else if (!isDifferentDigits(inputString)) {
                throw new IllegalArgumentException();
            }

            int inputNumber = Integer.parseInt(inputString); // 입력 받은 세 자리 수
            int[] player = new int[3]; // 입력 받은 세 자리 수를 자릿수 별로 담는 array

            player[0] = inputNumber / 100;
            player[1] = (inputNumber - (inputNumber / 100) * 100) / 10;
            player[2] = inputNumber % 10;

            /*
                # 각 자릿수를 구하는 방법.
                백의 자릿수: inputNumber / 100;
                십의 자릿수: (inputNumber - (inputNumber / 100) * 100) / 10;
                일의 자릿수: inputNumber % 10;
            */

            // TODO: 스트라이크, 볼, 낫싱의 여부를 확인


        }


    }

    // 입력 받은 값이 정수형인지 판별하는 메소드
    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    // 입력 받은 값이 세 자리 수인지 판별하는 메소드
    public static boolean isThreeDigitNumber(String input) {
        int number = Integer.parseInt(input);
        if (number / 100 >= 1 && number / 1000 == 0) {
            return true;
        }
        return false;
    }

    // 입력 받은 값이 서로 다른 수로 구성되었는지 판별하는 메소드
    public static boolean isDifferentDigits(String input) {
        if (input.charAt(0) == input.charAt(1)
                || input.charAt(1) == input.charAt(2)
                || input.charAt(0) == input.charAt(2)) {
            return false;
        }
        return  true;
    }
}
