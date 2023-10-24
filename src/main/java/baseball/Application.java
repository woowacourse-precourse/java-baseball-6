package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import  camp.nextstep.edu.missionutils.Randoms;
import  camp.nextstep.edu.missionutils.Console;



public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        rootGame :
        while (true) {

            // 1. 컴퓨터가 임의의 서로 다른 3자리의 수 생성
            List<Integer> answerNumberList = getAnswerNumberList();

            currentGame :
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");

                // 2. 유저로 부터 3자리의 서로 다른 숫자 입력 받음
                String inputNumberStr = Console.readLine();

                // 3. 입력 값 검증, 잘못된 값일 시 IllegalArgumentException 발생
                List<Integer> inputNumberList = assertValidNumber(inputNumberStr);

                // 4. 정답과 비교 후 결과 출력, 반복
                // 4-1) 스트라이크, 볼 수 세기
                StrikeBallCount strikeBallCount = getStrikeBallCount(inputNumberList, answerNumberList);

                // 4-2) 정답(3 스트라이크)인지 체크
                if (checkAnswer(strikeBallCount.strike(), strikeBallCount.ball())) {

                    // 5. 정답일 시, 입력값(1 or 2) 에 따라 따라 재시작 혹은 종료
                    while (true) {
                        String inputRestart = Console.readLine();

                        // 5-1) 입력값(1 or 2) 검증
                        if (Objects.equals(inputRestart, "1")) {
                            break currentGame;
                        }
                        if (Objects.equals(inputRestart, "2")) {
                            break rootGame;
                        }
                        System.out.println("1혹은 2를 입력해 주세요.");
                    }
                }

            }

        }

    }


    /**
     * 1. 컴퓨터가 임의의 서로 다른 3자리의 수 생성 /
     */
    private static List<Integer> getAnswerNumberList() {
        List<Integer> answerNumberList = new ArrayList<>();
        while (answerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberList.contains(randomNumber)) {
                answerNumberList.add(randomNumber);
            }
        }
        return answerNumberList;
    }


    /**
     * 3. 입력 값 검증, 잘못된 값일 시 IllegalArgumentException 발생
     * 3-1) 3자리가 맞는지 확인
     * 3-2) 숫자가 맞는지 확인
     * 3-3) 그 3자리 숫자가 서로 다른지 확인
     */
    static List<Integer> assertValidNumber(String inputNumberStr) {

        // 3-1) 3자리가 맞는지 확인
        if (inputNumberStr.length() != 3) {
            throw new IllegalArgumentException("입력값 오류! 3자리 숫자를 입력해 주세요.");
        }

        // 3-2) 숫자가 맞는지 확인
        try {
            Integer.parseInt(inputNumberStr);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("입력값 오류! 숫자만 입력해 주세요.");
        }

        List<Integer> returnIntList = new ArrayList<>();
        for (int i = 0; i < inputNumberStr.length() ; i++) {
            
            // 3-3) 숫자에 0이 포함 되어 있는지 확인
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

    /**
     * 4-1) 스트라이크, 볼 수 세기
     */
    private static StrikeBallCount getStrikeBallCount(List<Integer> inputNumberList, List<Integer> answerNumberList) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i< inputNumberList.size(); i++) {
            if (answerNumberList.contains(inputNumberList.get(i))) {
                if (Objects.equals(answerNumberList.get(i), inputNumberList.get(i))) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        return new StrikeBallCount(strike, ball);
    }
    private record StrikeBallCount(int strike, int ball) { }

    /**
     * 4-2) 정답(3 스트라이크)인지 체크
     */
    private static boolean checkAnswer(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        }

        if (strike == 0) {
            System.out.println(ball + "볼");
            return false;
        }

        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }

        if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return false;
        }

        System.out.println(ball + "볼 " + strike + "스트라이크");
        return false;
    }
}
