package baseball;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
//import baseball.IsMatch;

public class RunGame {
    static int[] answer = new int[3];
    static int[] keyNum = new int[3];
    // 난수생성
    public void createRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int idx = 0;
        for (int a: computer) {
//            System.out.println(a);
            answer[idx] = a;
            idx += 1;
        }

    }
    // 시작지점 inputNumbers, returnResult 두개 실행
    public static void run(){
        RunGame runningGame = new RunGame();
        runningGame.runningGame();
    }
    // run()에서 게임 시작하는 부분 분리함
    public void runningGame() {
        RunGame startGame = new RunGame();
        RunGame finishGame = new RunGame();
        RunGame inputNumbers = new RunGame();
        RunGame returnResult = new RunGame();
        RunGame createRandomNumbers = new RunGame();

        startGame.startGame();
        createRandomNumbers.createRandomNumbers();
        while(true){
            boolean alert = inputNumbers.inputNumbers();
            if (!alert) break;
            boolean isEnd = returnResult.returnResult();
            if (isEnd) {
                finishGame.finishGame();
                break;
            }
        }
    }
    // 게임시작 문구 출력 => IsMatch > accurateTest 실행
    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
//        IsMatch.accurateTest();
    }
    // 종료지점
    public void finishGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    }
    // 숫자 입력받아 int 배열으로 전환하는 과정
    public boolean inputNumbers(){
        System.out.println("숫자를 입력해주세요 : ");
//        Scanner input = new Scanner(System.in);
        String numStr = Console.readLine();
        int num = Integer.parseInt(numStr);
//        System.out.println(num);
        int j = 100;
        for (int i = 0; i < 3; i++) {
            if (i == 0 && num/j == 0) return false;
            keyNum[i] = (int) num/j;
            num -= (num/j)*j;
            j /= 10;
        }
        return true;
    }
    // 숫자를 판단해서 결과 출력
    public boolean returnResult(){
        int[] ball = {0, 0, 0};
        int[] strike = {0, 0, 0};
        RunGame finishGame = new RunGame();
        for (int i = 0; i < 3; i++) {
            for (int l = 0; l < 3; l++) {
                if (i == l && (int) answer[i] == (int) keyNum[l]) {
                    strike[i] = 1;
                    break;
                }
                else if ((int) answer[i] == (int) keyNum[l]) {ball[i] = 1;}
            }
        }
        int ballCnt = 0;
        int stCnt = 0;
        for (int a : ball) {ballCnt += a;}
        for (int a : strike) {stCnt += a;}
        if (ballCnt > 0 && stCnt > 0) {
            System.out.println(ballCnt+"볼 "+stCnt+"스트라이크");
        } else if (ballCnt > 0 && stCnt == 0) {
            System.out.println(ballCnt+"볼");
        } else if (ballCnt == 0 && stCnt > 0) {
            System.out.println(stCnt+"스트라이크");
        } else {
            System.out.println("낫싱");
        }
        if ((int) stCnt == 3) return true;
        return false;
    }


    
}
