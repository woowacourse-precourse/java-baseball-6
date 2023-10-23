package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Game {
    public static ArrayList<Integer> computerNumber = new ArrayList<>(); // 컴퓨터 숫자 저장을 위한 arraylist
    public static ArrayList<Integer> userNumber = new ArrayList<>(); // 유저 숫자 저장을 위한 arraylist
    public static int strikeCount = 0; // 스트라이크 갯수 저장을 위한 변수
    public static int ballCount = 0; // 볼 갯수 저장을 위한 변수
    public void GameStart() {

        Computer computer = new Computer();
        User user = new User();

        // Game Start
        computerNumber = computer.setComputerNumber(computerNumber);

        // 게임 시작 멘트 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            // 스트라이크, 볼, 유저 숫자 초기화
            InitializationGameSetting();

            System.out.print("숫자를 입력해주세요 : ");
            //유저 숫자 입력 받는 메서드
            userNumber = user.getUserNumber(userNumber);

            // 스트라이크 & 볼 Check
            checkScore();

            // 결과 출력
            int result = showResult();
            // userSelect = 2 -> GameEnd
            if(result == 2) break;
            // userSelect = 1 -> 점수, 입력, 컴퓨터 숫자 초기화 후 Restart
            if(result == 1) {
                computerNumber = computer.setComputerNumber(computerNumber);
            }
        }

    }
    // 스트라이크, 볼, 유저 숫자 초기화 메서드
    public void InitializationGameSetting(){
        strikeCount = 0;
        ballCount = 0;
        userNumber = new ArrayList<>();
    }
    // 스트라이크 & 볼 Check 메서드
    public void checkScore(){
        for(int i = 0; i<computerNumber.size(); i++){
            for(int j = 0; j<userNumber.size(); j++){
                // 위치와 숫자가 모두 같으면 스트라이크
                if(computerNumber.get(i).equals(userNumber.get(j)) && i == j)
                    strikeCount++;
                    // 숫자는 같지만 위치가 다르면 볼
                else if(computerNumber.get(i).equals(userNumber.get(j)) && i != j)
                    ballCount++;
            }
        }
    }
    // 결과 출력을 위한 메서드
    public int showResult(){
        // 결과 출력 1 : 3스트라이크 인 경우
        if(strikeCount == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int userSelect = Integer.parseInt(Console.readLine());
            if(userSelect == 2) {
                System.out.println(" *** 게임을 종료합니다 !! *** ");
                return userSelect;
            }
            // 게임 재시작을 하면 컴퓨터 새로운 수 setting 해줘야함
            return userSelect;
        }

        // 결과 출력 2 : 스트라이크 + 볼
        else if (strikeCount > 0 && strikeCount < 3 && ballCount > 0)
            System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);

            // 결과 출력 3 : 스트라이크만 있을 경우
        else if(strikeCount > 0 && strikeCount < 3 && ballCount == 0)
            System.out.printf("%d스트라이크\n", strikeCount);

            // 결과 출력 4 : 볼만 있을 경우
        else if (strikeCount == 0 && ballCount > 0)
            System.out.printf("%d볼\n", ballCount);

            // 결과 출력 5 : 아무것도 없는 경우
        else if (strikeCount == 0 && ballCount == 0)
            System.out.println("낫싱");
        return 0;
    }
}
