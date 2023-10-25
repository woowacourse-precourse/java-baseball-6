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
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine(); // readLine() 메소드를 사용하여 입력값을 받아옴
            validateNumeric(input); // 입력받은 문자열이 숫자로만 구성되어 있는지 검사
            number = Arrays.stream(input.split("")).map(Integer::parseInt).toList(); // 입력값을 Integer로 변환하여 리스트에 저장
            validateNumber(); // 입력한 숫자의 유효성 검사

        return number;
    }

    private void validateNumeric(String str){
        // 입력받은 문자열이 숫자로만 구성되어 있지 않으면 예외 발생
        if (!str.matches("-?\\d+")) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }
    private void validateNumber () {
        validateSize();
        validateRange();
        validateDuplicate();
    }

    private void validateSize(){
        // 입력한 숫자의 자리수가 3자리 수가 아니면 예외 발생
        if (number.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }

    private void validateDuplicate () {
        // 스트림을 사용하여 중복된 요소를 제거한 후 배열의 길이와, 원래 배열의 길이를 비교하여 입력값에 중복된 숫자가 있으면 예외 발생
        if (number.stream().distinct().collect(Collectors.toList()).size() != number.size()) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
        }
    }

    private void validateRange () {
        // 입력한 숫자가 1~9 사이의 숫자가 아니면 예외 발생
        number.stream().forEach(n -> {
            if (n < 1 || n > 9) {
                throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요.");
            }
        });
    }

}