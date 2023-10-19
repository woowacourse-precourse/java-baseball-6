package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static int match(int[] human, List<Integer> robot) {
        boolean[] visitedHuman = new boolean[3];
        boolean[] visitedRobot = new boolean[3];
        int strike=0; int boll=0; int not=0;
        //스트라이크 먼저 체크
        for(int i = 0; i<3; i++) {
            if(human[i]==robot.get(i)) {
                strike++;
                visitedHuman[i]=true;
                visitedRobot[i]=true;
            }
        }
        //볼 체크
        for(int i=0; i<3; i++) {
            if(visitedRobot[i]) continue;
            for(int j=0;j <3; j++) {
                if(visitedHuman[j]) continue;
                if(robot.get(i) == human[j]) {
                    boll++;
                    visitedHuman[j] = true;
                }
            }
        }
        //output
        if(boll!=0) System.out.print(boll+"볼 ");
        if(strike!=0) System.out.print(strike+"스트라이크 ");
        if(boll==0&&strike==0) System.out.print("낫싱");
        System.out.println(); // '\n'
        //return
        if(strike==3) return 1;
        return 0;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            //init
            int[] human = new int[3];
            List<Integer> robot = new ArrayList<>();
            //robot random
            for (int i = 0; ; i++) {
                if(robot.size()==3) break;

                int num = Randoms.pickNumberInRange(1, 9);
                if(!robot.contains(num)) {
                    robot.add(num);
                }
            }
            System.out.println(robot.toString());
            //user
            while(true) {
                System.out.print("숫자를 입력해주세요 : ");
                try {
                    //input
                    String inStr = Console.readLine().toString();
                    int inNum = Integer.parseInt(inStr);
                    if (inStr.length()!=3) throw new IllegalArgumentException("자리수가 안맞습니다. 예외 강제 발생.");
                    for(int i = 0 ;i<3; i++) {
                        human[i] = inStr.charAt(i)-'0';
                        if(human[i] == 0) throw new IllegalArgumentException("1~9가 아닙니다. 예외 강제 발생.");
                    }
                    //run
                    int result = match(human, robot);
                    if(result == 1) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    }
                }
                catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자를 입력하세요. 예외 강제 발생.");
                }
            }
            //end
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int game = Integer.parseInt(Console.readLine());
            if(game==1) continue;
            else if(game==2) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 예외 강제 발생.");
            }
        }

    }
}
