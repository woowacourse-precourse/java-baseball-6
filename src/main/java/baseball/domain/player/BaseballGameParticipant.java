package baseball.domain.player;

import baseball.domain.game.RetryAnswer;
import baseball.util.GameConsole;
import baseball.util.PatternHelper;

/**
 * 숫자 야구 게임에 참여하는 플레이어에 대한 개념 객체를 나타내는 클래스입니다.
 */
public class BaseballGameParticipant implements BaseballPlayer {
        /**
         * 플레이어의 입력을 받기 위한 GameConsole util 객체입니다.
         */
        private final GameConsole gameConsole;

        /**
         * BaseballGameParticipant 객체를 생성하는 생성자입니다.
         *
         * @param gameConsole 플레이어가 사용할 GameConsole
         */
        public BaseballGameParticipant(GameConsole gameConsole) {
                this.gameConsole = gameConsole;
        }

        /**
         * 플레이어가 입력한 숫자열을 문자열 타입으로 반환합니다.
         *
         * @param limitLength 숫자열의 제한 길이
         * @return 플레이어가 입력한 숫자열
         */
        @Override
        public String provideLimitedNumber(int limitLength) {
                return inputNumber(limitLength);
        }

        /**
         * 플레이어가 console 에 숫자열을 입력하고, 입력 규칙에 대한 유효성 검사 실시 후 반환합니다.
         *
         * @param limitLength
         * @return 플레이어가 입력한 숫자열
         * @throws IllegalArgumentException - 입력한 숫자열이 서로 다른 숫자로 구성되지 않거나, 길이가 limitLength 를 초과한 경우
         */
        private String inputNumber(int limitLength) {
                System.out.print("숫자를 입력해주세요 : ");
                String strNumber = gameConsole.readInput();
                validation(strNumber, limitLength);
                return strNumber;
        }

        /**
         * 플레이어가 입력한 숫자열에 대한 유효성 검사를 실시합니다.
         *
         * @param input       플레이어가 입력한 숫자열
         * @param limitLength 숫자열의 제한 길이
         * @throws IllegalArgumentException - 입력한 숫자열이 서로 다른 숫자로 구성되지 않거나, 길이가 limitLength 를 초과한 경우
         */
        private void validation(String input, int limitLength) {
                String pattern = PatternHelper.getDistinctDigitNumberPattern(limitLength);

                if (!input.matches(pattern)) {
                        throw new IllegalArgumentException(limitLength + "자리의 서로 다른 숫자만 입력할 수 있습니다.");
                }
        }

        /**
         * 플레이어의 재시작 여부를 입력 받고, 1의 경우 재시작을 2의 경우 종료를 반환합니다.
         *
         * @return 1을 입력한 경우 YES 2를 입력한 경우 NO
         */
        @Override
        public RetryAnswer responseRetryPlay() {
                String response = gameConsole.readInput();

                if (!response.equals("1") && !response.equals("2")) {
                        throw new IllegalArgumentException("입력이 잘못되었습니다.");
                }

                if (response.equals("2")) {
                        return RetryAnswer.NO;
                }

                return RetryAnswer.YES;
        }
}
