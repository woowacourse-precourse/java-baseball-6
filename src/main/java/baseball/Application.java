package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {



//
//    // TODO: 1-1. 겹치지 않는 3자리 난수 생성
//    public void generateRandomNum() {
//        // 랜덤 값 추출(1~9)
//        while (computer.size() < 3) {
//            int randomNumber = Randoms.pickNumberInRange(1, 9);
//
//            //랜덤 수와 기존 적혀 있는 수가 겹치는지 확인
//            if (!computer.contains(randomNumber)) {
//                computer.add(randomNumber);
//            }
//        }
//        System.out.println("Random Number: " + computer);
//    }
//
//    // TODO: 유저가 잘못된 입력값(수가 하나라도 겹칠때)을 넣었을 때 예외발생
//    public void wrongNum(String userInput) {
//        if (userInput.length() != 3 ||
//                (userInput.charAt(0) == userInput.charAt(1)
//                        && userInput.charAt(1) == userInput.charAt(2)
//                        && userInput.charAt(0) == userInput.charAt(2))) {
//            throw new IllegalArgumentException("세자리 수 보다 크거나 작습니다. 혹은 세 자리의 수 중 하나라도 겹치는 수가 있습니다.");
//        }
//
//    }
//
//    // TODO: 2-2. 입력된 수와 위치에 따라 결과 출력
//    public void matchNum(String userInput) {
//
//            for (int i = 0; i < computer.size(); i++) {
//                for (int j = 0; j < userInput.length(); j++) {
//
//                    if (computer.get(i) == userInput.charAt(j) && i == j) {
//                        strike+=1;
//                    } else if (computer.get(i) == userInput.charAt(j) && i != j) {
//                        ball+=1;
//                    }
//                }
//            }
//            printScore(strike,ball);
//    }
//
//    // TODO: 맞춘 갯수 별 출력문
//    public void printScore(int strike, int ball){
//
//        if (this.strike == 0 && this.ball ==0){
//            System.out.println("낫싱");
//        }else if (strike !=0 && ball == 0){
//            System.out.println(strike + "스트라이크");
//            if (strike == 3){ //3개의 스트라이크 게임 끝
//                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//            }
//        }else if (strike == 0){ //0스트라이크, n개의 ball
//            System.out.println(ball + "볼");
//        }else{
//            System.out.println(ball+"볼 " + strike+"스트라이크");
//        }
//    }
//
//
////    // TODO: 2. 세자리 수가 겹치는 지 확인하는 메소드
////    private static boolean checkUniqueness(int number) {
////        String numberString = String.valueOf(number);
////        boolean isUnique = false;
////
////        if (numberString.charAt(0) != numberString.charAt(1)
////                && numberString.charAt(1) != numberString.charAt(2)
////                && numberString.charAt(0) != numberString.charAt(2))
////        {
////
////        }
////    }



    //TODO : restart() 또 게임할래
    public static boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restartFlag = Integer.parseInt(Console.readLine());

        return (restartFlag==1) ? false: true;

    }



    public static void main(String[] args) {


        do{

            //컴퓨터의 난수를 받을 곳
            List<Integer> computer = new ArrayList<>();
            int strike;
            int ball;

            // TODO: 프로그램 시작
            System.out.println("숫자 야구 게임을 시작합니다.");

            // TODO: 컴퓨터의 난수 생성
            // 랜덤 값 추출(1~9)
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);

                //랜덤 수와 기존 적혀 있는 수가 겹치는지 확인
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            System.out.println("Random Number: " + computer);


            do {
                strike = 0;
                ball = 0;

                // TODO : 사용자 입력
                String userInput = Console.readLine();
                System.out.println("User Input: " + userInput);

                //입력 값 검증
                if (userInput.length() != 3 ||
                        (userInput.charAt(0) == userInput.charAt(1)
                                && userInput.charAt(1) == userInput.charAt(2)
                                && userInput.charAt(0) == userInput.charAt(2))) {
                    throw new IllegalArgumentException("세자리 수 보다 크거나 작습니다. 혹은 세 자리의 수 중 하나라도 겹치는 수가 있습니다.");
                }

                // TODO : 야구게임 시작
                for (int i = 0; i < computer.size(); i++) {
                    for (int j = 0; j < userInput.length(); j++) {
                        System.out.println("computer.get(i)은 " + computer.get(i)+ " i = "+i);
                        System.out.println("userInput.charAt(j)은 " + userInput.charAt(j)+ " j " + j);
                        System.out.println(strike);

                        if (computer.get(i) == Character.getNumericValue(userInput.charAt(j))
                            && i == j) {
                            strike+=1;
                            System.out.print("strike " + strike);

                        } else if (computer.get(i) == Character.getNumericValue(userInput.charAt(j))
                                && i != j) {
                            ball+=1;
                        }
                    }
                }

                System.out.println("안녕 나 출력문 "+ strike + " ball " + ball);

                // TODO : 변수를 가지고 출력문 생성
                if (strike == 0 && ball ==0){
                    System.out.println("낫싱");
                }else if (strike !=0 && ball == 0){
                    System.out.println(strike + "스트라이크");
                    if (strike == 3){ //3개의 스트라이크 게임 끝
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    }
                }else if (strike == 0){ //0스트라이크, n개의 ball
                    System.out.println(ball + "볼");
                }else{
                    System.out.println(ball+"볼 " + strike+"스트라이크");
                }
                
            // TODO: 정답을 맞출 경우 종료
            } while(strike<3);

        }while(!restart());


    }




}
