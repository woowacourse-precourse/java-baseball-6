package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // player가 입력하는 값 String 형태로 저장
        String playerInput = Console.readLine();

        // 입력받은 값이 세 자리 숫자가 아니라면 IllegalArgumentException 발생시킨 후 애플리케이션 종료
        if (playerInput.length() != 3) throw new IllegalArgumentException();

        // 입력받은 값을 char 배열에 넣기
        char[] playerInputChar = playerInput.toCharArray();

        // char -> int 형태로 변환 후 List에 저장
        List<Integer> playerInputNumber = new ArrayList<>();
        int len = 0;
        while (len < 3) {
            playerInputNumber.add(Character.getNumericValue(playerInputChar[len]));
            len++;
        }

        // playerInputNumber 확인 작업
        System.out.println(playerInputNumber);

    }
}
