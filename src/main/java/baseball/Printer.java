package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Printer {
    // 게임 시작
    public void printStart() {
        System.out.println(Message.START.getMessage());
    }

    public void printEnd() {
        System.out.println(Message.END.getMessage());
    }

    // 숫자 입력
    public String inputNumber() {
        System.out.println(Message.INPUT.getMessage());
        String input = Console.readLine();
        if (!input.matches("^(?!.*(.).*\\1)[1-9]{3}$")) throw new IllegalArgumentException("서로 다른 3개의 숫자를 공백 없이 입력해 주세요.");
        return input;
    }

    // 결과 출력
    public void printResult(Store store) {
        if (store.result.isEmpty()) System.out.println(Message.NOTHING.getMessage());
        else {
            for (String key : store.result.keySet().stream().sorted().toList()) System.out.print(store.result.get(key) + key + " ");
        }
        System.out.println();
    }

    // 정답 메시지 출력
    public void ifWin(Store store) {
        if (store.result.getOrDefault(GameInfo.CORRECT, 0) == GameInfo.NUMBER_OF_DIGITS)
            System.out.println(Message.WIN.getMessage());
    }

    // 게임 진행 여부
    public String printProcess() {
        System.out.println(Message.PROCESS.getMessage());
        String input = Console.readLine();
        if (!(input.equals(GameInfo.GAME_RESTART_INPUT) || input.equals(GameInfo.GAME_END_INPUT))) throw new IllegalArgumentException(Message.PROCESS_ERROR.getMessage());
        return input;
    }
}


