package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean doRestart = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(doRestart){
            NumberBaseballGame.startGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int userRestartNumber = Integer.parseInt(Console.readLine());

            if(userRestartNumber == 2){
                doRestart = false;
            }
            continue;

        }




//        List<Integer> userInput = new ArrayList<>();
//        for(int i = 0; i < 3; i++){
//
//
//        boolean isWrong = true;
//        boolean doRestart = true;
//
//        System.out.println("숫자 야구 게임을 시작합니다");
//
//        while(isWrong){
//            System.out.println("숫자를 입력해주세요 : ");
//            getUserInput(); //변수에 유저 guess assign
//            checkUserGuessNumber(); //결괏값 프린트
//
//
//        }
//
//        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//        getUserRestartNumber();
//
//
//        //////////////////////////////////// 2중 while문
//
//        while(doRestart){
//            System.out.println("숫자 야구 게임을 시작합니다");
//
//            while(isWrong) {
//                System.out.println("숫자를 입력해주세요 : ");
//                //객체에 유저 input(guess) assign & 잘못된 input IllegalArgumentException => 프로그램 종료
//                int userInput = getUserInput();
//                //결괏값 프린트 & isWrong 딸깍 스위치
//                checkUserGuessNumber(userInput);
//            }
//
//
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//            // 객체에 유저 input(restartNumber) assign
//            getUserInput();
//            // & doRestart 딸깍 스위치
//            checkUserRestartNumber(Object userInput);
//
//        }
//
//
//
//        public int getUserInput(){
//            // if - else 문으로 조건에 맞는 입력값 필터링? => try-catch 오류처리?(IllegalArgumentException)
//            var userInput = Console.readLine();
//
//             //숫자이고, 서로 다른(String?), 세자리(100 ~ 999)
//            return userInput;
//        }
//        //클래스 필드 값을 내부 메소드에서 리턴 - 인스턴스 변수 vs 클래스 변수(static)
//        //(권장하지 않지만 굳이) 클래스의 static 변수를 여러 인스턴스에서 업데이트해가면서 사용한다면, 마지막 업데이트로 고정됨(static) - 인스턴스 전체가 공유하는 변 => final 처리하면 업데이트 금지됨
//        // 상수 변수에서 띄어쓰기는 underscore 사용
//
//        public void checkUserGuessNumber(Object userInput){
//
//        }
//
//
//        // & doRestart 딸깍 스위치
//        public void checkUserRestartNumber(Object userInput){
//            //while(!(UserInput == 1 || UserInput == 2)){
//                Console.readLine();
//                System.out.println("숫자 1또는 2만 눌러주세요.");
//            } // => while문 위치... userInput 다시 받아야되니까
//
//
//            if(userInput == 1){
//
//            } else if(userInput == 2){
//
//            }
//        }
//
//
//

    }
}

//처음부터 모듈화 빡세게 고민하니까 고민이 끝도 없어짐. 적당히 하면서 나중에 리팩토링 & 모듈화 & 클린코드 & Java Convention 의식
//함수가 '동사'라면, 객체는 '명사'라고 착각함(아직 뭐라고 단정X) => 함수 리턴 형태에 따라, 다른 함수의 인자로 결과값을 패스해야할 듯
