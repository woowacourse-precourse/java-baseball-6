package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    private static final Input input = new Input();
    private Input() {
    }
    public static Input getInput() {
        return input;
    }
    MyException myException = MyException.getMyException();

    // 게임 중
    public String doGame() {
        System.out.println("숫자를 입력해주세요 : ");
        return myException.checkAnswer(Console.readLine()); // 예외 처리 : 3 자리수, 동일숫자 안됨. 숫자만 들어올 것
    }
    // 정답 출력 후 게임 진행 여부 묻기
    public int finishGame(List<Integer> list) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choiceNum = myException.checkFinishAnswer(Console.readLine()); // 예외 처리 : 1 혹은 2만 들어올 것
        if (choiceNum == 1) list.clear();
        return choiceNum;
    }
}
