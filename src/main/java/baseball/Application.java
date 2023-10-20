package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.pool.TypePool;

public class Application {
    static String comAnswer;
    static String userAnswer;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //1) 컴퓨터 랜덤 난수 생성
        comAnswer = computerRandomNum();
        System.out.println(comAnswer);
        //2) 사용자 입력값 예외처리
        userAnswer = Console.readLine();
        chkInputException(userAnswer);
        //3) 사용자 입력값에 대한 힌트 제공
        if(getHint(userAnswer, comAnswer)){
            System.out.println("정답입니다.");
        }

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

    //사용자 입력값에 대한 예외처리
    static void chkInputException(String useAnswer) throws IllegalArgumentException{
        //1) 길이3 아닌 경우
        if(userAnswer.length() != 3) {
            throw new IllegalArgumentException();
        }
        //2) 입력값 각 숫자 범위가 1-9 외 구성인 경우
        for(int i=0; i<3; i++){
            int num = Character.getNumericValue(userAnswer.charAt(i));
            if(num < 1 || num > 9) throw new IllegalArgumentException();
        }
        //3) 입력값 중복된 경우-서로 다른 수가 아닌 경우
        String tmp = "";
        for(int i=0; i<3; i++){
            String num = String.valueOf(userAnswer.charAt(i));
            if(tmp.contains(num)){
                throw new IllegalArgumentException();
            }
            tmp += num;
        }
    }

    //사용자 입력값에 대한 힌트 제공
    static boolean getHint(String userAnswer, String computerAnswer){
        String result = "";
        int ball = 0;
        int strike = 0;

        for(int i=0; i<3; i++){
            String cur = String.valueOf(userAnswer.charAt(i));
            if(computerAnswer.contains(cur)){
                ball++;
            }
        }
        for(int i=0; i<3; i++){
            if(computerAnswer.indexOf(userAnswer.charAt(i)) == i){
                strike++;
            }
        }
        ball -= strike;

        if(ball > 0){
            result += String.valueOf(ball)+"볼 ";
        }
        if(strike > 0){
            result += String.valueOf(strike) + "스트라이크 ";
        }
        if(ball == 0 && strike == 0){
            result = "낫싱";
        }
        System.out.println(result);

        if(strike == 3){
            return true;
        }
        return false;
    }

}