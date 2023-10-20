package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // 1~9 사이 각 자리수가 중복되지 않는 3자리 수 생성 메소드
    public List<Integer> getNumber() {
        List<Integer> computerNum = new ArrayList<>();
        while(computerNum.size() < 3) {
            // 1~9 사이 랜덤 번호 채번
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if(!computerNum.contains(randomNum)) {
                computerNum.add(randomNum);
            }
        }
        return computerNum;
    }

    // 사용자 입력값과 숫자 비교 후 결과 출력하는 메소드
    public void baseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();

    }

    public static void main(String[] args) {
        Application application = new Application();
        // 컴퓨터가 채번한 번호
        System.out.println(application.getNumber());
        // 야구게임 시작
        application.baseballGame();
    }
}
