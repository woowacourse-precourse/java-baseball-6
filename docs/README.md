
### 기능 목록
- 게임 진행 반복하기
    ``` java
    void run()
    ```
- 게임 진행하기
    ``` java
    void playGame()
    ```
- 게임 시작 알림 메세지 출력하기
    ``` java
    void printGameStart()
    ```
- 랜덤 숫자 초기화
    ``` java
    List<Integer> initRandomNum()
    ```
<br></br>
- 사용자 입력
  - 사용자 숫자 입력 받기
      ``` java
      List<Integer> inputUserNum()
      ```
  - 사용자 입력 형식 확인하기
      ``` java
      void checkUserNumForm(String userInput)
      ```
  - 사용자 입력 중복 숫자 확인
      ``` java
      boolean isDuplicatedNum(String userInput)
      ```
  - 사용자 입력 정수인지 확인
      ``` java
      boolean isInteger(String userInput)
      ```
  - 3자리 수인지 확인
      ``` java
      boolean isThreeDigits(String userInput)
      ```
  - 음수인지 확인
      ``` java
      boolean isNegative(String userInput)
      ```
    
<br></br>
  - 게임 결과 관련 기능들
    - 스트라이크와 볼 개수 세기
        ``` java
      Map<String, Integer> countStrikeAndBall(List<Integer> userNum, List<Integer> randomNum)
        ```
    - 스트라이크와 볼 개수 초기화
        ``` java
      void initStrikeAndBallNum(Map<String, Integer> resultList)
        ```
    - 3스트라이크 확인하기
        ``` java
      boolean isAllStrike(Map<String, Integer> resultList)
        ```
    - 결과 출력하기
        ``` java
      void printGameResult(Map<String, Integer> returnList)
        ```
    - 3스트라이크 시 성공 메세지 출력하기
        ``` java
      void printWinGame()
        ```
    
<br></br>
- 게임 종료 관련 기능들
  - 게임 종료 여부 입력 받기
      ``` java
    int inputEndOption()
      ```
  - 게임 종료 여부 입력 형식 확인하기
    ``` java
    void checkEndOptionForm(String endOption)
    ```
  - 게임 종료 여부 확인하기
      ``` java
    boolean isGameEnd(int endOption)
      ```
