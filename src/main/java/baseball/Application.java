package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;



public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answerList;
        while(true) {
            answerList = createAnswer();
            while (true) {
                System.out.print("숫자를 입력해 주세요: ");
                String user_answer = readLine();
                if (check(user_answer) == false) {
                    throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력해 주세요.");
                }
                if (BaseballGame(answerList, user_answer) == 1) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String user_choice = readLine();
                    if (Integer.valueOf(user_choice) == 1) {
                        break;
                    } else if (Integer.valueOf(user_choice) == 2) {
                        return;
                    } else throw new IllegalArgumentException("1 또는 2를 입력하세요.");

                }
                ;
            }
        }




    }

    //user가 입력한 숫자가 적절한 숫자인지 check
    public static boolean check(String user_choice)
    {
        List<Integer> checkList = new ArrayList<>();
        for(int i = 0; i<user_choice.length(); i++)
        {
            int number = Integer.valueOf(user_choice.charAt(i) - 48);
            if(!checkList.contains(number))
            {
                checkList.add(number);
            }
        }
        if(checkList.size() != 3) return false;
        else return true;
    }

    //answer 생성
    public static List<Integer> createAnswer()
    {
        List<Integer> answerList = new ArrayList<>();
        while (answerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }
        return answerList;
    }

    //야구 게임 코드
    public static int BaseballGame(List<Integer> answerList, String user_answer) {
        int strike = 0, ball = 0, nothing = 0;
        for(int i=0; i<3; i++)
        {
            int answerNum = Integer.valueOf(user_answer.charAt(i)-48);
            if(answerNum == answerList.get(i))
            {
                strike++;
            }
            else if(answerList.contains(answerNum))
            {
                ball++;
            }
            else nothing++;
        }
        if(nothing == 3) {
            System.out.println("낫싱");
            return 0;
        }
        if(strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 1;
        }
        if(ball != 0) System.out.print(ball + "볼 ");
        if(strike != 0) System.out.println(strike + "스트라이크 ");
        else System.out.print('\n');
        return 0;


    }
}
