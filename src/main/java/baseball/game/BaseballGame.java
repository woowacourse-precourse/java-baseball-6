package baseball.game;

import java.util.List;

public class BaseballGame {

    private static Computer computer;
    private static User user;

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        List<Integer> computerNumber = computer.createComputerNumber();
        List<Integer> userNumber = user.createUserNumber();

        List<Integer> comparedResult = computer.compareEachNumber(computerNumber, userNumber);
        String resultMessage = computer.createResultMessage(comparedResult);
        Boolean answerCorrect = computer.checkAnswer(resultMessage);
        computer.decideGameEndAndRestart();

//        public static void Game() {
//            while (true) {
//
//                    if (strike == 3) {
//                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//                        String restartOrExit = Console.readLine();
//                        validateRestartOrExitNumber(restartOrExit);
//                        if (restartOrExit.equals("1")) {
//                            break;
//                        } else if (restartOrExit.equals("2")) {
//                            return;
//                        }
//                    }
//                }
//            }
//        }
//
//        private static void validateRestartOrExitNumber(String restartOrExit) {
//            if (!restartOrExit.equals("1") && !restartOrExit.equals("2")) {
//                throw new IllegalArgumentException("게임 재시작 또는 종료 입력이 잘못되었습니다.");
//            }
//        }
//

    }
}
