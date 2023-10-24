package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    private static final String WELCOME_MSG = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MSG = "숫자를 입력해주세요 : ";
    private static final String BALL_MSG = "볼 ";
    private static final String STRIKE_MSG = "스트라이크";
    private static final String NOTHING_MSG = "낫싱";
    private static final String END_MSG = "3스트라이크\n" +
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CONTINUE_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final int START_NUM = 1;
    private static final int END_NUM = 9;
    private static final int COUNT = 3;
    public static void main(String[] args) {
        // 게임 시작
        println(WELCOME_MSG);

        try{
            // 랜덤 3자리 숫자 생성
            List<Integer> randNum = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT);

            while(true){
                // 사용자 입력 받기
                print(INPUT_MSG);
                String userInput = Console.readLine();

                // 사용자 입력이 정확한지 판별
                isRightInput(userInput);

                // 결과 판정 후 루프 탈출 결정
                if(isAnswer(randNum, userInput)) break;
            }
        }catch (IllegalArgumentException e){
            println(e.getMessage());
        }finally {
            // Scanner 종료
            Console.close();
        }
    }

    private static boolean isAnswer(List<Integer> randNum, String userInput){
        int strike = 0;
        int ball = 0;

        int length = userInput.length();

        // 판정 로직
        for(int idx=0; idx<length; idx++){
            int num = userInput.charAt(idx) - '0';
            int matchingIdx = randNum.indexOf(num);
            // 숫자가 없는 경우: 볼이나 스트라이크가 아님
            if(matchingIdx < 0) continue;

            // 숫자와 인덱스가 일치: 스트라이크
            if(matchingIdx == idx){
                strike++;
            }else{  // 인덱스가 불일치: 볼
                ball++;
            }
        }

        // 판정 결과
        if(strike == 3){ // 정답인 경우
            println(END_MSG);
            return true;
        }

        if(strike + ball == 0){ // 하나도 못 맞춘 경우
            println(NOTHING_MSG);
        }else{ // 부분 정답인 경우
            print((ball == 0) ? "" : ball + BALL_MSG);
            println((strike == 0) ? "" : strike + STRIKE_MSG);
        }

        return false;
    }

    private static void isRightInput(String userInput){
        if(userInput.length() != COUNT){
            throw new IllegalArgumentException("사용자 입력 오류 - 3자리 외 글자수 금지");
        }

        boolean[] count = new boolean[10];
        for(int i=userInput.length()-1; i>=0; i--){
            int num = userInput.charAt(i) - '0';
            if(num < 1 || num > 9) throw new IllegalArgumentException("사용자 입력 오류 - 1부터 9이외의 문자 금지");
            if(count[num]) throw new IllegalArgumentException("사용자 입력 오류 - 중복된 숫자 금지");
            count[num] = true;
        }

    }

    private static void print(String msg){
        System.out.print(msg);
    }

    private static void println(String msg){
        System.out.println(msg);
    }
}
