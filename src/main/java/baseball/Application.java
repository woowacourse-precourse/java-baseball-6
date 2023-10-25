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
        PlayGame playBaseball = new PlayGame();
        int gameContinues = playBaseball.compareNum(computerNum, userNum);

        while (true) {
            if (gameContinues == 2) { //op2. 게임 종료
                break;
            } else if (gameContinues == 1) { // op1. 새로운 게임 시작, 변경된 랜덤 숫자와 유저 숫자 넣기
                computerNum = randNumGenerator.makeRandNum();
                userNum = consoleInput.inputNum();
                gameContinues = playBaseball.compareNum(computerNum, userNum);
            } else { // op3. 현재 게임 지속
                userNum = consoleInput.inputNum();
                gameContinues = playBaseball.compareNum(computerNum, userNum);
            }
        }

    }
}
