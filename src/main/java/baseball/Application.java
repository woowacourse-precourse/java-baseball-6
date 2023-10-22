package baseball;

public class Application {

    public static void main(String[] args) {

        boolean flag = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (flag) {
            String computerBall = RandomNumberGenerator.generateRandomNumber();
            BallCount ballCount;
            do {
                System.out.print("숫자를 입력해주세요 : ");
                String playerBall = Input.readNumber();
                ballCount = Referee.checkBallCount(playerBall, computerBall);
                System.out.println(ballCount.getBallCount());
            } while (!ballCount.isThreeStrike()); // 3스트라이크가 나올 때 까지 반복
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String option = Input.readOption();
            if (option.equals("2")) { // 입력 값이 2와 같다면 실행 종료
                flag = false;
            }
        }
    }
}
