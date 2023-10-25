# [우아한테크코스 프리코스 미션]
## 1주차 숫자 야구 게임
### 구현 기능
#### 1) 컴퓨터 랜덤값 지정
컴퓨터는 1~9사이의 3개의 자연수 랜덤으로 지정
```
public static List<Integer> make_computer() { // 컴퓨터의 랜덤값 지정
    List<Integer> com = new ArrayList<>();
    while (com.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!com.contains(randomNumber)) {
        com.add(randomNumber);
      }
    }
    return com;
  }
```

#### 2) 사용자 입력값 받기
사용자에게 3개의 자연수를 String으로 입력받은 후 List에 넣어주기
```
 public static List<Integer> get_user() { // 사용자의 입력값 받기
    List<Integer> us = new ArrayList<>();
    String s = Console.readLine();

    for (int i = 0; i < s.length(); i++) {
      int currenChar = Character.getNumericValue(s.charAt(i));
      us.add(currenChar);
    }

    return us;
  }
```

#### 3) GOSTOP
go, stop 여부를 int값으로 변환
```
  public static int gostop() { // 게임을 더 진행하는지 확인
    String s = Console.readLine();
    int result = Character.getNumericValue(s.charAt(0));
    return result;
  }
```

#### 4) 예외처리
사용자가 3개의 자연수가 아닌 값을 입력할 경우 예외발생
```
if (user.size() < 3 || user.size() > 3) {
        throw new IllegalArgumentException();
      }
```

#### 5) 문자열 비교하기
```
// 문자열 확인하기
      for (int i = 0; i < user.size(); i++) {
        for (int j = 0; j < user.size(); j++) {
          if (computer.get(i) == user.get(j)) {
            if (i == j) {
              strike++;
            } else {
              ball++;
            }
          }
        }
      }
```

#### 6) 게임결과 출력하기
```
// 게임 결과 출력
      if (ball != 0) {
        System.out.print(ball + "볼 ");
      }
      if (strike != 0) {
        System.out.print(strike + "스트라이크");
      }
      if (ball == 0 && strike == 0) {
        System.out.print("낫싱");
      }
```
