package Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallServiceImpl implements BallService {
    static private BallServiceImpl service = new BallServiceImpl();

    private StringBuffer randomNumber; //랜덤 숫자 저장할 변수
    private boolean[] checkNumber; //입력한 숫자 중복 체크용

    private BallServiceImpl() {
        randomNumber = new StringBuffer();
        checkNumber = new boolean[10];
        generateRandomNumber();
    }

    static public BallServiceImpl getInstance() {
        return service;
    }

    @Override
    public void generateRandomNumber() { //랜덤 숫자를 생성
        randomNumber.delete(0, randomNumber.length()); //랜덤 숫자 초기화
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        for (Integer i : computer) {
            randomNumber.append(i.toString());
        }
    }

    @Override
    public boolean isValidation(String ballCount) {// 입력 유효성 검사
        Arrays.fill(checkNumber, false); //중복체크를 위한 bolean형 배열 false로 초기화
        if (ballCount.length() != 3) { //길이가 3이 아닐경우
            return false;
        }

        for (int i = 0; i < ballCount.length(); i++) {
            char number = ballCount.charAt(i);
            if (number < '1' || number > '9') { // 1 ~ 9 가 아닐경우
                return false;
            }
            
            if (checkNumber[number - '0']) { //이미 중복된 숫자가 있는 경우
                return false;
            }
            checkNumber[number - '0'] = true;
        }
        return true;
    }

    @Override
    public boolean startGame(String ballCount) { //게임 시작!
        if (!isValidation(ballCount)) {
            throw new IllegalArgumentException("Wrong Input!!");
        }
        System.out.println("랜덤" + randomNumber);
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (randomNumber.charAt(i) != ballCount.charAt(j)) {//랜덤 숫자와 입력한 숫자가 다를 경우
                    continue;
                }

                if (i == j) { //자리에 있는 숫자가 같을 때 스트라이크!
                    strike++;
                } else if (i != j) { //자리는 다르지만 같은 숫자가 있을 때 볼!
                    ball++;
                }
            }
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
            if (strike == 3) {
                return true;
            }
        }
        return false;
    }
}
