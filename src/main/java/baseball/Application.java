package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int CNT = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            // computer의 랜덤 숫자를 생성하는 함수 실행 + List에 값 저장
            List<Integer> computerNumbers = createComputerNumbers();
            System.out.println(transInput(Console.readLine()));

            //play(computerNumbers);
            // 게임 종료 후 재시작 선택
            //if (!choiceRestart()) break;
        }
    }

    // computer의 랜덤 숫자 생성 함수
    private static List<Integer> createComputerNumbers(){
        // 생성된 숫자들을 저장할 List 선언
        List<Integer> numbers = new ArrayList<>();
        // 1~9 사이의 숫자를 정해진 개수만큼 생성 및 numbers에 저장
        while(numbers.size() < CNT){
            int randomNumbers = Randoms.pickNumberInRange(1,9);
            if (!numbers.contains(randomNumbers)){
                numbers.add(randomNumbers);
            }
        }
        // 생성된 숫자 List(numbers)를 반환합니다.
        return numbers;
    }

    // string -> int 변환 함수
    private static List<Integer> transInput(String input){
        List<Integer> numbers = new ArrayList<>();
        // 입력 값이 세자리를 넘는 경우 예외 처리
        if (input.length() != CNT){
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.") ;
        }
        for (char ch : input.toCharArray()) {
            // 입력 값이 숫자가 아닌 경우 예외 처리
            if (!Character.isDigit(ch)){
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
            // 중복 판별. ch에 저장된 문자가 numbers에 이미 있는 경우, 중복이므로 예외 처리.
            if (numbers.contains(ch - '0')){
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }
            // ASCII 코드를 이용한 char -> int 변환
            numbers.add(ch - '0');
        }
        // int 값으로 변환된 List를 반환
        return numbers;
    }

}
