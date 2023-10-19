package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    // 메서드 네임 리팩토링 필요
    public void showGameStartMent() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 숫자를 입력받는 메서드
    public List<Integer> readNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        List<Integer> inputNumList = Arrays.stream(inputNum.split(""))
                .mapToInt(Integer::parseInt)
                .boxed().toList();

        return inputNumList;
    }


}
