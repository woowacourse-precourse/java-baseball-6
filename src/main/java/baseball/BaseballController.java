package baseball;

public class BaseballController {

    private BaseballException baseballException = new BaseballException();
    private BaseballView baseballView = new BaseballView();
    private BaseballService baseballService = new BaseballService();

    // 게임 시작 함수
    public void startBaseball() {

        baseballView.printBaseballStart();
        String computer = baseballService.getComputerNum();

        int strike = 0;


        // 3스트라이크가 될 때까지 반복
        while (strike<3) {
            String randomNum = baseballView.inputRandomNum();
            Baseball baseball = new Baseball(computer, randomNum, 0, 0);
            compareNums(baseball);
            strike = baseball.getStrike();
            System.out.println(baseball.getStrike());
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

    public void compareNums(Baseball baseball){
        baseballService.verifyRandomInput(baseball.getRandomNum());
        baseball.setStrike(baseballService.getStrike(baseball.getComputer(), baseball.getRandomNum()));
        baseball.setBall(baseballService.getBall(baseball.getComputer(), baseball.getRandomNum()));
        baseballView.printStrikeOrBall(baseball.getStrike(), baseball.getBall());
    }
}
