package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1. 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 2. 랜덤 숫자 생성
        RandNum randNumGenerator = new RandNum();
        List<Integer> computerNum = randNumGenerator.makeRandNum();

        // 3. 유저 입력 숫자 받기 (+입력 시 예외 처리)
        UserNum consoleInput = new UserNum();
        List<Integer> userNum = consoleInput.inputNum();

        // 4. computerNum과 userNum을 비교하여 숫자 야구 진행
        
    }
}
