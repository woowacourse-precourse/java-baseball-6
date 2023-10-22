package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    // 답변 임시 저장 필드
    String[] picksToArray;
    String gameRestart;

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 답변 입력해서 객체에 저장하는 메서드 => Player 인스턴스로 이동
    public static String[] inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String picks = Console.readLine();
        String[] picksToArray = picks.split("");
        return picksToArray;
    }

    public String askForGameEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        gameRestart = Console.readLine();
        return gameRestart;
    }
}
