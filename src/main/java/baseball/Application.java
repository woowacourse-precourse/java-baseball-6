package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computerNumber = new Computer();
        UserNumber userNumber = new UserNumber();
//        GameResult gameResult = new GameResult();
        Compare compare = new Compare();
        RestartGame restartGame = new RestartGame();

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean flag = true;

        while (flag) {
            List<Integer> computer = computerNumber.randomNumber();
            List<Integer> player = userNumber.UserNumber();

            String result = compare.compareNumber(computer, player);

            if (result.equals("3스트라이크")) {
                System.out.println(compare.compareNumber(computer,player));
                flag = restartGame.restart();
            }
            System.out.println(compare.compareNumber(computer,player));
        }
    }
}
