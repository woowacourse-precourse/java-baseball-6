# 1주차 야구게임 기능명세서

___

### ***핵심 기능만 작성이 되어 있습니다.***

### ***최종 버전입니다.***

1. **BaseballGame 클래스**

- ```java
  public final static void turnOn()
  ```
  게임을 실행시킵니다.
- ```java
  private static void mainGame()
  ```
  게임을 진행합니다.
- ```java
  private static void setting()
  ```
  게임 시작 시 초기값을 셋팅 해줍니다.
- ```java
  private static void printBns(int[] bns)
  ```
  결과를 받아 결과를 호출하도록 다른 메소드를 호출합니다.
- ```java
  private static void newOrEnd()
  ```
  재시작할지 종료할지 판단합니다.
- ```java
  private static void exceptionCheck() throws IllegalArgumentException 
  ```
  유저가 입력한 값이 옳은지 판단하고 옳지 않다면 예외를 발생시킵니다.
  <br/><br/>

2. **BaseballOutput 클래스**

- ```java
  static void gameStart()
  ```
  게임 시작을 알립니다.
- ```java
  static void printInputUserNum()
  ```
  유저에게 숫자를 입력하라고 요구합니다.
- ```java
  static void printCall(BallCount... ballCounts)
  ```
  낫싱이 아닌 경우에 결과값을 출력합니다.
- ```java
  static void printCall()
  ```
  낫싱을 출력합니다.
- ```java
  static void printNewOrEnd()
  ```
  재시작 할 것인지 종료할 것인지 물어봅니다.
  <br/><br/>

3. **BaseModel 클래스**

- ```java
  static void newbaseballNumber()
  ```
  새로운 게임 시작 시 번호를 생성합니다.
- ```java
  static GameState newOrEnd(String userChoice)
  ```
  3스트라이크 시 유저의 입력에 따라 게임의 상태를 변화시킵니다.
- ```java
  static void exceptionCheck(String userChoice) throws IllegalArgumentException
  ```
  게임을 재시작 혹은 종료 입력이 옳은지 판단하고 옳지 않다면 예외를 발생시킵니다.
- ```java
  static void exceptionCheck(LinkedHashSet<Integer> userNumber) throws IllegalArgumentException
  ```
  게임 진행 중 올바른 값을 입력했는지 판단하고 옳지 않다면 예외를 발생시킵니다.
- ```java
  static int[] judgeNumber(Iterator<Integer> uNumber)
  ```
  유저가 입력한 숫자를 판단합니다.
  <br/><br/>

4. **기타 클래스**

- ```java
  public enum GameState
  ```
  게임 진행에 필요한 열거형 상수가 정의되어 있습니다.
- ```java
  public class NumberGenerator
  ```
  숫자를 생성합니다.
  
