package baseball.players;

import java.util.List;

/**
 * description: Player를 나타내는 클래스
 */
public class Player {
    /**
     * description: Player의 숫자들을 저장하는 리스트
     */
    protected List<Integer> numbers;

    /**
     * description: Player의 숫자들을 저장하는 리스트를 설정하는 메소드
     *
     * @param numbers Player의 숫자들을 저장하는 리스트
     */
    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * description: Player의 숫자들을 저장하는 리스트에서 index에 해당하는 숫자를 반환하는 메소드
     *
     * @param index Player의 숫자들을 저장하는 리스트에서 가져 올 숫자의 index
     * @return Player의 숫자들을 저장하는 리스트에서 index에 해당하는 숫자
     */
    public int getNumber(int index) {
        return this.numbers.get(index);
    }
}
