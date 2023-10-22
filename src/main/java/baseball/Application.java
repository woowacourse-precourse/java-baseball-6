package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        String answer = "123";

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                userInput = reader.readLine();
                System.out.println(userInput);
                if (userInput.equals(answer)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userInput = reader.readLine();
            if (userInput.equals("2")) break;
            else if(!userInput.equals("1")) throw new IllegalArgumentException();  // 잘못된 값 입력 시
        }
    }
}
