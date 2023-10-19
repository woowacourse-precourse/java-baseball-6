package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void play() {
        List<Integer> inputNum = setInput();
    }

    /**
     * 공백 없이 입력받기
     *
     * @return 입력 수
     */
    private static List<Integer> setInput() {
        String[] input = Console.readLine().split("");
        List<Integer> inputNum = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            inputNum.add(Integer.parseInt(input[i]));
        }
        return inputNum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        play();
    }
}
