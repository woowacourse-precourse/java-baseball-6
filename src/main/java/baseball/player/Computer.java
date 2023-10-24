package baseball.player;

import baseball.util.generator.RandomGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 컴퓨터 플레이어의 역할을 하는 클래스입니다.
 * 랜덤 숫자를 생성하여 게임에서 사용합니다.
 */
public class Computer {
    private final RandomGenerator randomGenerator;
    private final List<Integer> randomList;

    /**
     * 컴퓨터 객체 생성 및 초기 랜덤 숫자를 설정합니다.
     * @param randomGenerator 랜덤 숫자를 생성하는 객체
     */
    public Computer(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.randomList = new ArrayList<>();
        insertRandomNumbers();
    }

    /**
     * 지정된 인덱스에 있는 숫자를 반환합니다.
     * @param index 리스트의 인덱스
     * @return 인덱스에 위치한 숫자
     */
    public int getNumberAt(int index) {
        return randomList.get(index);
    }

    /**
     * 특정 숫자가 리스트에 존재하는지 확인합니다.
     * @param number 확인할 숫자
     * @return 숫자 존재 여부
     */
    public boolean containsNumber(int number) {
        return randomList.contains(number);
    }

    /**
     * 랜덤 숫자 리스트를 초기화합니다. 게임을 새로 시작할 때 사용합니다.
     */
    public void clearAndInitialize() {
        randomList.clear();
        insertRandomNumbers();
    }

    // 랜덤 숫자를 리스트에 삽입합니다. 중복되지 않게 3개의 숫자를 설정합니다.
    private void insertRandomNumbers() {
        while (randomList.size() < 3) {
            int randomNumber = randomGenerator.pickNumberInRange(1, 9);
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }
    }
}
