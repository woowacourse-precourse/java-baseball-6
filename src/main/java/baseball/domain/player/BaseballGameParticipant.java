package baseball.domain.player;

import baseball.domain.game.ContinueAnswer;
import baseball.util.GameConsole;

public class BaseballGameParticipant implements BaseballPlayer {
        private final GameConsole gameConsole;

        public BaseballGameParticipant(GameConsole gameConsole) {
                this.gameConsole = gameConsole;
        }

        private String inputNumber(int limitLength) {
                System.out.print("숫자를 입력해주세요 : ");
                String strNumber = gameConsole.readInput();
                validation(strNumber, limitLength);
                return strNumber;
        }

        private void validation(String input, int limitLength) {
                if (!input.matches("^(?!.*(.).*\\1)\\d{" + limitLength + "}$")) {
                        throw new IllegalArgumentException("3자리의 서로 다른 숫자만 입력할 수 있습니다.");
                }
        }

        @Override
        public String submitThreeNumber(int limitLength) {
                return inputNumber(limitLength);
        }

        @Override
        public ContinueAnswer responseContinuePlay() {
                String response = gameConsole.readInput();

                if (!response.equals("1") && !response.equals("2")) {
                        throw new IllegalArgumentException("입력이 잘못되었습니다.");
                }

                if (response.equals("2")) {
                        return ContinueAnswer.NO;
                }

                return ContinueAnswer.YES;
        }
}
