package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computer = new ArrayList<>();
    static List<Integer> user = new ArrayList<>();
    private static void setGame(){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                System.out.println("컴퓨터 숫자 : " + randomNumber);
            }
        }
    }

    private static boolean isValidInput(String input){
        if (input.length() != 3) {
            return false;
        }

        char[] chars = input.toCharArray();
        if (chars[0] == chars[1] || chars[1] == chars[2] || chars[0] == chars[2]) {
            return false;
        }

        for (char c : chars) {
            if (c < '1' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        setGame();
        System.out.println("숫자 야구 게임을 시작합니다.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{
                System.out.print("숫자를 입력해주세요 : ");
                String input = br.readLine();

                if(isValidInput(input)){
                    for(char c : input.toCharArray()){
                        user.add(Integer.parseInt(String.valueOf(c)));
                    }
                }
                else{
                    throw new IllegalArgumentException("잘못된 입력입니다. 게임 종료");
                }

            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                break;
            }



        }
    }
}
