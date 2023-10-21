package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CONTINUE_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    public void run() {
        // 계임 Exit, Continue 변수
        boolean isGameContinue = true;

        while (isGameContinue) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            // 3스트라이크 여부 판별
            boolean isGameFinish = false;
            while (!isGameFinish) {
                System.out.print(INPUT_MESSAGE);
                String userInput = Console.readLine();
                if (userInput.length() != computer.size()) {
                    throw new IllegalArgumentException();
                }

                // 사용자 input 검증
                BaseBallResult checkResult = checkUserInput(userInput, computer);

                if (checkResult.isNothing()) {
                    System.out.println(NOTHING);
                } else {
                    if (checkResult.getBallCnt() != 0) {
                        System.out.print(checkResult.getBallCnt() + BALL);
                    }
                    if (checkResult.getStrikeCnt() != 0) {
                        if (checkResult.getBallCnt() != 0) {
                            System.out.print(" " + checkResult.getStrikeCnt() + STRIKE);
                        } else {
                            System.out.print(checkResult.getStrikeCnt() + STRIKE);
                        }

                    }
                    System.out.println();
                }
                if ((checkResult.getStrikeCnt() == 3)) {
                    isGameFinish = true;
                    System.out.println(END_MESSAGE);
                    while (true) {
                        System.out.println(CONTINUE_GAME_MESSAGE);
                        String userSelect = Console.readLine();
                        if (Integer.parseInt(userSelect) == 2) {
                            // 게임 종료
                            isGameContinue = false;
                            break;
                        } else if (Integer.parseInt(userSelect) == 1) {
                            break;
                        }
                        throw new IllegalArgumentException();
                    }

                }
            }
        }
    }

    /**
     * 사용자의 입력과 주어진 수를 비교하여 결과를 반환하는 메소드
     *
     * @param userInput      사용자의 입력
     * @param computerNumber 숫자야구의 주어진 수
     * @return 결과 객체
     */
    public BaseBallResult checkUserInput(String userInput, List<Integer> computerNumber) {
        int strikeCnt = 0;
        int ballCnt = 0;
        boolean isNothing = false;
        boolean[] isStrike = new boolean[userInput.length()];

        // 스트라이크 계산
        for (int i = 0; i < computerNumber.size(); ++i) {
            if (userInput.charAt(i) - '0' == computerNumber.get(i)) {
                isStrike[i] = true;
                ++strikeCnt;
            }
        }

        // 볼 계산
        for (int i = 0; i < computerNumber.size(); ++i) {
            if (isStrike[i]) {
                continue;
            }
            for (int j = 0; j < computerNumber.size(); ++j) {
                if (computerNumber.get(i) == userInput.charAt(j) - '0') {
                    ++ballCnt;
                }
            }
        }

        if (strikeCnt == 0 && ballCnt == 0) {
            isNothing = true;
        }
        return new BaseBallResult(strikeCnt, ballCnt, isNothing);
    }

}
