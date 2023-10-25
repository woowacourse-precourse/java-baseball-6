package baseball.util;

import baseball.dto.StrikeBallCount;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class InputCalculator {

    // 유저와 컴퓨터의 세자리 수를 비교
    public static StrikeBallCount compareComputerBallAndUserInput(int[] computerBall, List<Integer> userInput) {

        StrikeBallCount strikeBallCount = new StrikeBallCount();
        AtomicInteger index = new AtomicInteger(1);

        // 병렬 처리
        userInput.forEach(
                (input) -> compareComputerBallAndEachBall(computerBall, input, index.getAndIncrement(), strikeBallCount)
        );

        return strikeBallCount;
    }

    // 유저가 고른 하나의 숫자가 Strike인지 Ball인지 판단
    public static void compareComputerBallAndEachBall(int[] computerBall, int eachBall, int index,
                                                      StrikeBallCount strikeBallCount) {

        if (computerBall[eachBall] == index) {

            // 숫자, 자리 일치 시 Strike 값 증가
            strikeBallCount.increaseStrikeCount();

        } else if (computerBall[eachBall] != 0) {

            // 숫자만 일치 할 시 Ball 값 증가
            strikeBallCount.increaseBallCount();

        }

    }

}
