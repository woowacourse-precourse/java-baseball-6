package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        String gameRepeat = "1";
        do{
            ComputerGame game = new ComputerGame();
            game.gameStart();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameRepeat = Console.readLine();
        }while(gameRepeat.equals("1"));
    }
}
class UserInput{
    String userAnswer;
    UserInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String tmp = Console.readLine();
        chkInputException(tmp);
        userAnswer= tmp;
    }
    //사용자 입력값에 대한 예외처리
    static void chkInputException(String answer) throws IllegalArgumentException {
        //1) 길이3 아닌 경우
        if (answer.length() != 3) {
            throw new IllegalArgumentException();
        }
        //2) 입력값 각 숫자 범위가 1-9 외 구성인 경우
        for (int i = 0; i < 3; i++) {
            int num = Character.getNumericValue(answer.charAt(i));
            if (num < 1 || num > 9) throw new IllegalArgumentException();
        }
        //3) 입력값 중복된 경우-서로 다른 수가 아닌 경우
        String tmp = "";
        for (int i = 0; i < 3; i++) {
            String num = String.valueOf(answer.charAt(i));
            if (tmp.contains(num)) {
                throw new IllegalArgumentException();
            }
            tmp += num;
        }
    }
}

class ComputerGame{
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

        int ball = ballCnt(userAnswer, computerAnswer);
        int strike = strikeCnt(userAnswer, computerAnswer);
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

    //볼 카운팅
    static int ballCnt(String userAnswer, String comAnswer){
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            String cur = String.valueOf(userAnswer.charAt(i));
            if (comAnswer.contains(cur)) {
                cnt++;
            }
        }
        return cnt;
    }
    //스트라이크 카운팅
    static int strikeCnt(String userAnswer, String comAnswer){
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (comAnswer.indexOf(userAnswer.charAt(i)) == i) {
                cnt++;
            }
        }
        return cnt;
    }

}