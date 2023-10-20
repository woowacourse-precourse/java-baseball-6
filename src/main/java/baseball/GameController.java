package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public List<Integer> computer = new ArrayList<>();  // 컴퓨터(정답) 번호
    public List<Integer> user = new ArrayList<>();  // 유저가 입력한 번호
    public boolean status = true;   // 야구 게임의 상태가 새로 시작(1) 인지, 종료(2) 인지 구분
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(status) {
            gaming();
        }
    }

    private void gaming() {
        GameTool gameTool = new GameTool();
        Exception exception = new Exception();
        computer = gameTool.generatedRandomNumbers(3); // 3개 랜덤 숫자 생성

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String number = Console.readLine();
            user = exception.isValid(number);    // 예외 발생하지 않으면 List<Integer> 형태로 숫자 반환

       }
    }
}
