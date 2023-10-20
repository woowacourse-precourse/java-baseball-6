package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        Computer computer = new Computer();
        BallAndStrikeCount ballAndStrikeCount = new BallAndStrikeCount();
        Restart restart = new Restart();

        System.out.println("숫자 야구 게임을 시작합니다.");//게임시작 문구 필요
        //입력 문구 필요
        while (true) {
            System.out.printf("숫자를 입력해주세요 : ");
            user.inputUserNumber();
            ballAndStrikeCount.compare(computer.getRandomNumbers(), user.getUserNumber());
            ballAndStrikeCount.showStatus();
            if (ballAndStrikeCount.checkStrike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");//맞혔습니다, 게임종료
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");//재시작 선택 문구
                if (!restart.inputRestartNumber()) break;
                computer = new Computer();
            }
        }
    }
}
