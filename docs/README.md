# 기능 요구 사항

## 만들어야하는 기능

### 1. 컴퓨터 랜덤 숫자 생성 (computer_num_create)

주어진 라이브러리를 활용한다.

~~~ java
public static List<Integer> computer_num_create() {
    List<Integer> computer_num = new ArrayList<>();
    while (computer_num.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!computer_num.contains(randomNumber)) {
        computer_num.add(randomNumber);
      }
    }
    return computer_num;
  }
~~~

<br>

### 2. 사용자의 숫자를 받아온다.

주어진 라이브러리를 활용한다.

~~~ java
public static String user_num_crete() { // 사용자 숫자 받아오기
    System.out.print("숫자를 입력해주세요 :");
    String user_num = Console.readLine();
    return user_num;
  }
~~~

<br>
예외처리를 해야 하므로 소스를 추가한다.  

~~~ java
public static String user_num_crete(){ // 사용자 숫자 받아오기
    System.out.print("숫자를 입력해주세요 :");
    String user_num=Console.readLine();
    containsDuplicates(user_num);
    isStringLengthCorrect(user_num);
    checkThreeDigitNumber(user_num);
    return user_num;
    }
~~~

<br>

### 3. 숫자가 맞는지 확인 (check_num)

컴퓨터의 숫자는 리스트의 형태  
사용자의 숫자는 문자열의 형태  
<code>.get(index)</code> 는 해당 인덱스의 값을 반환한다.  
for문을 통해 값을 비교해서 같다면 인덱스 값을 비교  
같다면 strike를 1 증가  
다르면 ball을 1 증가한다.

~~~ java
public static int[] check_num(List<Integer> com_num, String user_num) {
    int strike = 0;
    int ball = 0;
    for (int i = 0; i < user_num.length(); i++) {
      for (int j = 0; j < com_num.size(); j++) {
        if ((int) user_num.charAt(i) - 48 == com_num.get(j)) {
          if (i == j) {
            strike += 1;
          } else {
            ball += 1;
          }
        }
      }
    }
    return new int[]{strike, ball};
  }
~~~

<br>

### 4. 결과 출력하기 (result_print)

1) 만약 strike가 3개라면 종료 멘트
2) strike와 ball 모두 0이 아니라면 ball과 strike 개수 출력
3) strike만 0이 아니라면 strike개수출력
4) ball만 0이 아니라면 ball개수 출력

~~~ java
public static int result_print(int[] result) {
    int strike = result[0];
    int ball = result[1];
    if (ball == 0 && strike == 0) {
      System.out.println("낫싱");
    } else if (ball == 0 && strike > 0) {
      System.out.println(strike + "스트라이크");
      if (strike == 3) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return 1;
      }
    } else if (ball > 0 && strike == 0) {
      System.out.println(ball + "볼");
    } else if (ball > 0 && strike > 0) {
      System.out.println(ball + "볼 " + strike + "스트라이크");
    }
    return 0;
  }
~~~

<Br>

## 예외처리 생각하기

### 1. 3자리를 입력하였는지 확인 (isStringLengthCorrect)

~~~ java
public static void isStringLengthCorrect(String user_num)
      throws IllegalArgumentException { // 자리수 검사
    if (user_num.length() != 3) {
      throw new IllegalArgumentException("3자리를 입력하세요.");
    }
  }
~~~

<br>

### 2. 중복된 숫자가 있는지 확인한다. (isStringLengthCorrect)

~~~ java
public static void containsDuplicates(String user_num)
      throws IllegalArgumentException { // 중복되었는지 검사
    int first = user_num.charAt(0);
    int second = user_num.charAt(1);
    int third = user_num.charAt(2);
    if (first == second || second == third || first == third) {
      throw new IllegalArgumentException("중복된 숫자 입니다.");
    }
  }
~~~

<br>

### 3. 재시작 또는 종료를 할 때  1 또는 2를 제외한 값을 입력하였는지 확인한다. (containsDuplicates)

~~~ java
 public static void handleInvalidInput(String user) throws IllegalArgumentException { // 1또는 2 검사
    if (!user.equals("1") && !user.equals("2")) {
      throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }
  }
~~~

<br>

### 4. 사용자가 문자를 입력하였는 확인한다. (checkThreeDigitNumber)

~~~ java
public static void checkThreeDigitNumber(String user_num)
      throws NumberFormatException { // 입력된 문자열에 문자가 있는지 확인
    for (char c : user_num.toCharArray()) {
      if (!Character.isDigit(c)) {
        throw new NumberFormatException("문자가 포함되어 있습니다.");
      }
    }
  }
~~~

## 전체적인 game 메소드 생성

~~~ java
public static void game() {
    int[] strike_ball;
    int result = 0;
    List<Integer> com_num = computer_num_create();
    while (result == 0) {
      String user_num = user_num_crete();
      strike_ball = check_num(com_num, user_num);
      result = result_print(strike_ball);
    }
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String user = Console.readLine();
    handleInvalidInput(user);
    if (Objects.equals(user, "1")) {
      game();
    }
  }
~~~