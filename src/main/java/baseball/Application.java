package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Comsball comsball = new Comsball();
        BallCheck ballcheck = new BallCheck();
        StrikeCheck strikecheck = new StrikeCheck();
        Myball myball = new Myball();

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            int[] coms_ball = comsball.make_ball();
            int strikes = 0;
            int balls = 0;
            int[] userArr;

            while (strikes != 3) {
                myball.input();
                userArr = myball.getNumbers();

                strikes = strikecheck.check(coms_ball, userArr);
                balls = ballcheck.check(coms_ball, userArr);

                if (balls == 0 && strikes == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.println(balls + "볼 " + strikes + "스트라이크");
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임 종료!");

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String choice = Console.readLine();

            if (!choice.equals("1")) {
                break;
            }
        } while (true);
    }
}
