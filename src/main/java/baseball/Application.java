package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작 합니다.");

        rootGame :
        while (true) {

            List<Integer> answerNumberList = getAnswerNumberList();

            currentGame :
            while (true) {
                System.out.print("숫자를 입력해 주세요 : ");
                String inputNumberStr = Console.readLine();

                List<Integer> inputNumberList = assertValidNumber(inputNumberStr);

                StrikeBallCount strikeBallCount = getStrikeBallCount(inputNumberList, answerNumberList);

                if (checkAnswer(strikeBallCount.strike(), strikeBallCount.ball())) {
                    while (true) {
                        String inputRestart = Console.readLine();
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
     * 임의의 수 3자리를 랜덤으로 생성 해서 반환
     * 각 자리의 숫자는 1부터 9까지 이고, 중복된 숫자는 존재 하지 않음
     *
     * @return 서로 다른 3자리 숫자를 가진 리스트
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
     * 입력 값이 3자리의 서로 다른 숫자가 맞는지 검증
     * 1) 3자리가 맞는지 확인
     * 2) 숫자가 맞는지 확인
     * 3) 숫자에 0이 포함 되어 있는지 확인
     * 4) 중복된 숫자가 있는지 확인
     *
     * @throws IllegalArgumentException 위 4개의 조건 중 하나 라도 통과 하지 못했을 시
     * @param inputNumberStr 사용자 입력 값
     * @return 사용자 입력 값으로 만든 서로 다른 3자리 숫자를 가진 리스트
     */
    private static List<Integer> assertValidNumber(String inputNumberStr) {

        // 1) 3자리가 맞는지 확인
        if (inputNumberStr.length() != 3) {
            throw new IllegalArgumentException("입력값 오류! 3자리 숫자를 입력해 주세요.");
        }

        // 2) 숫자가 맞는지 확인
        try {
            Integer.parseInt(inputNumberStr);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("입력값 오류! 숫자만 입력해 주세요.");
        }

        List<Integer> returnIntList = new ArrayList<>();
        for (int i = 0; i < inputNumberStr.length() ; i++) {

            // 3) 숫자에 0이 포함 되어 있는지 확인
            if (inputNumberStr.charAt(i) == '0') {
                throw new IllegalArgumentException("입력값 오류! 숫자에 0을 포함 시킬 수 없습니다.");
            }

            int digitInt = inputNumberStr.charAt(i) - 48;
            // 4) 중복된 숫자가 있는지 확인
            if (returnIntList.contains(digitInt)) {
                throw new IllegalArgumentException("입력값 오류! 서로 다른 3자리 숫자를 입력해 주세요.");
            }
            returnIntList.add(digitInt);
        }
        return returnIntList;
    }


    /**
     * 정답 숫자 리스트와 사용자 입력 값 숫자 리스트를 비교 하여 strike, ball 갯수 연산
     *
     * @param inputNumberList 입력값 숫자 리스트
     * @param answerNumberList 정답 숫자 리스트
     * @return StrikeBallCount(strike, ball) strike, ball 갯수
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
    private record StrikeBallCount(int strike, int ball) {} // 4.1.3 Empty blocks: may be concise


    /**
     * strike, ball 갯수에 따라서 결과값 출력
     * 정답 여부 확인
     *
     * @param strike
     * @param ball
     * @return 정답 여부 (3스트라이크 여부)
     */
    private static boolean checkAnswer(int strike, int ball) {
        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        }

        if (strike == 0) {
            System.out.println(ball + "볼");
            return false;
        }

        if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return false;
        }

        System.out.println(ball + "볼 " + strike + "스트라이크");
        return false;
    }
}
