package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

class BaseballGame{
    private List<Integer> computer;

    public BaseballGame(){
        computer = generateRandomNumbers();
    }

    private List<Integer> generateRandomNumbers(){
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public List<Integer> getComputerNumbers(){
        return computer;
    }
}

class GameProcess{

    private static void isSutable(String s) throws IllegalArgumentException{
        try{
            // 모두 0부터 9까지의 숫자로 이루어져있는지
            int number=Integer.parseInt(s);
            // 3자리의 숫자인지
            if(s.length()!=3){
                throw new IllegalArgumentException();
            }
            // 3자리 모두 다른 숫자인지
            for(int i=0;i<3;i++){
                for(int j=i+1;j<3;j++){
                    if(Objects.equals(s.charAt(i),s.charAt(j))){
                        throw new IllegalArgumentException();
                    }
                }
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public static void startGame(){
        // 문제 출제
        System.out.println("숫자 야구 게임을 시작합니다");

        BaseballGame game = new BaseballGame();
        playGame(game);
    }

    private static void playGame(BaseballGame game){
        // 문제 풀기-반복처리
        List<Integer> computer=game.getComputerNumbers();

        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String answer= readLine();

            // 입력값에 대한 예외 처리 필요
            try {
                isSutable(answer); // 입력값 검증
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }

            // 힌트 출력
            List<Integer> user = new ArrayList<>();
            for(int i=0;i<3;i++){

                user.add(Integer.parseInt(Character.toString(answer.charAt(i))));
            }
            int strike=0;
            int ball=0;
            for(int i=0;i<3;i++){
                if(Objects.equals(user.get(i), computer.get(i))){
                    strike+=1;
                }
                else if(computer.contains(user.get(i))) {
                    ball += 1;
                }
            }

            if(strike==0 && ball==0){
                System.out.println("낫싱");
            }
            if(strike!=0 && ball==0){
                System.out.println(strike+"스트라이크");
            }
            if(strike==0 && ball!=0){
                System.out.println(ball+"볼");
            }
            if(strike!=0 && ball!=0){
                System.out.println(ball+"볼 "+strike+"스트라이크");
            }

            if(strike==3)break;
        }


    }
}

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameProcess.startGame();
        // 정답 알림 문구출력
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    }
}
