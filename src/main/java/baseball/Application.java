package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        try {
            // TODO: 프로그램 구현
            boolean reGame = true;


            while(reGame) {
                reGame = false;
                System.out.println("숫자 야구 게임을 시작합니다.");
                List<Integer> computer = new ArrayList<>();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
                boolean retry = true;
                while (retry) {
                    System.out.println("숫자를 입력해주세요 :");
                    String userInput = readLine();
                    if(userInput.length()>3){
                        System.out.println("숫자는 3개만 입력해주세요");
                        throw new IllegalArgumentException();
                    }
                    int strikeCount = 0;
                    int ballCount = 0;
                    List<Integer> integerList = new ArrayList<>();
                    for (String s : userInput.split("")) {
                        integerList.add(Integer.parseInt(s));
                    }


                    System.out.println(computer);
                    //비교하는거
                    for (int userIndex = 0; userIndex < computer.size(); userIndex++) {
                        int userNum = integerList.get(userIndex);
                        //int userIndex = 0;
                        //for(Integer comNum : computer){
                        for (int ComIndex = 0; ComIndex < computer.size(); ComIndex++) {

                            if (userNum == (computer.get(ComIndex))) {
                                //스트라이크 일 경우
                                if (userIndex == ComIndex) {
                                    strikeCount++;
                                } else {
                                    // 볼 일 경우
                                    ballCount++;
                                }
                            }

                        }

                    }

                    //틀리면

                    //맞으면
                    if (strikeCount >= 3) {

                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        String askReGame = readLine();
                        if(askReGame.length()>1){
                            System.out.println("1 또는 2를 입력해주세요");
                            throw new IllegalArgumentException();
                        }
                        if (askReGame.equals("2")) {
                            System.out.println("종료");
                            reGame = false;
                            retry = false;
                        }else {
                            reGame=true;
                            retry = false;
                        }
                    } else {

                        System.out.println(strikeCount + "스트라이크");
                        System.out.println(ballCount + "볼");
                    }


                }
            }

        }catch (IllegalArgumentException e){

        }




    }
}
