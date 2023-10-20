package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {

    static ArrayList<Integer> baseball = new ArrayList<>(3);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();
    }

    public static void randomNumberList()
    {
        baseball.clear();

        while(true)
        {
            int randomNumber = Randoms.pickNumberInRange(1,9);

            if(!baseball.contains(randomNumber))
                baseball.add(randomNumber);

            if(baseball.size() == 3)
                return;
        }
    }

    public static void startGame()
    {
        int result = -1;
        int gameStart = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(gameStart != 2)
        {
            randomNumberList();
            while(result != 3)
            {
                System.out.print("숫자를 입력해주세요 : ");
                String number = Console.readLine();
                doSomething(number);
                result = gameResult(number);

            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameStart = restartGame(Console.readLine());
            result = -1;
        }
    }

    public static int gameResult(String number)
    {
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < 3; i++)
        {
            int count = number.charAt(i) - 48;
            if(baseball.contains(count))
            {
                if(baseball.get(i) == count)
                    strike++;
                else
                    ball++;
            }
        }

        if(strike == 0 && ball == 0)
            System.out.println("낫싱");
        else
        {
            if(strike > 0 && ball > 0)
                System.out.printf("%d볼 %d스트라이크\n",ball,strike);
            else if(strike > 0)
                System.out.printf("%d스트라이크\n",strike);
            else
                System.out.printf("%d볼\n",ball);
        }

        if(strike == 3)
            return 3;
        else
            return 0;
    }

    public static void doSomething(String something) throws IllegalArgumentException
    {
        if(something.length() != 3)
            throw new IllegalArgumentException("3개의 숫자를 입력하지 않으셨습니다.");

        for(int i = 0; i < something.length()-1; i++)
        {
            if(something.charAt(i) == something.charAt(i+1))
            {
                throw new IllegalArgumentException("값이 중복되었습니다.");
            }
        }

        for(int i = 0; i < something.length(); i++) {
            if(something.charAt(i) < '1' || something.charAt(i) > '9') {
                throw new IllegalArgumentException("해당 숫자가 아닙니다.");
            }
        }
    }


    public static int restartGame(String something) throws IllegalArgumentException
    {
        if(!something.equals("1") && !something.equals("2"))
            throw new IllegalArgumentException();

        return Integer.parseInt(something);
    }
}
