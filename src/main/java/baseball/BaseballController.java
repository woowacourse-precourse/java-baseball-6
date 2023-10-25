package baseball;

import camp.nextstep.edu.missionutils.Console;

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

            String randomNum = baseballView.inputRandomNum();

            baseballException.isLengthValid(randomNum);
            baseballException.isDuplicationExist(randomNum);
            baseballException.isCharinString(randomNum);

            strike = baseballService.getStrike(computer, randomNum);
            int ball = baseballService.getBall(computer, randomNum);

            baseballView.printStrikeOrBall(strike, ball);
        }

        // 3스트라이크인 경우, 게임 종료
        if (strike==3) {
            baseballView.printGameOver();

            // 재시작 또는 종료 입력받기
            String restart = baseballView.inputRestart();

            // 플레이어가 입력한 수가 1 또는 2가 아닌 경우
            if (!"1".equals(restart) && !"2".equals(restart)){
                throw new IllegalArgumentException();
            }

            if ("1".equals(restart)) {
                startBaseball();
            } else if("2".equals(restart)) {
                System.out.println("게임 종료");
            }
        }
    }
}
