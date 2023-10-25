package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseballGame {

    public BaseballGame() throws IOException {
        startGame();
    }

    public int startGame() throws IOException {

        Computer computer = new Computer(); //랜덤 숫자 생성

        User user = new User();

        int result; //

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("숫자를 입력해주세요 : ");
            String s = bf.readLine();

            int[] input = user.setInputNum(s);

            result = computer.calculate(input);

        } while(result != 1);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();

        return Integer.parseInt(s);
    }


}
