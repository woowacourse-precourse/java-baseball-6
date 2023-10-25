package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        //RandomNumber 상대방 플레이어 난수 값 생성
//        String Restart = "1";

        while (true){
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요 : ");
            String tempNum = Console.readLine();
            List<Integer> Player = generatePlayer.PlayerNumber(tempNum);
//            System.out.println(Player);
            List<Integer> Rival_Player = generateRival.RivalNumber();
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < 3; i++) {
                int comNum = Rival_Player.get(i);
                int myNum = Player.get(i);

                if (comNum == myNum) {
                    strike++;
                    continue;
                }
                if (comVisited[myNum]) {
                    ball++;
                }


            }
//            System.out.println(Rival_Player);
//            Restart = Console.readLine();
            }

            }
    }

