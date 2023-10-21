package baseball;
import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    static final String START = "1";
    static final String END = "2";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean onLoop = true;
        String flag = START;
        while(onLoop){
            switch (flag){
                case START:
                    runProgram();
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    flag = readLine();
                    break;
                case END:
                    onLoop = false;
                    break;
                default:
                    throw new IllegalArgumentException();
                }
        }
    }
    private static void runProgram() throws IllegalArgumentException{
        List<Integer> computer = generateComputer();
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String myNumber = readLine();
            checkedException(myNumber);
            int[] strikeAndBall = calculateStrikeBall(computer,myNumber);
            int strike = strikeAndBall[0];
            int ball = strikeAndBall[1];
            String result = getResult(strike,ball);
            System.out.println(result);
            if(result.equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
    public static List generateComputer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    private static int[] calculateStrikeBall(List<Integer> computer, String myNumber) {
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < computer.size(); i++){
            if(computer.get(i) == myNumber.charAt(i) -'0'){
                strike++;
            }else if(computer.contains(myNumber.charAt(i) -'0')){
                ball++;
            }
        }
        int[] strikeAndBall= {strike, ball};
        return strikeAndBall;
    }
    private static String getResult(int strike, int ball) {
        String result = "";
        if(strike==0&&ball==0){
            result = "낫싱";
        }
        else if(strike==0){
            result = ball + "볼";
        }
        else if(ball==0){
            result  = strike + "스트라이크";
        }
        else {
            result = ball+"볼 "+strike+"스트라이크";
        }
        return result;
    }
    private static void checkedException(String myNumber){
        String regex = "^[1-9]+$";
        String tmp = "";
        if(myNumber.length()!= 3){
            throw new IllegalArgumentException();
        }else if(!myNumber.matches(regex)){
            throw new IllegalArgumentException();
        }
        for(char c : myNumber.toCharArray()){
            if(!tmp.contains(String.valueOf(c))) {
                tmp+=String.valueOf(c);
            }else if(tmp.contains(String.valueOf(c))){
                throw new IllegalArgumentException();
            }
        }
    }
}
