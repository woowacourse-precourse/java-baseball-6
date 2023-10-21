package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import java.lang.*;

public class Application
{
    public static void main(String[] args)
    {
        Base_Function BF = new Base_Function();

        List<Integer> Cnum = BF.Make_RandomNum();
        List<Integer> Input_num = new ArrayList<Integer>();
        Input_num.add(0); Input_num.add(0);Input_num.add(0);

        // 개인적인 테스트를 할 때 사용한 코드. 1.Cnum을 알기 위함. 2.Input_num이 잘 생성되었는지 확인 코드
        //System.out.println("Cnum: " + Cnum.toString());
        //System.out.println("Input_num : " + Input_num.toString());

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true)
        {
            System.out.print("숫자를 입력해 주세요 : ");
            String input_str = BF.Input_Data();

            // 입력과정에 오류가 없는지 체크한다. -3개의 데이터 입력이 아닌 경우
            if(BF.Input_Correction_Check(input_str,3) == -1)
                break;

            //비교를 위해 Cnum처럼 List 타입으로 저장해준다.
            Input_num.set(0, input_str.charAt(0)-'0');
            Input_num.set(1, input_str.charAt(1)-'0');
            Input_num.set(2, input_str.charAt(2)-'0');

            // 입력받은 데이터가 1~9 사이의 숫자가 아닌경우.
            if(BF.Input_Correction_Check(Input_num) == -1)
                break;

            // 입력받은 값과 컴퓨터값을 비교해야 한다.
            int cmp_num = Compare_Input_And_Cnum(Input_num, Cnum);

            // 비교 결과 cmp_num이 30이라는 의미는 3스트라이 이기 때문에.
            if(cmp_num == 30)
            {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String type_SE = BF.Input_Data();
                if(BF.Input_Correction_Check(type_SE,1) == -1)
                    break;
                else
                {
                    if(type_SE.equals("1"))
                    {
                        Cnum = BF.Make_RandomNum();
                    }
                    else if(type_SE.equals("2")) {
                        break;
                    }
                }

            }
            else // 3스트라이크가 아닌 경우
            {
                // strike, boll 상황을 출력하고, 위로 올라가 입력부터 다시 수행
                String print_str = Make_Print_String(cmp_num);
                System.out.println(print_str);
            }
        }

        System.out.println("게임 종료");
        //System.out.println("동적할당한 객체를 delete하고 프로그램을 종료합니다.");
        // 자바에서는 new로 생성한 객체에 null을 넣어 객체를 delete한다.(C++할때는 무조건 delete함수 호출함)
        // 하지만 자바에서 지금은 가비지컬렉션 기능으로 따로 수행할 필요는 없다고 판단.
        Console.close();
        return;
    }


    public static int Compare_Input_And_Cnum(List<Integer> input_num, List<Integer> Cnum)
    {
        int strike = 0; int boll = 0;

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(input_num.get(i).equals(Cnum.get(j)))
                {
                    if(i==j){ strike+=1; break;}
                    else {boll+=1; break;}
                }
            }
        }

        // 리턴값의 10의자리는 strike를 의미, 1의자리는 boll을 의미
        int ret_num = strike*10 + boll;
        return ret_num;
    }
    public static String Make_Print_String(int cmp_num)
    {
        String str = "";
        if(cmp_num == 0)
        {
            str="낫싱"; return str;
        }

        int strike = cmp_num/10;
        int boll = cmp_num%10;
        if(boll > 0)
        {
            str += boll + "볼 ";
        }
        if(strike>0)
        {
            str += strike+"스트라이크";
        }

        return str;
    }
}




