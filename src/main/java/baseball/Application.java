package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        boolean gameResult = false;

        // 버퍼 리더 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 랜덤 숫자 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        // 숫자야구 시작
        while (!gameResult) {
            System.out.print("숫자를 입력해 주세요 : ");
            String s = br.readLine();
            System.out.println(s);

            if (s.equals("test"))
                gameResult = true;
//            if ()
//                gameResult = true;
        }
    }
}
