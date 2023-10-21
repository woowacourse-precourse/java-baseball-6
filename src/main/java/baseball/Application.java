package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean endToggle = true;

        final int numOfNumbers = 3;

        System.out.println("숫자 야구 게임을 시작합니다.");

        ComputerNumbers computerNumbers = new ComputerNumbers();
        RandomPickNumberService randomPickNumbers = new RandomPickNumberService(computerNumbers);

        PlayerNumbers playerNumbers = new PlayerNumbers();
        ReadPlayerNumberService readPlayerNumberService = new ReadPlayerNumberService(playerNumbers);

        CheckBallStrikeCount checkBallStrikeCount = new CheckBallStrikeCount(computerNumbers, playerNumbers);
        ResultOfGame resultOfGame = new ResultOfGame();

        PrintResultOfThisGame printResultOfThisGame = new PrintResultOfThisGame(resultOfGame);

        while (endToggle) {
            randomPickNumbers.randomPick(numOfNumbers);
            readPlayerNumberService.readPlayerNumber(numOfNumbers);

            resultOfGame.initResult(numOfNumbers);

            checkBallStrikeCount.checkBallCount(resultOfGame);
            checkBallStrikeCount.checkStrikeCount(resultOfGame);

            System.out.println(computerNumbers.getList());
            System.out.println(playerNumbers.getList());
            System.out.println(resultOfGame.getList());

            printResultOfThisGame.getResultOfThisGame();

            if (printResultOfThisGame.isThreeStrike()) {
                endToggle = false;
            }

            playerNumbers.deleteAll();
            resultOfGame.deleteAll();
        }
    }


}
