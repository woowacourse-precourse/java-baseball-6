package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean result=false;
        String ifOver;
        ShootBall randomBall = new ShootBall();
        ShootBall inputBall = new ShootBall();
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            randomBall.randomNumGenerator();
            do{
                inputBall.inputNumGenerator();
                result = randomBall.baseballReferee(inputBall);
                inputBall = new ShootBall();
            }while (!result);
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            ifOver = Console.readLine();
        } while (ifOver.charAt(0) != '2');
    }
}
