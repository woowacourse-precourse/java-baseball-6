package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class BaseBallGame {

    static String computerAnswer="";
    public static String userAnswer="";
    public static List<String> computer = new ArrayList<>();


    // BaseBallGame 싱글톤 객체로 생성
    public static final BaseBallGame baseBallGame = new BaseBallGame();
    public BaseBallGame getInstance(){
        return baseBallGame;
    }
    private BaseBallGame(){}

    // 게임 시작
    public String start(){
        System.out.println("숫자 야구게임을 시작합니다.");
        computerAnswer=computerInput();

        // 사용자 입력
        while(true){
            System.out.print("숫자를 입력 해주세요: ");
            UserAnswer userInput = new UserAnswer(readLine().replaceAll(" ",""));
            userAnswer = userInput.checkUserInput();

            // 사용자 입력과 컴퓨터 값과 비교
            BaseBallUmpire baseballUmpire = new BaseBallUmpire();
            String decision = baseballUmpire.umpire(userAnswer,computer);

            // 3스트라이크일 경우
            RightAnswer rightAnswer = new RightAnswer();
            if(rightAnswer.threeStrikeVAR(decision)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                reset();
                return rightAnswer.restartOrExit();
            }
        }
    }
    private void reset() {
        computer.clear();
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