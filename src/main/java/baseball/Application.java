package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    // 컴퓨터 세자리 랜덤 숫자 생성
    public static String computerNumber(){
        String computerAnswer = "";
        while (computerAnswer.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswer.contains(String.valueOf(randomNumber))) {
                computerAnswer += ""+randomNumber;
            }
        }
        //System.out.println(computerAnswer);
        return computerAnswer;
    }
    // 사용자 세자리 숫자 입력
    public static String userNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String userAnswer = Console.readLine();
        try {//숫자가 맞는지 확인
            int number = Integer.parseInt(userAnswer);
        } catch (IllegalArgumentException e) {
            System.out.println("서로 다른 세자리 숫자를 입력하세요.");
        }   //세자리 숫자이며, 숫자 중복이 없는지 확인
        if (userAnswer.length() == 3) {
            if (userAnswer.charAt(0) == userAnswer.charAt(1) || userAnswer.charAt(1) == userAnswer.charAt(2) || userAnswer.charAt(0) == userAnswer.charAt(2)) {
                throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력하세요.");
            }
            } else {
                throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력하세요.");
            }
        return userAnswer;
        }



    //게임 시작
    public static void gamestart(){
        String computerAnswer = computerNumber();
        //3스트라이크가 될 때까지 사용자Answer 와 컴퓨터Answer 비교
        while(true){
            int strike = 0;
            int ball = 0;
            String userAnswer = userNumber();
            for (int i = 0; i < computerAnswer.length(); i++) {
                if (computerAnswer.charAt(i) == userAnswer.charAt(i)) {
                    strike++;
                    ball--;
                }
                if (computerAnswer.contains(String.valueOf(userAnswer.charAt(i)))) {
                    ball++;
                }
            }
            // 점수계산
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike != 0 && ball != 0) {
                System.out.println(ball + "볼" + " " + strike + "스트라이크");
            } else if (strike != 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } } else if (strike == 0 && ball != 0) {
                System.out.println(ball + "볼");
            }
        }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            //게임 시작
            gamestart();
            //게임 종료 후 1,2 로 재시작 여부 결정
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int replayQuestion = Integer.parseInt(Console.readLine());
            if (replayQuestion == 2) {
                break;
            } else if (replayQuestion != 1 && replayQuestion != 2) {
                throw new IllegalArgumentException("1과 2중에 입력하세요");
            }
        }
    }
}


