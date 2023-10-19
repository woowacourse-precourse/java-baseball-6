package baseball;

public class BaseballGame {

    public void play() {
        WinningNumbers winningNumbers = new WinningNumbers();

        while (true) {
            BaseballNumbers baseballNumbers = new BaseballNumbers();

            BallCount ballCount = winningNumbers.ballCounting(baseballNumbers);

            System.out.println(ballCount);
            if (ballCount.isFullCount()) break;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
