package baseball;

import camp.nextstep.edu.missionutils.Randoms;

//게임에 대한 전체 진행 로직
public class ComputerGame{
    String comAnswer;
    String userAnswer;

    ComputerGame(){
        comAnswer = computerRandomNum();
        System.out.println(comAnswer);
    }
    //게임 진행 반복 - 정답 맞출 때까지
    public void gameStart(){
        boolean success = false;
        do{
            UserInput input = new UserInput();
            userAnswer = input.userAnswer;
            success = getHint(userAnswer, comAnswer);
        }while(!success);

    }
    //컴퓨터 랜덤 숫자 생성 함수
    static String computerRandomNum(){
        //중복 없이 3개의 숫자로 구성
        String num = "";
        while(num.length() <3){
            String tmp = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if(!num.contains(tmp)){
                num+=tmp;
            }
        }
        return num;
    }

    //사용자 입력값에 대한 힌트 제공
    static boolean getHint(String userAnswer, String computerAnswer) {
        String result = "";
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            String cur = String.valueOf(userAnswer.charAt(i));
            if (computerAnswer.contains(cur)) {
                ball++;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (computerAnswer.indexOf(userAnswer.charAt(i)) == i) {
                strike++;
            }
        }
        ball -= strike;

        if (ball > 0) {
            result += String.valueOf(ball) + "볼 ";
        }
        if (strike > 0) {
            result += String.valueOf(strike) + "스트라이크 ";
        }
        if (ball == 0 && strike == 0) {
            result = "낫싱";
        }
        System.out.println(result);

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
