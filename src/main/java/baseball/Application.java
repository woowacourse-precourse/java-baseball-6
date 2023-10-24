package baseball;

import java.util.Scanner;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void Random_num(ArrayList<Integer> A)
    {   
        A.clear();
        while(A.size() < 3)
        {
            int random_number = Randoms.pickNumberInRange(1, 9);
            if(!A.contains(random_number))
            {
                A.add(random_number);
            }
        }
    }
    public static void Enter_number(Scanner scanner, ArrayList<Integer> B)
    {
        B.clear();
        int num =0;

        try
        {
            System.out.print("숫자를 입력해주세요 : ");
            String user_input = Console.readLine();
            num = Integer.parseInt(user_input);

            if (num < 100 || num > 999) 
            {
                throw new IllegalArgumentException("입력한 숫자가 잘못되었습니다.");
            }
            
            B.add(num/100);
            B.add((num%100)/10);
            B.add((num%10));
        }
        catch (NumberFormatException nfe)
        {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.", nfe);
        }
    }
    public static int Compare_num(ArrayList<Integer> A, ArrayList<Integer> B)
    {
        int strike=0;
        int ball=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(A.get(i)==B.get(j))
                {
                    if(i==j)
                    {
                        strike++;
                    }
                    else
                    {
                        ball++;
                    }
                }
            }
        }
        if(strike == 0 && ball == 0)
        {
            System.out.printf("낫싱\n");
        }
        else if(strike==3)
        {
            System.out.printf("%d스트라이크\n", strike);
        }
        else
        {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
        return strike;
    }
    public static void main(String[] args) 
    {
        // TODO: 프로그램 구현
        ArrayList<Integer> computer = new ArrayList<>();
        ArrayList<Integer> user_data = new ArrayList<>();
        int game_flag=1;
        int cnt_num=0;

        Scanner scanner = new Scanner(System.in);
        
        while(game_flag==1)
        {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Random_num(computer);
            while(cnt_num != 3) 
            {    
                Enter_number(scanner, user_data);
                cnt_num = Compare_num(computer, user_data);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            try
            {
                String user_input = Console.readLine();
                game_flag = Integer.parseInt(user_input);
                
                if (game_flag < 1 || game_flag > 2) 
                {
                    throw new IllegalArgumentException("입력한 숫자가 잘못되었습니다.");
                }
            }
            catch (NumberFormatException nfe)
            {
                throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.", nfe);
            }
            cnt_num=0;
        }
        scanner.close();
        
    }
}
