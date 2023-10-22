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

            // 게임 실행
            play(computerNumbers);

            // 게임 종료 후 재시작 여부 선택
            if (!choiceRestart()) break;
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

    // strike 개수 체크 함수
    private static int countStrike(List<Integer> computer, List<Integer> user){
        int strike = 0;
        for (int i=0; i<CNT; i++){
            // 숫자랑 위치가 일치하는 경우, strike 개수 1 증가
            if (computer.get(i).equals(user.get(i)))  strike ++;
        }
        return strike;
    }

    // ball 개수 체크 함수
    private static int countBall(List<Integer> computer, List<Integer> user){
        int ball = 0;
        for (int i=0; i<CNT ; i++){
            // 숫자가 있지만 위치는 다른 경우, ball 개수 1 증가
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) ball++;
        }
        return ball;
    }

    // 야구 게임 진행 함수
    private static void play(List<Integer> computerNumbers){
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNumbers = transInput(Console.readLine());
            int strike = countStrike(computerNumbers, userNumbers);
            int ball = countBall(computerNumbers, userNumbers);

            // 모든 수를 맞춘 경우 게임 종료
            if (strike == CNT) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else if (strike == 0 && ball == 0) { // strike, ball 개수가 모두 0인 경우
                System.out.println("낫싱");
            } else { // 각 개수 출력
                if (ball > 0) System.out.print(ball + "볼 ");
                if (strike > 0) System.out.print(strike + "스트라이크");
                System.out.println();
            }
        }
    }

    // 재실행 여부 판별 함수
    private static boolean choiceRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        // 입력이 1 또는 2가 아닌 경우는 예외 처리.
        if ("1".equals(choice) || "2".equals(choice)){
            return "1".equals(choice);
        }else {
            throw new IllegalArgumentException("잘못된 입력입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
