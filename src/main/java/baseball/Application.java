package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    // 메세지들
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String PLAY_AGAIN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    // 게임 시작
    public void start() {
        System.out.println(GAME_START_MESSAGE); //시작 메세지 출력
        boolean gameContinues = true; // 게임이 계속 실행되는지를 결정하는 변수

        while(gameContinues){
            Computer computer = new Computer(); // 컴퓨터 객체 생성
            boolean roundContinues = true; // 한 판이 계속 실행되는지를 결정하는 변수
            while(roundContinues){
                List<Integer> userInput = getUserInput(); // 사용자의 숫자 입력 받기
                PlayGame result = new PlayGame(computer.getNumbers(), userInput); // 게임 결과 생성
                System.out.println(result.getResult()); // 결과 출력
                if (result.getStrikes() == 3){ // 3 스트라이크이면
                    roundContinues = false; // 이번 판 종료
                    System.out.println(GAME_END_MESSAGE); // 종료 메세지 출력
                    gameContinues = playAgain(); // 다시 플레이 할 지 결정
                }
            }
        }
    }

    // 사용자로부터 숫자를 입력받는다
    private List<Integer> getUserInput(){
        while(true){
            System.out.println(INPUT_NUMBER_MESSAGE); // 입력 메세지 출력
            String input = Console.readLine(); // 사용자 입력 받기
            if(InputValidator.validateInput(input)){ // 입력 값 검증
                List<Integer> numbers = new ArrayList<>(); // 숫자 저장을 위한 리스트
                for (char ch:input.toCharArray()){ // 문자열을 문자 배열로 변경하고 각 문자별로 순회
                    numbers.add(Character.getNumericValue(ch)); // 문자를 숫자로 변환해서 리스트에 추가
                }
                return numbers; // 숫자 리스트 반환
            }
            else{
                throw new IllegalArgumentException("Wrong input"); // 잘못된 입력인 경우 예외 발생
            }
        }
    }

    // 게임을 다시 진행할 것인지 사용자에게 묻는다
    private boolean playAgain(){
        System.out.println(PLAY_AGAIN_MESSAGE); // 메세지 출력
        while(true){
            String again = Console.readLine(); // 사용자 입력 받기
            if(InputValidator.validateAgain(again)){ // 입력 값 검증
                return "1".equals(again); // '1'이면 true 반환 (다시 플레이), 아니면 false 반환 (게임 종료)
            }
            else{
                throw new IllegalArgumentException("Wrong input"); // 잘못된 입력인 경우 예외 발생
            }
        }
    }

    // 메인
    public static void main(String[] args) {
        Application application = new Application(); // Application 객체 생성
        application.start(); // 게임 시작
    }
}
