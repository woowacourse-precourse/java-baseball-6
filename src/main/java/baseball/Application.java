package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        String input;
        boolean start = true;
        boolean ans = false;
        int strike=0,ball=0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(start)
        {
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            System.out.println(computer);
            while(!ans)
            {
                input = Console.readLine();
                if(strike==3)
                    ans=true;
            }


            start = false;
        }
    }
}
