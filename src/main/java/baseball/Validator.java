package baseball;

import static baseball.Type.getAllKinds;

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
      this.inputList.add(new Baseball(Integer.parseInt(inputArr[i]), i));
    }
  }

  public void changeInputBaseballType() {
    for(Baseball baseball : inputList) {
      baseball.checkType(randomList);
    }
  }

  public Map<String, Integer> calculateResult() {
    Map<String, Integer> scoreBoard = writeScoreBoard();
    for(Baseball baseball : inputList) {
      baseball.calculate(scoreBoard);
    }
    return scoreBoard;
  }

  private Map<String, Integer> writeScoreBoard() {
    Map<String, Integer> scoreBoard = new HashMap<>();
    for(String type : getAllKinds()) {
      scoreBoard.put(type, 0);
    }
    return scoreBoard;
  }

  public boolean answerOfProgress(String answer) {
    if(answer.equals("1")) {
      return true;
    }
    return false;
  }

}
