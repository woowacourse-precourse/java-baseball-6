package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class BaseBallGame {

    static String computerAnswer="";
    static String userAnswer="";
    static List<String> computer = new ArrayList<>();
    static String gameSet ="";
    static int ball=0;
    static int strike=0;

    public void start(){
        System.out.println("숫자 야구게임을 시작합니다.");
        computerAnswer=computerInput();
        //System.out.println("computerAnswer = " + computerAnswer);
        // 사용자 입력
        while(true){
            System.out.print("숫자를 입력 해주세요: ");
            try{
                userAnswer = readLine().replaceAll(" ","");
                //System.out.println("userAnswer = " + userAnswer);
            }catch (Exception e){
                throw new IllegalArgumentException(e);
            }
            userAnswer=checkUserInput();

            // 사용자 입력과 컴퓨터 값과 비교
            String decision = umpire();

            // 3스트라이크일 경우
            if(decision.equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                // 게임 재시작 및 종료
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gameSet = readLine();
                gameSet = restartOrExit();

                // 재시작 및 종료 check
                if(gameSet.equals("재시작")) {
                    reset();
                    start();
                    return;
                }
                else if(gameSet.equals("게임 종료")) return;
            }
        }
    }

    private void reset() {
        userAnswer="";
        computerAnswer="";
        computer.clear();
        Console.close();
    }

    private String umpire() {
        ball=0; strike=0;
        StringBuilder sb = new StringBuilder();
        String[] ans = userAnswer.split("");

        for(int i =0; i<3;i++){
            if(computer.contains(ans[i])){
                if(ans[i].equals(computer.get(i))){
                    strike++;
                    continue;
                }
                ball ++;
            }
        }

        if(ball !=0 && strike !=0){
            sb.append(ball+"볼 "+strike+"스트라이크");
        } else if (ball==0 && strike==0) {
            sb.append("낫싱");
        } else if (strike==0) {
            sb.append(ball+"볼");
        } else if(ball ==0){
            sb.append(strike+"스트라이크");
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    private String restartOrExit() {

        if(gameSet.equals("1")) return "재시작";
        else if(gameSet.equals("2")) return "종료";
        throw new IllegalArgumentException();
    }

    //사용자 입력값 체크
    private String checkUserInput() {


        if(userAnswer.trim().length() !=3){
            throw new IllegalArgumentException();
        }

        //중복검사
        String[] answerRepeat = userAnswer.split("");
        for(int i=0;i<2;i++){
            for(int j=i+1;j<3;j++){
                if(answerRepeat[i].equals(answerRepeat[j]))  throw new IllegalArgumentException();
            }
        }
        return userAnswer;
    }

    //컴퓨터 값 입력
    private String computerInput() {


        while (computer.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        // List<String> => 문자열로 변환
        return computer.stream().collect(Collectors.joining());
    }

}
