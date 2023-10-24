package baseball.domain.game;

/**
 * 게임의 핵심 로직을 정의한 인터페이스입니다.
 */
public interface Game {
        /**
         * @implSpec
         * 이 메서드는 게임을 시작합니다.
         */
        void start();

        /**
         * @implSpec
         * 이 메서드는 게임의 재시작 여부를 결정합니다.
         */
        void askRetry();

        /**
         * @implSpec
         * 이 메서드는 게임을 종료합니다.
         */
        void finish();
}
