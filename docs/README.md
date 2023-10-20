
### 기능 목록
- 게임 진행하기
    ``` java
    void run()
    ```
- 게임 시작 알림 메세지 출력하기
    ``` java
    void printGameStart()
    ```
- 랜덤 숫자 초기화
    ``` java
    List<Integer> initRandomNum()
    ```
- 사용자 숫자 입력 받기
    ``` java
    List<Integer> inputUserNum()
    ```
- 사용자 입력 형식 확인하기
    ``` java
    void checkUserNumForm(List<Integer> userNum)
    ```
  
<br></br>
- 게임 결과 관련 기능들
  - 스트라이크 개수 세기
      ``` java
    int countStrikeNum(List<Integer> userNum, List<Integer> randomNum)
      ```
  - 볼 개수 세기
      ``` java
    int countBallNum(List<Integer> userNum, List<Integer> randomNum)
      ```
  - 3스트라이크 확인하기
      ``` java
    boolean checkAllStrike(List<Integer> userNum, List<Integer> randomNum)
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
    int inputGameEnd()
      ```
  - 게임 종료 여부 입력 형식 확인하기
    ``` java
    void checkEndForm(int endOption)
    ```
  - 게임 종료 여부 확인하기
      ``` java
    boolean checkGameEnd(int userChoice)
      ```
