package baseball;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            validateNumber(); // 입력한 숫자의 유효성 검사
        } catch (IllegalArgumentException e) { // 예외 발생 시 프로그램 종료
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return number;
    }
    private void validateNumber () {
        // 입력한 숫자의 크기가 3자리 수가 아니면 예외 발생
        if (number.size() != 3) {
            throw new IllegalArgumentException();
        } else if ( // 스트림을 사용하여 중복된 요소를 제거한 후 배열의 길이와, 원래 배열의 길이를 비교하여 입력값에 중복된 숫자가 있으면 예외 발생
            number.stream()
            .distinct()
            .collect(Collectors.toList())
            .size() != number.size()) throw new IllegalArgumentException();
    }
}