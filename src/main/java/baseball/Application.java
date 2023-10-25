package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean endToggle = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        ComputerNumbers computerNumbers = new ComputerNumbers();
        RandomPickNumberService randomPickNumbers = new RandomPickNumberService(computerNumbers);

        PlayerNumbers playerNumbers = new PlayerNumbers();
        ReadPlayerNumberService readPlayerNumberService = new ReadPlayerNumberService(playerNumbers);

        CheckBallStrikeCount checkBallStrikeCount = new CheckBallStrikeCount(computerNumbers, playerNumbers);
        ResultOfGame resultOfGame = new ResultOfGame();

        PrintResultOfThisGame printResultOfThisGame = new PrintResultOfThisGame(resultOfGame);

        ReadContinueOrStop readContinueOrStop = new ReadContinueOrStop();

        while (endToggle) {
            randomPickNumbers.randomPick();
            readPlayerNumberService.readPlayerNumber();

            resultOfGame.initResult();

            checkBallStrikeCount.checkBallCount(resultOfGame);
            checkBallStrikeCount.checkStrikeCount(resultOfGame);

            printResultOfThisGame.getResultOfThisGame();

            if (printResultOfThisGame.isThreeStrike()) {
                int readContinue = readContinueOrStop.readContinueOrStop();
                if (readContinue == 1) {
                    computerNumbers.deleteAll();
                } else if (readContinue == 2) {
                    endToggle = false;
                }
            }

            playerNumbers.deleteAll();
            resultOfGame.deleteAll();
            printResultOfThisGame.deleteData();
        }
    }


}
