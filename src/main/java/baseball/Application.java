package baseball;

import static baseball.Type.*;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class Baseball {

    // 야구공 타입 - None, 스트라이크, 볼
    Type type;

    // 야구공 숫자
    int number;

    // 야구공의 위치
    int index;

    public Baseball(Type type, int number, int index) {
        this.type = type;
        this.number = number;
        this.index = index;
    }

    public void changeType(Type type) {
        this.type = type;
    }
}


public class Application {
    public static void main(String[] args) {

        //2. 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        //3. 입력 문구 및 숫자 입력
        boolean isContinued = true;

        while(isContinued) {
            //1. 난수 생성
            List<Integer> computer = new ArrayList<>();
            String computerRandom = "";
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                    computerRandom += String.valueOf(randomNumber);
                }
            }

            int randomNumber = Integer.parseInt(computerRandom);
            System.out.println(randomNumber);
            boolean isFinished = true;

            //4. 랜덤 숫자와 입력 숫자를 비교하는 과정
            while (isFinished) {
                System.out.print("숫자를 입력해주세요 : ");

                int number = Integer.parseInt(Console.readLine());

                System.out.println(validator(randomNumber, number));
                if (randomNumber == number) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int continued = Integer.parseInt(Console.readLine());
                    if (continued == 2) {
                        isFinished = false;
                        isContinued = false;
                    } else {
                        isFinished = false;
                    }
                }
            }
        }

    }

    public static String validator(int randomNum, int num) {
        //스트라이크 검증기와 볼 검증기는 다르게 검증할 수 있을까?
        //볼을 먼저 검증하고, 그 다음으로 스트라이크를 검증해야게따.
        int ball = 0;
        int strike = 0;

        String[] splitRandom = String.valueOf(randomNum).split("");
        String[] splitInput = String.valueOf(num).split("");

        ArrayList<String> randomList = new ArrayList<>();
        ArrayList<Baseball> inputList = new ArrayList<>();

        for(int i=0; i<3; i++) {
            randomList.add(splitRandom[i]);
            inputList.add(new Baseball(NONE, Integer.parseInt(splitInput[i]), i));
        }

        for(Baseball baseball : inputList) {
            String baseballNumber = String.valueOf(baseball.number);
            if(randomList.contains(baseballNumber)) {
                if(randomList.indexOf(baseballNumber) == baseball.index) {
                    baseball.changeType(STRIKE);
                } else {
                    baseball.changeType(BALL);
                }
            }
        }

        for(Baseball baseball : inputList) {
            if(baseball.type == STRIKE) {
                strike++;
            } else if(baseball.type == BALL) {
                ball++;
            }
        }

        if(strike==0 && ball==0) {
            return "낫싱";
        } else if(strike!=0 && ball==0) {
            return strike + "스트라이크";
        } else if(strike==0 && ball!=0) {
            return ball + "볼";
        } else {
            return ball + "볼 " + strike + "스트라이크";
        }

    }
}
