package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        List<Integer> computer = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            while (true) {
                // 서로 다른 수로 이루어진 3자리 수 랜덤 생성
                while(computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if(!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
                System.out.print("숫자를 입력해주세요 : ");
                userInput = reader.readLine();

                // TODO 사용자 입력에 따른 결과 판단 코드 작성

                if (true) {
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
