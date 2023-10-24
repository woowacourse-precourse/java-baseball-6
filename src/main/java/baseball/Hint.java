package baseball;

import java.util.List;

public class Hint {

    private int strikeCount;
    private int ballCount;

    /** compareNumber : 컴퓨터가 선택한 숫자와 사용자가 입력한 숫자 간의 비교
     *  같은 수가 같은 자리에 있을 경우(스트라이크)
     *  같은 수가 다른 자리에 있을 경우(볼)
     *  같은 수가 전혀 없을 경우(낫싱)
     */
    public void compareNumber(List<Integer> computerNumbers, List<Integer> userNumbers) {

        reset();

        for (int i = 0; i < computerNumbers.size(); i++) {

            if (computerNumbers.get(i).equals(userNumbers.get(i))) {

                strikeCount++;

            } else {

                if (computerNumbers.contains(userNumbers.get(i))) {

                    ballCount++;

                }
            }
        }

        printHint(strikeCount, ballCount);
    }

    // 모든 힌트를 초기화
    public void reset() {

        strikeCount = 0;
        ballCount = 0;

    }

    // 3스트라이크인지 확인
    public boolean isThreeStrike() {

        return strikeCount == 3;
    }

    // 힌트 출력
    private void printHint(int strikeCount, int ballCount) {

        if (strikeCount != 0 && ballCount != 0) {

            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");

        } else {

            if (strikeCount != 0) {

                System.out.println(strikeCount + "스트라이크");

            } else if (ballCount != 0) {

                System.out.println(ballCount + "볼");

            } else {

                System.out.println("낫싱");

            }
        }
    }
}
