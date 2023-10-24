package baseball.players;

/**
 * description: 컴퓨터를 나타내는 클래스
 */
public class Computer extends Player {
    /**
     * description: numbers에 해당 숫자가 있는지 확인하는 메소드
     *
     * @param number numbers에 해당 숫자가 있는지 확인할 숫자
     * @return numbers에 해당 숫자가 있으면 true, 없으면 false
     */
    public boolean isContain(int number) {
        return this.numbers.contains(number);
    }
}
