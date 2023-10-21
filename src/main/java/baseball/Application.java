package baseball;
import java.util.*;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int flag = 1;
        while(true){
            if(flag == 1){
                runProgram();
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                flag = Integer.parseInt(readLine());
            }else if(flag == 2){
                break;
            }else{
                throw new IllegalArgumentException();
            }
        }
    }
    private static void runProgram() {
        List<Integer> computer = generateComputer();
        while(true){
                System.out.print("숫자를 입력해주세요 : ");
                String myNumber = readLine();
                if(myNumber.length()!= 3){
                    throw new IllegalStateException();
                }
                int[] strikeAndBall = Try(computer,myNumber);
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

    private static String getResult(int strike, int ball) {
        String result = "";
        if(strike==0&&ball==0){
            return result = "낫싱";
        }
        if(strike==0){
            result = ball + "볼";
        }
        if(ball==0){
            result  = strike + "스트라이크";
        }
        else {
            result = ball+"볼 "+strike+"스트라이크";
        }
        return result;
    }

    private static int[] Try(List<Integer> computer, String myNumber) {
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < computer.size(); i++){
            if(computer.get(i) == myNumber.charAt(i) -'0'){
                strike++;
            }else if(computer.contains(myNumber.charAt(i) -'0')){
                ball++;
            }
        }
        int[] strikeAndBall = {strike, ball};
        return strikeAndBall;
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

}
