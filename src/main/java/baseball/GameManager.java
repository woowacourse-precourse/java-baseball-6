package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    public void run() {

        boolean isWon = doGameAndGetGameResult();

        if (isWon) {
            if(askReplayGame()){
                run();
            }
        }

    }

    private boolean doGameAndGetGameResult() {

        printGameStartMessage();

        Game game = new Game();

        while (true) {
            boolean gameResult = getGameResult(game, userInputReceive());
            System.out.println();
            if (gameResult){
                printPlayerWinMessage();

                break;
            }
        }

        return true;
    }

    public boolean askReplayGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int parsedInt = Utils.parseIntWithTypeCheck(Console.readLine());

        if (parsedInt >= 3 || parsedInt < 1){
            throw new IllegalArgumentException();
        }

        return parsedInt == 1;
    }

    private void printPlayerWinMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean getGameResult(Game game, int userInput) {

        if (game.isNothing(userInput)) {
            System.out.println("낫싱");
            return false;
        }

        int ballCount = game.getBallCount(userInput);
        int strikeCount = game.getStrikeCount(userInput);

        printBallResult(ballCount, strikeCount);
        printStrikeCount(strikeCount);

        return strikeCount == 3;
    }

    private void printStrikeCount(int strikeCount) {

        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");
        }
    }

    private void printBallResult(int ballCount, int strikeCount) {

        if (ballCount != 0) {
            if (strikeCount != 0) {
                System.out.print(ballCount + "볼 ");
                return;
            }
            System.out.print(ballCount + "볼");
        }
    }

    private int userInputReceive() {
        printInputDemandMessage();

        return rawInputToCheckedInput(Console.readLine());
    }

    private int rawInputToCheckedInput(String rawInput) {

        int parsedInt = Utils.parseIntWithTypeCheck(rawInput);

        if (!(parsedInt >= 100) || !(parsedInt <= 999)) {
                throw new IllegalArgumentException();
            }


        return parsedInt;
    }



    private void printInputDemandMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}
