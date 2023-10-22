package baseball;

public class Application {

    public static void main(String[] args) {

        String option;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            String playerBall;
            Computer computer = new Computer();
            do {
                System.out.print("숫자를 입력해주세요 : ");
                playerBall = Input.readNumber();
            } while (!computer.catchBall(playerBall));
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            option = Input.readOption();
        } while (!option.equals("2"));
    }
}
