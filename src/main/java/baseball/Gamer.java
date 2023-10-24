package baseball;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Gamer {

    private List<Integer> number;

    public List<Integer> getNumber() {
        return this.number;
    }

    public List<Integer> receiveNumber() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine(); // readLine() 메소드를 사용하여 입력값을 받아옴
            number = Arrays.stream(input.split("")).map(Integer::parseInt).toList(); // 입력값을 Integer로 변환하여 리스트에 저장
        } catch (IllegalArgumentException e) { // 예외 발생 시 프로그램 종료
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return number;
    }
}