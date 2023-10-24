package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Scanner input = new Scanner(System.in);
        int  ball, strike, num=0;
        String finishnum, humannum;

        List<Integer> computernum = new ArrayList<>();
        //셋에 있는 숫자를 배열로 만들어줌
        while (computernum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computernum.contains(randomNumber)) {
                computernum.add(randomNumber);
            }
        }
        //배열의 값을 랜덤하게 섞어주는 메서드

        while (true) //입력 받을때까지 무한반복
        {
            ball = 0;
            strike = 0;
            //볼과 스트라이크 초기화
            //System.out.println("컴퓨터숫자: " + computernum);
            //컴퓨터의 숫자가 뭔지 알 수 있게 가시화(나중에 지워야댐)
            System.out.print("숫자를 입력해주세요:");
            humannum = readLine();

            try {
                num = Integer.parseInt(humannum);

            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자 형식이 아닙니다.");
            }

            if (num >= 1000 || num < 101 ||
                    num % 10 == 0 || (num / 10) % 10 == 0 || (num / 100) % 10 == 0 ||
                    num % 10 == (num / 10) % 10 ||
                    num % 10 == (num / 100) % 10 ||
                    (num / 10) % 10 == (num / 100) % 10)
            //예와처리 이렇게 하는거 맞나...?
            {
                throw new IllegalArgumentException();
            }

            //반복문 중첩으로 해서 컴퓨터숫자의 마지막 순서와
            //사용자숫자의 일의자리 수부터 비교하여 같다면 strike or ball ++
            for (int i = 2; i >= 0; i--) {
                for (int j = 2, mul = 1; j >= 0; j--, mul *= 10) {
                    if (computernum.get(i) == (num / mul) % 10) {
                        if (i == j)
                            strike++;
                        else
                            ball++;
                    }
                }
            }
            if (ball != 0)
                System.out.print(ball + "볼 ");
            if (strike != 0)
                System.out.print(strike + "스트라이크");
            if (ball == 0 && strike == 0)
                System.out.print("낫싱");
            System.out.println();

            if (strike == 3)//게임이 끝난경우
            {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                finishnum = readLine();
                if (finishnum.equals("1"))
                //계속하기를 입력했다면 셋을 초기화한 뒤에
                //랜덤한 수(1~9)를 셋에 넣어서 다시 배열에 넣어줌
                {
                    computernum.clear();
                    //셋에 있는 숫자를 배열로 만들어줌
                    while (computernum.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computernum.contains(randomNumber)) {
                            computernum.add(randomNumber);
                        }
                    }
                    continue;
                } else if (finishnum.equals("2")) {
                    break;
                } else {
                    //1,2 이외의 숫자를 넣은경우 예외처리
                    throw new IllegalArgumentException();
                }
            }

        }


    }


}