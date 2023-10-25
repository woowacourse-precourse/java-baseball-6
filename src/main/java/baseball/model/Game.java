package baseball.model;

import java.util.List;

/**
 * 야구 게임의 주요 로직과 동작을 관리하는 클래스입니다.
 *
 * <p>게임은 {@link Computer}의 숫자와 {@link BallCounter}를 통한 스트라이크 및 볼의 계산을 관리합니다.</p>
 */
public class Game {

    private final Computer computer;
    private final BallCounter ballCounter;

    private Game(Builder builder) {
        this.computer = builder.computer;
        this.ballCounter = builder.ballCounter;
    }

    /**
     * {@link Game} 객체의 빌더 클래스입니다.
     */
    public static class Builder {
        private Computer computer;
        private BallCounter ballCounter;

        /**
         * 빌더에 컴퓨터 객체를 설정합니다.
         *
         * @param computer 컴퓨터 객체
         * @return 현재 빌더 인스턴스
         */
        public Builder computer(Computer computer) {
            this.computer = computer;
            return this;
        }

        /**
         * 빌더에 볼 카운터 객체를 설정합니다.
         *
         * @param ballCounter 볼 카운터 객체
         * @return 현재 빌더 인스턴스
         */
        public Builder ballCounter(BallCounter ballCounter) {
            this.ballCounter = ballCounter;
            return this;
        }

        /**
         * 설정된 정보를 바탕으로 {@link Game} 객체를 생성합니다.
         *
         * @return 새로운 {@link Game} 인스턴스
         */
        public Game build() {
            return new Game(this);
        }
    }

    /**
     * 현재 게임에서 컴퓨터가 선택한 숫자 목록을 반환합니다.
     *
     * @return 선택된 숫자 목록
     */
    public List<Integer> getComputerSelectedNumbers() {
        return computer.getSelectedNumbers();
    }

    /**
     * 주어진 숫자 목록에 대한 스트라이크 개수를 반환합니다.
     *
     * @param computerNumbers 컴퓨터의 숫자 목록
     * @param userInput 사용자의 입력 숫자 목록
     * @return 스트라이크의 개수
     */
    public int countStrikes(List<Integer> computerNumbers, List<Integer> userInput) {
        return ballCounter.countStrikes(computerNumbers, userInput);
    }

    /**
     * 주어진 숫자 목록에 대한 볼의 개수를 반환합니다.
     *
     * @param computerNumbers 컴퓨터의 숫자 목록
     * @param userInput 사용자의 입력 숫자 목록
     * @return 볼의 개수
     */
    public int countBalls(List<Integer> computerNumbers, List<Integer> userInput) {
        return ballCounter.countBalls(computerNumbers, userInput);
    }

    /**
     * 게임의 컴퓨터 숫자를 주어진 새로운 숫자 목록으로 재설정합니다.
     *
     * @param newNumbers 새로운 숫자 목록
     */
    public void resetGame(List<Integer> newNumbers) {
        computer.resetNumbers(newNumbers);
    }
}
