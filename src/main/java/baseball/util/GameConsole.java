package baseball.util;

/**
 * Game console 의 제공 로직을 정의한 인터페이스입니다.
 */
public interface GameConsole {
        /**
         * @implSpec 사용자가 console 에 입력한 문자열을 반환합니다.
         *
         * @return console 에 입력한 문자열 반환
         */
        String readInput();
}
