package baseball;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import camp.nextstep.edu.missionutils.Randoms;

public class Baseball{

    public void playball() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            ArrayList<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");

                int usernum = Integer.parseInt(br.readLine());
                List<Integer> user = new ArrayList<>();

                if(!(usernum >= 100 && usernum<=999))
                    throw new IllegalArgumentException();
                try {
                    for (int i = 0; i < 3; i++) {
                        user.add(usernum % 10);
                        usernum /= 10;
                    }
                } catch (IllegalArgumentException e){} ;
                if(strikeBall(user, computer)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if(Integer.parseInt(br.readLine()) == 1)
                continue;
            else break;
        }
    }

    public boolean strikeBall(List user, List computer){
        int strike = 0, ball = 0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(user.get(i) == computer.get(j)){
                    if(i==j) strike +=1;
                    else ball +=1;
                }
            }
        }


        if(strike == 3) {
            System.out.println("3스트라이크");
            return true;
        }
        else {
            if(strike == 0 && ball == 0)
                System.out.println("낫싱");
            else if(strike == 0 && ball != 0)
                System.out.println(ball + "볼");
            else if(strike != 0 && ball == 0)
                System.out.println(strike + "스트라이크");
            else System.out.println(ball + "볼 " + strike + "스트라이크");
            return false;
        }
    }

}