package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Computer {
    private List<Integer> numbers;

    //랜덤 숫자 3개 만들기 함수
    public void GenerateRandomNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        this.numbers = numberList;
    }

    //제출값 결과 반환
    public String submitAnswer(String inputNumber) {
        //인풋 값 검증
        if (!isNumberAndIsSizeThree(inputNumber)) {
            throw new IllegalArgumentException();
        }
        //String -> List<int> 로 변환
        List<Integer> intInputNumbers = parseIntList(inputNumber);

        //서로 다른값인지 검증
        if (containSameNumber(intInputNumbers)) {
            throw new IllegalArgumentException();
        }

        //컴퓨터는 플레이어의 숫자 3개를 보고 볼, 스트라이크, 아웃을 판단한다(3)
        return inputNumberResult(intInputNumbers);
    }

    //볼, 스트라이크, 아웃 판단 함수
    private String inputNumberResult(List<Integer> playerInputNumbers) {
        int strike = 0;
        int ball = 0;

        //스트라이크 판단
        for (int i = 0; i < this.numbers.size(); i++) {
            if (this.numbers.get(i).equals(playerInputNumbers.get(i))) {
                strike++;
            }
        }

        //볼 판단
        for (int i = 0; i < this.numbers.size(); i++) {
            for (int j = 0; j < this.numbers.size(); j++) {
                if (i != j) {
                    if (this.numbers.get(i).equals(playerInputNumbers.get(j))) {
                        ball++;
                    }
                }
            }
        }

        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        if (strike == 0) {
            return ball + "볼";
        }

        if (ball == 0) {
            return strike + "스트라이크";
        }

        return ball + "볼 " + strike + "스트라이크";
    }

    //입력으로 받은 String값이 3자리 숫자인지 검증크는 코드
    private Boolean isNumberAndIsSizeThree(String str) {
        // 패턴을 이용하여 1~9 까지의 3자리 숫자인지 검증(공백)
        String pattern = "^[1-9]{3}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);

        return m.matches();
    }

    //String -> List<Integer>
    private List<Integer> parseIntList(String str) {
        String[] numbers = str.split("");
        List<Integer> numbersToInt = new ArrayList<>();
        for (String number : numbers) {
            int numberToInt = Integer.parseInt(number);
            numbersToInt.add(numberToInt);
        }
        return numbersToInt;
    }

    //같은 숫자가 있는지 검증하는 함수
    private Boolean containSameNumber(List<Integer> integerList) {
        if (integerList.size() > 1) {
            for (int i = 0; i < integerList.size() - 1; i++) {
                for (int j = (i + 1); j < integerList.size(); j++) {
                    if (integerList.get(i).equals(integerList.get(j))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
