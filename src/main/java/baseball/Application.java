package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import  camp.nextstep.edu.missionutils.Randoms;
import  camp.nextstep.edu.missionutils.Console;
import org.mockito.ArgumentMatchers;

import static org.mockito.ArgumentMatchers.anyInt;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        rootGame :
        while (true) {

            // TODO - 임의의 서로 다른 3자리의 수 생성
            List<Integer> answerNumberList = new ArrayList<>();
            while (answerNumberList.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!answerNumberList.contains(randomNumber)) {
                    answerNumberList.add(randomNumber);
                }
            }

            currentGame :
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNumberStr = Console.readLine();

                // TODO - 입력 값이 서로 다른 3자리의 수인지 확인, 아니면 IllegalArgumentException 발생
                List<Integer> inputNumberList = assertValidNumber(inputNumberStr);

                // TODO - 정답과 비교 후 결과 출력
                int strike = 0;
                int ball = 0;
                for (int i=0; i<inputNumberList.size(); i++) {
                    if (answerNumberList.contains(inputNumberList.get(i))) {
                        if (answerNumberList.get(i) == inputNumberList.get(i)) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }

                // TODO - 아니면 계속 반복, 맞으면 게임 종료 후 재시작 여부 입력 받음
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                    continue;
                }

                if (strike == 0) {
                    System.out.println(ball + "볼");
                    continue;
                }

                if (strike == 3) {
                    System.out.println(strike + "스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    while (true) {
                        String inputRestart = Console.readLine();
                        if (Objects.equals(inputRestart, "1")) {
                            break currentGame;
                        }
                        if (Objects.equals(inputRestart, "2")) {
                            break rootGame;
                        }
                        System.out.println("1혹은 2를 입력해주세요.");
                    }

                }

                if (ball == 0) {
                    System.out.println(strike + "스트라이크");
                    continue;
                }

                System.out.println(ball + "볼 " + strike + "스트라이크");
                // TODO - 재시작 여부에 따라 재시작 혹은 종료
            }
        }

    }


    /**
     * TODO - 입력 받은 숫자가 서로 다른 3자리 숫자 인지 확인
     * 1. 3자리가 맞는지
     * 2. 숫자가 맞는지
     * 3. 그 3자리 숫자가 서로 다른지
     * 이걸 간단히 알 수 있는 순서로 실행
     */
    static List<Integer> assertValidNumber(String inputNumberStr) {

        // 1. 3자리가 맞는지
        if (inputNumberStr.length() != 3) {
            throw new IllegalArgumentException("입력값 오류! 3자리 숫자를 입력해 주세요.");
        }

        // 2. 숫자가 맞는지
        try {
            Integer.parseInt(inputNumberStr);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("입력값 오류! 숫자만 입력해 주세요.");
        }

        List<Integer> returnIntList = new ArrayList<>();
        for (int i = 0; i < inputNumberStr.length() ; i++) {
            
            // 3. 숫자에 0이 포함 되어 있는지
            if (inputNumberStr.charAt(i) == '0') {
                throw new IllegalArgumentException("입력값 오류! 숫자에 0을 포함 시킬 수 없습니다.");
            }
            int digitInt = inputNumberStr.charAt(i) - 48;
            if (returnIntList.contains(digitInt)) {
                throw new IllegalArgumentException("입력값 오류! 서로 다른 3자리 숫자를 입력해 주세요.");
            }
            returnIntList.add(digitInt);
        }
        return returnIntList;
    }
}
