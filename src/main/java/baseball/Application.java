package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) throws IOException {
        int restart = 0;

        while (restart!=2) {
            List<Integer> computer = makeNum(); //임의의 세 개 값 만들기

            while (true) {
                String s;
                List<Integer> nums = new ArrayList<>();

                int strike = 0;
                int ball = 0;


                System.out.print("숫자를 입력해주세요 : ");


                s = Console.readLine();

                String[] arr = s.split("");

                //사용자가 세 개 미만 혹은 초과의 숫자를 입력할 경우 오류 표시
                if (arr.length != 3) {
                    throw new IllegalArgumentException("3개가 아닌 숫자를 입력했습니다. 에러 발생");
                }


                for (int i = 0; i < arr.length; i++) {
                    //세 자리 입력값이 1~9 사이의 숫자인지 확인. 아닐 경우 오류 표시
                    if (!Pattern.matches("[1-9]",arr[i])){
                        throw new IllegalArgumentException("1~9사이의 숫자가 아닙니다. 에러 발생");
                    }
                    nums.add(Integer.parseInt(arr[i]));
                }

                //사용자가 입력한 값 중 중복의 숫자가 있을 경우 에러 발생
                if (nums.get(0).equals(nums.get(1)) || nums.get(0).equals(nums.get(2)) || nums.get(1).equals(nums.get(2))) {

                    throw new IllegalArgumentException("중복된 숫자를 입력했습니다. 에러 발생");
                }


                for (int j = 0; j < 3; j++) {
                    if (computer.get(j).equals(nums.get(j))) {
                        strike += 1;
                    } else if (!nums.get(j).equals(computer.get(j)) && computer.contains(nums.get(j))) {
                        ball += 1;
                    }
                }

                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike != 0 && ball != 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else if (strike == 0 && ball != 0) {
                    System.out.println(ball + "볼");
                } else if (strike != 0 && ball == 0 && strike != 3) {
                    System.out.println(strike + "스트라이크");
                } else if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;

                }


            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String IsEnd = Console.readLine();
            if(!IsEnd.equals("1") && !IsEnd.equals("2")) {
                throw new IllegalArgumentException("1 혹은 2가 아닌 값을 입력했습니다. 에러 발생");
            }
            restart = Integer.parseInt(IsEnd);




        }
    }

    private static List<Integer> makeNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }




}