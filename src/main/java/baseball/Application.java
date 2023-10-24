package baseball;

import baseball.activity.RefereeActivity;
import baseball.object.Computer;
import baseball.object.Human;
import baseball.object.Referee;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            List<Integer> computer = Computer.DigitSetting();
            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> human = Human.DigitSetting(scanner);
                Referee referee = new Referee(0, 0, computer.size());
                RefereeActivity.StrikeAndBallCount(referee, computer, human);
                RefereeActivity.Decision(referee);
                int result = RefereeActivity.ReStartAndExit(referee, scanner);
                if(result==1)
                    break;
                else if(result==2)
                    return;
            }
        }
    }
}
