package baseball;

public class BaseBall {

    public static void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            Computer computer = new Computer();
            User user = new User();

            while(true) {
                System.out.print("숫자를 입력해주세요 : ");
                String answer = user.answer();
                Result result = computer.check(answer);
                System.out.println(result.print());

                if (result.getStrike() == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    boolean restart = user.restartGame();
                    if (restart) {
                        break;
                    } else {
                        System.out.println("게임 종료");
                        return;
                    }
                }
            }
        }
    }
}
