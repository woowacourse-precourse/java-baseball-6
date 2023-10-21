package Game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class playGame {
    static String answer = new String();

    public static void makeNumber(){
        answer="";
        while(answer.length()<3){
            int randomNum= Randoms.pickNumberInRange(1,9);
            if(!answer.contains(String.valueOf(randomNum))){
                answer+=String.valueOf(randomNum);
            }
        }

        for(char c: answer.toCharArray())
        {
            System.out.print(c);
        }
    }
    public static void start(){
        playGame game=new playGame();
        do{
            makeNumber();
            game.turn();
            if(game.restart())
            {
                game=new playGame();
            }
            else
            {
                break;
            }
        }while(true);
    }
    private void turn(){
        String inputString;
        do {
            System.out.print("숫자를 입력해주세요 :");
            inputString = Console.readLine();
            checkInputString(inputString);
        }while(!checkGameResult(inputString));
    }

    private void checkInputString(String inputString)
    {
        String tmp="";
        if (inputString.length() !=3)
        {   //예외처리 : 문자열 길이 판단
            throw new IllegalArgumentException("잘못된 길이의 문자를 입력하셨습니다.");
        }
        for(char c: inputString.toCharArray()) {
            //예외처리 : 음수 입력 및 문자입력
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("잘못된 타입의 문자를 입력하셨습니다.");
            }
            // 예외처리 : 중복된 숫자 입력
            if(tmp.contains(String.valueOf(c))){
                throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다");
            }
            tmp+=String.valueOf(c);

        }
    }

    private int cntStrike(String inputNumber){
        int strike_cnt = 0;
        for (int i = 0; i<answer.length(); i++) {
            if(inputNumber.charAt(i) == answer.charAt(i)){
                strike_cnt++;
            }
        }
        return strike_cnt;
    }
    private int cntTotal(String inputString){
        int total_cnt = 0;
        for (char c : inputString.toCharArray()) {
            if(answer.contains(c+"")){
                total_cnt++;
            }
        }
        return total_cnt;
    }

    private boolean checkGameResult(String inputNumberString){
        int strike_cnt = cntStrike(inputNumberString);
        int total_cnt = cntTotal(inputNumberString);
        printResult(strike_cnt, total_cnt);

        return (strike_cnt == 3);
    }

    private void printResult(int strike_cnt, int total_cnt){
        int ball_cnt= total_cnt- strike_cnt;
        if(total_cnt==0){
            System.out.println("낫싱");
        }
        else{
            if(ball_cnt !=0 && strike_cnt !=0)
            {
                System.out.println(ball_cnt+"볼 "+strike_cnt+"스트라이크");
            }
            else if(ball_cnt!=0){
                System.out.println(ball_cnt+"볼");
            }
            else if(strike_cnt!=0){
                System.out.println(strike_cnt+"스트라이크");
            }
        }
        if(strike_cnt==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private boolean restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        if(inputString.equals("1")){
            return true;
        }
        else if(inputString.equals("2")){
            return false;
        }
        else{
            throw new IllegalArgumentException("잘못된 입력을 입력하셨습니다.");
        }
    }
}
