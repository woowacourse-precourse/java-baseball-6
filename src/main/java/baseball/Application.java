package baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) throws Exception {
        String userinput;

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        System.out.println("숫자 야구 게임을 시작합니다.");


        System.out.print("숫자를 입력해주세요 : " );

        userinput = null; // 초기화

        // 사용자 점수 입력
        userinput = br.readLine();

        List<Integer> computerScore = random();
        System.out.println(computerScore);

        assessment(computerScore, 44);
    }

    // 컴퓨터 점수 난수 발생
    public static List<Integer> random() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 판정
    public static void assessment(List<Integer> computerScore, int b){

    }
}
