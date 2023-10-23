package baseball;
/*
    writer: vvvv1111vvvv
    purpose: training and improve skills
    date: oct 23, 2023
*/

import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console; //.Console 샤용을 위해 import
import camp.nextstep.edu.missionutils.Randoms; //.Randoms 샤용을 위해 import
import java.util.List;
class gaming{
    /*
    기능: game 진행을 처리
    */
    private static final String START_MESSAGE="숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_INPUT_MESSAGE="숫자를 입력해 주세요 : ";
    private static final String REQUEST_IF_NEW_GAME_MESSAGE="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private int answer;
    private int userInput;
    protected gaming(){
        //생성자: 같은 페키지 내에서만 접근
    }
    public int gamingProcess(){
        /*
        기능: 게임의 진행를 수행한다.
             해답 변수 int형 answer을 생성
        입력: gaming 클래스의 인스턴스
        출력: Int 타입의: 게임 재시작 여부
        */
        this.answer = getAnswer();
        System.out.println(START_MESSAGE);
        boolean result;
        do{
            System.out.print(REQUEST_INPUT_MESSAGE);
            this.userInput = userInputIntegerCheck();
            if(this.userInput==-1){
                return 2; //게임 종료
            }
            result = userInputValidCheck();
        }
        while(result);
        return gamingFinishingTrigger();
    }
    private static int getAnswer(){
        /*
        기능: 해답 변수 int형 을 생성해 반환
        입력: 
        출력: Int 타입의: 해답 변수
        */
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return  100*computer.get(0)+10*computer.get(1)
                +computer.get(2);
    }
    private boolean userInputValidCheck() {
        /*
        기능: 사용자가 입력한 값이 111<=userInput<=999 이고 0이 없음을 확인한다.
        입력: gaming play 객체, answer, userInput
        출력:
        */
        if (this.userInput < 111 || 999 < this.userInput) {
            throw new IllegalArgumentException("number range must be 111<= number <=999");
        } else if ((this.userInput / 10) % 10 == 0 || (this.userInput % 10) == 0) {
            throw new IllegalArgumentException("no zero shoud be included");
        } else if ((this.userInput) % 10 == (this.userInput / 10) % 10 ||
                (this.userInput / 10) % 10 == (this.userInput / 100) || (this.userInput) % 10 == (this.userInput / 100)) {
            throw new IllegalArgumentException("each digit must be different");
        }
        return userInputAnswerCheck();
    }
    private boolean userInputAnswerCheck(){
        /*
        기능: 해답 answer을 사용자가 입력한 값 userInput과 비교한다.
        입력:
        출력: printUserInputCheckResult()를 호출해 리턴받은 boolean값
        */
        int[] arrAnswer   = {this.answer/100, (this.answer/10)%10, this.answer%10};
        int[] arrUserInput= {this.userInput/100, (this.userInput/10)%10, this.userInput%10};
        int countBall=0;
        int countStrike=0;
        for(int i=0;i<3;i++){
            if (arrAnswer[0]==arrUserInput[i]){
                countBall=countBall+1;
            }
        }
        for(int i=0;i<3;i++){
            if (arrAnswer[1]==arrUserInput[i]){
                countBall=countBall+1;
            }
        }
        for(int i=0;i<3;i++){
            if (arrAnswer[2]==arrUserInput[i]){
                countBall=countBall+1;
            }
        }
        for(int i=0;i<3;i++){
            if (arrAnswer[i]==arrUserInput[i]){
                countStrike=countStrike+1;
                countBall=countBall-1;
            }
        }
        return printUserInputCheckResult(countBall, countStrike);
    }
    private static boolean printUserInputCheckResult(int countBall, int countStrike){
        /*
        기능: countBall과 countStrike의 값에 따라 다른 메시지를 출력하고, boolean 값을 반환한다.
        입력: int 타입의 countBall과 countStrike
        출력: boolean 타입 3스트라이크 시에는 false를 반환한다. 이외의 경우에는 true를 반환한다.
        */
        if(countBall==0 && countStrike==0){
            System.out.println("낫싱");
            return true;
        }
        else if(countStrike==3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        else if(countBall==0){
            System.out.println(countStrike+"스트라이크");
            return true;
        }
        else if(countStrike==0){
            System.out.println(countBall+"볼");
            return true;
        }
        System.out.println(countBall+"볼 "+countStrike+"스트라이크");
        return true;
    }
    private static int userInputIntegerCheck(){
        /*
        기능: 사용자가 입력한 값이 정수인지 확인한다.
        입력: Console.readLine()
        출력: 유효시: userInput, 이상시: 예외 처리
        */
        int userInput;
        try{
            userInput=Integer.parseInt(Console.readLine());
            //System.out.println(userInput);
            if(userInput>0){
                return userInput;
            }
                return -2;
        }
        catch(NumberFormatException e) {
            // 예외 처리: 입력 값이 integer가 아니라면, 게임 완전 종료
            e.printStackTrace();
            return -1;
            //throw new NumberFormatException("number type must be 1 or 2.");
            //e.printStackTrace();//예외 상황을 콘솔로 출력
        }
    }
    private static int gamingFinishingTrigger() {
        /*
        기능: 추가로 입력한 값에 게임의 재시작 또는 종료를 수행한다.
        입력: play 객체
        출력: Int 타입의: 게임 재시작시 1, 게임 종료시 2를 리턴, 이외의 경우 : 예외 처리후 종료
        */
        System.out.println(REQUEST_IF_NEW_GAME_MESSAGE);
        int userInput = userInputIntegerCheck();

        switch (userInput){
            case -1:
              System.out.println("정수가 아닌 것을 입력하셨습니다. 게임프로그램을 종료합니다.");
              return 2;
            case 1:
              System.out.println(userInput+"를 입력하셨습니다. 게임프로그램을 새로 시작합니다.");
              return 1;
            case 2:
              System.out.println(userInput+"를 입력하셨습니다. 게임프로그램을 종료합니다.");
              return 2;
            default:
              // 입력값이 1, 2가 아닌 integer라면 게임 완전 종료
              throw new IllegalArgumentException("number type must be 1 or 2.");

        }
    }

}


public class Application {
    public static void main(String[] args) {
        /*
        기능: 게임 진행을 위한 play 객체를 생성하고, 조건을 만족하는 동안 재시작한다.
        입력: String[] args
        출력: void
        */
        int replayValue=1;// 1이면 재시작, 2이면 종료

        while(replayValue==1) {
            gaming play = new gaming();               // gaming 클래스의 새 객체 play를 생성
            replayValue = play.gamingProcess(); // play 객체로 게임 시작, 반환값: replayValue
        }
        Console.close();
        //Console.readLine();//scanner로 다음 줄을 읽어 String 타입으로 리턴한다.
        //Console.close();//scanner를 close
        /*Randoms.pickNumberInList(List<Integer> numbers)
            기능: 입력한 List<Integer>의 값들 중 하나를 random으로 리턴
            입력: List<Integer> numbers
            출력: numbers 객체를 리턴
         */
        /*Randoms.pickNumberInRange(final int startInclusive, final int endInclusive)
            기능: 입력한 범위를 바탕으로 a<=random<=b 인 random값을 리턴
            입력: startInclusive, endInclusive
            출력: Int 타입의 범위 내 random값
         */
        /*Randoms.pickUniqueNumbersInRange(
            final int startInclusive,
            final int endInclusive,
            final int count
        )
            기능: 입력한 범위를 바탕으로 a<=random<b 인 random값 count개를 리턴
            입력: startInclusive, endInclusive, count
            출력: List 타입의 범위 내 random 값 count개
        */



    }
}

