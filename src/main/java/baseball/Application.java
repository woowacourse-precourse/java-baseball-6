package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws IllegalAccessException {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        int strike = 0;
        int ball = 0;
        String restart = "";

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        //컴퓨터와 플레이어의 수 리스트 생성
        ArrayList<Integer> computer = new ArrayList<>();
        ArrayList<Integer> player = new ArrayList<>();

        // 컴퓨터의 수 3개 생성
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        while (true){
            player.clear();
            ball = 0;
            strike =0;

            // 수 입력받기 3개 숫자 예외처리하자
            System.out.print("숫자를 입력해주세요 : ");
            try {
                String com = br.readLine();
                for (int i = 0; i < 3; i++) {
                    player.add(Integer.parseInt(com.split("")[i]));
                }
            } catch (NullPointerException | IOException e){
                throw new IllegalArgumentException();
            }

            //스트라이크, 볼 판별하기
            for (int i = 0; i < computer.size(); i++) {
                if (computer.get(i).equals(player.get(i))){
                    strike++;
                    ball--;
                }
            }

            for (int i = 0; i < computer.size(); i++){
                for (int j = 0; j < player.size(); j++){
                    if (computer.get(i).equals(player.get(j))){
                        ball++;
                    }
                }
            }

            if(ball <= 0){
                ball = 0;
            }

            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
                continue;
            }
            System.out.println(ball + "볼 " + strike + "스트라이크");
            if(strike == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                try {
                    restart = br.readLine();
                } catch (NullPointerException | IOException e){
                    throw new IllegalArgumentException();
                }

                if(restart.equals("2")){
                    break;
                }

                computer.clear();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
            }

        }

    }
}
