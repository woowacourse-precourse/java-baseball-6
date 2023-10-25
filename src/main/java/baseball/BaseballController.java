package baseball;

public class BaseballController {

    private BaseballException baseballException = new BaseballException();
    private BaseballView baseballView = new BaseballView();
    private BaseballService baseballService = new BaseballService();

    // 게임 시작 함수
    public void startBaseball() {
        int strike = 0;

        baseballView.printBaseballStart();
        String computer = baseballService.getComputerNum();

        // 3스트라이크가 될 때까지 반복
        while (strike<3) {
            strike = 0;
            String randomNum = baseballView.inputRandomNum();
            baseballService.verifyRandomInput(randomNum);
            strike = baseballService.getStrike(computer, randomNum);
            int ball = baseballService.getBall(computer, randomNum);
            baseballView.printStrikeOrBall(strike, ball);
        }

        // 3스트라이크인 경우, 게임 종료
        if (strike==3) {
            baseballView.printGameOver();
            String restart = baseballView.inputRestart();

            baseballException.isValidRestart(restart);

            if ("1".equals(restart)) {
                startBaseball();
            } else if("2".equals(restart)) {
                baseballView.printGameEnd();
            }
        }
    }

    public void compareNums(int strike, String computer){
        strike = 0;
        String randomNum = baseballView.inputRandomNum();
        baseballService.verifyRandomInput(randomNum);
        strike = baseballService.getStrike(computer, randomNum);
        int ball = baseballService.getBall(computer, randomNum);
        baseballView.printStrikeOrBall(strike, ball);
    }
}
