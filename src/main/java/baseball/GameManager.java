package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameManager {
    public void start() throws IOException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameFunction.createRandomnumber();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String num = br.readLine();
            GameFunction.gametry(num);
        }
    }
}
