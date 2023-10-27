package baseball.domain;

import baseball.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer extends DefaultData {

    /**
     * 한 게임에서 사용될 컴퓨터 역할의 객체
     * @see DefaultData
     */
    public Computer() {
        super();
        setNumberList(generateComputerNumber());
    }

    /**
     * 진행 게임의 기준값이 될 서로 다른 숫자 3개의 리스트를 생성하여 반환합니다.
     * @return RandomNumber List
     * @see RandomNumberGenerator
     */
    private List<Integer> generateComputerNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < MAX_LENGTH) {
            int randomNumber = RandomNumberGenerator.generate();
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

    /**
     * 사용자(Pitch)와 비교한 후, Strike 의 갯수를 연산하여 반환합니다.
     * @param userNumber 사용자가 입력한 숫자 List
     * @return Strike 갯수
     * @see baseball.application.GameLauncher#judge(Pitch)
     */
    public int countStrike(List<Integer> userNumber) {
        int strikeCount = 0;
        for (int index = 0; index < MAX_LENGTH; index++) {
            if (Objects.equals(userNumber.get(index), numberList.get(index))) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    /**
     * 사용자(Pitch)와 비교한 후, Ball 의 갯수를 연산하여 반환합니다.
     * @param userNumber - 사용자가 입력한 숫자 List
     * @return Ball 갯수
     * @see baseball.application.GameLauncher#judge(Pitch)
     */
    public int countBall(List<Integer> userNumber) {
        int ballCount = 0;
        for (Integer number : userNumber) {
            if (numberList.contains(number)) {
                ballCount += 1;
            }
        }
        return ballCount - countStrike(userNumber);
    }

}
