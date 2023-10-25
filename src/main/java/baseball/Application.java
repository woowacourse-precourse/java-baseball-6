package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static int countNumber(String str, char num) { // 입력받은 값에 중복된 숫자가 있는지 체크하기 위한 함수
        return str.length() - str.replace(String.valueOf(num), "").length();
    }
    public static void main(String[] args)  {
        // TODO: 프로그램 구현

        Scanner scan = new Scanner(System.in);
        List<Integer> computer = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");
        int power = 1; // 재시작/종료 여부를 확인하기 위한 값 (1/2)
        boolean flag = false; // 게임이 재시작될 때 computer가 서로 다른 임의의 수를 다시 설정할 수 있도록 체크해줌

        while(power!=2){ // power를 2로 입력받을때까지 반복

            if(!flag) {
                // flag가 false 일경우  1.게임이 처음 시작되었거나  2.게임이 재시작 되었기 떄문이므로 computer의 값을 재설정해줌
                computer.clear();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
                flag = true; // 재설정 후 게임 종료 시까지 초기화 되지 않도록 flag 를 true로 변경
            }
            System.out.print("숫자를 입력해주세요 : ");
            String str = readLine();

            //예외처리
            if (str.length() != 3) // 1. 3자릿수 이외의 다른 값이 입력되었을 경우
                throw new IllegalArgumentException("3자리의 수가 입력되지 않았습니다. : " + str);
            else if(str.charAt(0) == '0' ||
                    str.charAt(1) == '0' ||
                    str.charAt(2) == '0') // 입력값에 0이 포함되었을 경우 (1부터 9 사이의 숫자범위)
                throw new IllegalArgumentException("입력값에 0이 포합되어있습니다. : " + str);
            else if(countNumber(str,str.charAt(0))>1 ||
                    countNumber(str,str.charAt(1))>1 ||
                    countNumber(str,str.charAt(2))>1) // 입력값에 중복된 숫자가 있을 경우
                throw new IllegalArgumentException("입력값에 중복된 숫자가 포함되어 있습니다. : " + str);


            List<Integer> user = new ArrayList<>(); // 사용자에게 입력받은 숫자를 분할하여 ArrayList에 저장
            for (int i = 0; i < str.length(); i++)
                user.add(str.charAt(i) - '0');

            int ball=0, strike = 0;

            for(int i=0;i<3;i++){
                int check = user.indexOf(computer.get(i));
                if(check==-1) // 같은 수가 포함되어있지 않음
                    continue;
                else if(check==i) // 같은 수가 같은 자리에 있음
                    strike++;
                else // 같은 수가 다른 자리에 있음
                    ball++;
            }

            if(strike==0 && ball==0) // ball, strike의 개수를 출력
                System.out.print("낫싱");
            else{
                if(ball!=0)
                    System.out.printf("%d볼 ",ball);
                if(strike!=0)
                    System.out.printf("%d스트라이크",strike);
            }
            System.out.println();

            if(strike==3){ // strike가 3이 될 경우 게임 종료
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                power = Integer.parseInt(readLine());

                if(power!=1 && power!=2) // 1, 2 이외의 값이 입력되었을 경우 예외발생
                    throw new IllegalArgumentException("1,2 이외의 숫자를 입력하였습니다. : " + power);

                flag = false; // computer의 값을 초기화 하기 위해 flag를 false로 변경
                }
            }
        }
    }