package baseball;

import camp.nextstep.edu.missionutils.Console;
public class Player{

    public String getInput() {
        int TARGET_INPUT_LENGTH = 3;

        String input = Console.readLine();

        // 입력 수가 0~9으로 구성된 길이 3인 문자열만이 유효한 입력
        if (isNumeric(input) && input.length() == TARGET_INPUT_LENGTH) return input;

        // 유효하지 않은 입력은 IllegalArgumentException 발생
        else throw new IllegalArgumentException();
    }

    public String restartOrEndGame(){
        String gameStatus = Console.readLine();

        if (gameStatus.equals("1")) return "restart";
        else if (gameStatus.equals("2")) return "end";
        else return "error";
    }

    // 문자열이 0~9로만 구성되었는 지 확인하는 매서드
    private boolean isNumeric(String str){
        return str.matches("\\d+");
    }
}