package baseball.util;

import camp.nextstep.edu.missionutils.Console;

/**
 * GameConsole 의 구현 클래스입니다.
 */
public class GameConsoleReader implements GameConsole {

        /**
         * 사용자가 console 에 입력한 문자열을 반환합니다.
         * 사용자의 입력은 자바의 Scanner 객체를 사용합니다.
         *
         * @return console 에 입력한 문자열
         */
        @Override
        public String readInput() {
                return Console.readLine();
        }
}
