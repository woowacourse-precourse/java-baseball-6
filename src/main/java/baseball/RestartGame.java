package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class RestartGame {
    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Computer computerNumber = new Computer();
        UserNumber userNumber = new UserNumber();
        GameResult gameResult = new GameResult();

        boolean flag = false;

        List<Integer> computer = computerNumber.randomNumber();
        List<Integer> player;

        try {
            String input = reader.readLine();

            while (input != null && input.equals("1")) {
                player = userNumber.player();

                String result = gameResult.score(computer, player);
                // System.out.println(result);

                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다!");
                    restart();
                }

            }
            if (input != null && input.equals("2")) {
                System.out.println("게임 종료");
                return false;
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return flag;
    }

}