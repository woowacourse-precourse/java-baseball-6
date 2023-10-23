package baseball;

import static baseball.Type.BALL;
import static baseball.Type.NONE;
import static baseball.Type.STRIKE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Validator {
  int randomNumber;
  int inputNumber;
  ArrayList<String> randomList = new ArrayList<>();
  ArrayList<Baseball> inputList = new ArrayList<>();

  public Validator(int randomNumber) {
    this.randomNumber = randomNumber;
  }

  //야구공 숫자를 맞추는 대답을 작성하는 메서드
  public String writeBaseballAnswer(String inputValue) {
    validateContainsSpace(inputValue);
    validateOnlyNumber(inputValue);
    validateLengthThree(inputValue);
    validateDuplicate(inputValue);
    validateZero(inputValue);
    return inputValue;
  }

  public String writeProgressAnswer(String inputValue) {
    validateContainsSpace(inputValue);
    validateOnlyNumber(inputValue);
    validateOneOrTwo(inputValue);
    return inputValue;
  }

  public void validateContainsSpace(String input) {
    String trimmedValue = input.trim();
    if(input.length() != trimmedValue.length()) {
      throw new IllegalArgumentException("공백을 제거하고 입력해주세요.");
    }
  }

  public void validateOnlyNumber(String input) {
    try {
      int inputInteger = Integer.parseInt(input);
    } catch(IllegalArgumentException e) {
      throw new IllegalArgumentException("숫자만 입력해주세요.");
    }
  }

  public void validateLengthThree(String input) {
    if(input.length() != 3) {
      throw new IllegalArgumentException("3개의 숫자로 입력해주세요.");
    }
  }

  public void validateDuplicate(String input) {
    Set<Character> set = new HashSet<>();
    for(char each : input.toCharArray()) {
      set.add(each);
    }
    if(set.size() != input.length()) {
      throw new IllegalArgumentException("서로 다른 3개의 숫자로 입력해주세요.");
    }
  }

  public void validateZero(String input) {
    if(input.contains("0")) {
      throw new IllegalArgumentException("1과 9 사이의 숫자만 입력해주세요.");
    }
  }

  public void validateOneOrTwo(String input) {
    if(!(input.equals("1") || input.equals("2"))) {
      throw new IllegalArgumentException("1과 2 중 하나만 선택해주세요.");
    }
  }

  public void init() {
    String[] splitRandom = String.valueOf(randomNumber).split("");
    String[] splitInput = String.valueOf(inputNumber).split("");
    addToList(splitRandom, splitInput);
  }

  public void addToList(String[] randomArr, String[] inputArr) {
    for(int i=0; i<3; i++) {
      this.randomList.add(randomArr[i]);
      this.inputList.add(new Baseball(NONE, Integer.parseInt(inputArr[i]), i));
    }
  }

  //TODO: 해당 로직 리팩토링 필요
  public void changeInputBaseballType() {
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
  }

  public Map<String, Integer> calculateResult() {
    Map<String, Integer> resultTable = new HashMap<>();
    int ball = 0;
    int strike = 0;
    resultTable.put("스트라이크", 0);
    resultTable.put("볼", 0);

    for(Baseball baseball : inputList) {
      if(baseball.type == STRIKE) {
        resultTable.put("스트라이크", resultTable.get("스트라이크") + 1);
//        strike++;
      } else if(baseball.type == BALL) {
        resultTable.put("볼", resultTable.get("볼") + 1);
//        ball++;
      }
    }
    return resultTable;
  }

  public boolean answerOfProgress(String answer) {
    if(answer.equals("1")) {
      return true;
    }
    return false;
  }

}
