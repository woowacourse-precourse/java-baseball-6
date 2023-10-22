package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {


        GameStart gameStart = new GameStart();
        gameStart.start();




//
//        Scanner input= new Scanner(System.in);
//        System.out.println("숫자 야구 게임을 시작합니다.");
//        System.out.print("숫자를 입력해주세요 : ");
//        String userNumber = input.next();
//
//
//        List<Integer> numberLst = new ArrayList<>();
//
//        // 유저 코드 만들기
//        for(int i=0;i<userNumber.length();i++)
//        {
//            char ch = userNumber.charAt(i);
//
//            numberLst.add(ch-'0');
//
//
//
//        }
//        System.out.println(numberLst);
//        // 컴퓨터코드 만들기
//        List<Integer> computer = new ArrayList<>();
//        while (computer.size() < 3) {
//            int randomNumber = Randoms.pickNumberInRange(1, 9);
//            if (!computer.contains(randomNumber)) {
//                computer.add(randomNumber);
//            }
//        }
//
//        // calcurate
//        // Strike 계산
//        int strike=0;
//        int ball=0;
//
//        for(int i=0;i<3;i++)
//        {
//            if (computer.get(i).equals(numberLst.get(i)))
//            {
//                strike+=1;
//            }
//        }
//
//        for(int i=0;i<3;i++)
//        {
//            for(int j=0;j<3;j++)
//            {
//                if (i!=j)
//                {
//                    if(numberLst.get(i).equals(computer.get(j)))
//                    {
//                        ball+=1;
//                    }
//                }
//            }
//
//        }
//        System.out.println("유저"+userNumber);
//        System.out.println("컴퓨터"+computer);
//        if (ball >= 1)
//        {
//            System.out.print(ball+"볼");
//        }
//        if (strike >=1)
//        {
//            System.out.println(strike+"스트라이크");
//        }
//
//        if(strike==3)
//        {
//            System.out.println("3개의 숫자 모두 맞히셨습니다");
//        }
//
//        System.out.println(strike+""+ball);
//
//        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//
//
//

//@@@@@@@@@@@@@@@@@@@@@
        //gameStart()

//        System.out.println("숫자 야구 게임을 시작합니다.");
//
//           // #String[] userNumber = new String[1];
//
//        Scanner sc =  new Scanner(System.in);
//
//
//
//        System.out.print("숫자를 입력해주세요 : ");
//        String userNumber=sc.next();
//
//
//        char[] number= userNumber.toCharArray();
//        System.out.println(number);
//        System.out.println("컴퓨터 숫자");
//
//        List<Integer> computer = new ArrayList<>();
//        while (computer.size() < 3) {
//            int randomNumber = Randoms.pickNumberInRange(1, 9);
//            if (!computer.contains(randomNumber)) {
//                computer.add(randomNumber);
//            }
//        }
//
//        // 스트라이크 체크
//        int strike=0;
//        int ball=0;
//        for(int i=0;i<3;i++)
//        {
//
//            System.out.println(computer.get(i));
//
//            System.out.println(computer.get(i).getClass().getName());
//            if (number[i]==computer.get(i))
//            {
//            strike+=1;
//            }
//
//        }
//        // 볼 체크
//
//        for(int i=0;i<3;i++){
//            for (int j=0;j<3;j++)
//            {
//                if (i!=j)
//                {
//                    if(number[i]==computer.get(j))
//                    {
//                        ball++;
//                    }
//                }
//            }
//        }
//        System.out.println(computer);
//
//        System.out.println(strike);
//        System.out.println(ball);
    }
}
