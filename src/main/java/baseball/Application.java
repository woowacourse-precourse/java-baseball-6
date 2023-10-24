package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        String input;
        boolean start = true;
        boolean ans = false;
        int strike=0,ball=0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(start)
        {
            while (computer.size() < 3) { //난수 생성
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while(!ans)//사용자에게 값을 입력받아 정답을 맞히면 반복문 탈출
            {
                System.out.print("숫자를 입력해 주세요 : ");
                input = Console.readLine();

                for(int i=0;i<input.length();i++)
                {
                    int userNumber = Character.getNumericValue(input.charAt(i));//string의 각 요소를 int로 형변환
                    user.add(userNumber);
                }

                for(int j=0;j<3;j++)//사용자에게 입력받은 수와 난수를 비교해 ball과 strike 증가시키기
                {
                    int userInput = user.get(j);
                    int index=computer.indexOf(userInput);

                    if(index==j)
                    {
                        strike++;
                    }
                    else if (index!=-1)
                    {
                        ball++;
                    }
                }

                if(strike!=0 && ball!=0)
                {
                    System.out.printf("%d볼 %d스트라이크\n", ball, strike);
                }
                else if (strike!=0)
                {
                    System.out.printf("%d스트라이크\n",strike);
                }
                else if(ball!=0)
                {
                    System.out.printf("%d볼\n", ball);
                }
                else
                {
                    System.out.println("낫싱");
                }

                if (strike == 3)
                {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    ans = true;
                }


                strike=0;
                ball=0;
                user.clear();
            }

            computer.clear();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();
            if (input.equals("1"))
            {
                ans=false;
            }
            else if(input.equals("2"))
            {
                start=false;
            }
        }
    }
}
