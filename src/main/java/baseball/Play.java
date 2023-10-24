package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Play {
    User user = new User();
    String userNumber = "";
    Computer computer = new Computer();
    String computerNumber = computer.CreateNumber();
    int strikes;
    int balls;
    int restart = 0;

    public void PlayGame() {
        strikes = 0;
        balls = 0;
        System.out.printf("숫자를 입력해주세요 : ");
        userNumber = user.UserInput();
        CheckNumber();
        PrintResult();
        CheckCorrect();
    }

    // 스트라이크, 볼 판정을 하는 메서드
    public void CheckNumber() {
        for(int i=0; i<3; i++) {
            if(userNumber.charAt(i) == computerNumber.charAt(i)) {
                strikes++;
            }
        }
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(userNumber.charAt(i) == computerNumber.charAt(j))
                    balls++;
            }
        }
        balls -= strikes;
    }

    // 스트라이크가 3개인지 확인하는 메서드
    public void CheckCorrect() {
        if(strikes == 3) {
            System.out.printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            System.out.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            restart = Integer.parseInt(Console.readLine());
        }
    }

    public void PrintResult() {
        if(strikes == 0 && balls == 0) {
            System.out.printf("낫싱\n");
            return;
        }
        if(strikes == 0 && balls != 0) {
            System.out.printf("%s볼\n", balls);
            return;
        }
        if(strikes != 0 && balls == 0) {
            System.out.printf("%s스트라이크\n", strikes);
            return;
        }
        System.out.printf("%s볼 %s스트라이크\n", balls, strikes);
        return;
    }

    public int getStrikes() {
        return strikes;
    }
    public int getRestart() {
        return restart;
    }

}
