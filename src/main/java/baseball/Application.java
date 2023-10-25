package baseball;

import java.util.ArrayList;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    static ArrayList<Integer> numList = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList();

    public static void getInput() throws IllegalArgumentException
    {
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();

        if(input.length() != 3) throw new IllegalArgumentException();

        while(numList.size()<3)
        {
            char digitChar = input.charAt(numList.size());
            if(Character.isDigit(digitChar))
            {
                int digit = Character.getNumericValue(digitChar);
                if(numList.contains(digit))  throw new IllegalArgumentException();
                numList.add(digit);
            }
            else
            {
                throw new IllegalArgumentException();
            }
        }
    }
    public static void init()
    {
        while(ans.size()<3)
        {
            int next = pickNumberInRange(1, 9);
            if(!ans.contains(next))
            {
                ans.add(next);
            }
        }
    }
    public static void startGame()
    {
        numList.clear();    ans.clear();
        init();

        while(true)
        {
            numList.clear();
            getInput();

            int strike = 0;
            int ball = 0;
            for(int i = 0 ; i<3 ; i++)
            {
                for(int j = 0 ; j<3 ; j++)
                {
                    if(ans.get(i) == numList.get(j))
                    {
                        if(i==j)    strike++;
                        else        ball++;
                    }
                }
            }

            if(ball>0)
            {
                System.out.print(ball + "볼");
                if(strike>0)    System.out.print(" ");
            }
            if(strike>0)    System.out.print(strike+"스트라이크");
            if(ball == 0 && strike == 0)    System.out.print("낫싱");
            System.out.println();

            if(strike==3)
            {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료.");
                break;
            }
        }
    }
    public static boolean restartGame() throws IllegalArgumentException
    {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String signalOrigin = readLine();

        try
        {
            int signal = Integer.parseInt(signalOrigin);

            if(signal == 1) return true;
            else if(signal == 2)    return false;
            else throw new IllegalArgumentException();
        }
        catch (NumberFormatException e)
        {
            throw new IllegalArgumentException();
        }
    }
    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true)
        {
            startGame();
            if(!restartGame())   break;
        }
    }
}