## 🚀 기능 요구 사항
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
  - 예) 상대방(컴퓨터)의 수가 425일 때
    - 123을 제시한 경우 : 1스트라이크
    - 456을 제시한 경우 : 1볼 1스트라이크
    - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다. 
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## ✅  개발 진행상황
### 1️⃣ 2023-10-20
- README.md 클래그 초기 구현 목록 작성
- Public void GetComputer()
  - 컴퓨터가 게임에서 사용할 Int형 배열 Computer생성 메서드 추가
- Application에서 BaseballGame의 메서드 사용을 위한 인스턴스 생성 코드 추가
- 사용자 입력에서 3개가 아닌 문자열을 입력했을 경우 오류 발생 상황 추가

### 2️⃣ 2023-10-21
- MVC 패턴을 이용한 구현 방식으로 구현의 구조도 변경
- 사용자에게 보여주는 출력을 담당하는 OutputView관련 코드 일부 추가

### 3️⃣ 2023-10-22
- MVC 패턴의 5가지 규칙과 구조를 생각하며 코드 Ver.3 완성 및 테스트
- 사용자 입력에서 정수가 아닌 다른 문자열을 입력했을 때의 오류 발생 상황
- 사용자 입력에서의 중복값과 0을 입력했을 때의 오류 발생 상황 추가

### 3️⃣ 2023-10-23
- Model의 내부 변수들 캡슐화를 위해 private로 선언


- 하나의 Method내에서 여러가지 기능을 하는 함수 쪼개기
  - `model.generateComputerNumbers();`
  - `model.calculateScore();`


- 입력값의 크기 상수화

   `public static final int *ROUND_SIZE* = 3;`

   `public static final int *FINISH_SIZE* = 1;`

   `public static final int *GAME_FINISH* = 2;`

   `public static final int *GAME_RESTART* = 1;`


- 함수의 순서 변경
  - 코드의 가독성을 높이기 위해 함수들의 순서를 일부 수정합니다.


## ✅  Application.java 구조 Ver.3
```java
// Main Application
public class Application {
  public static void main(String[] args) throws IllegalArgumentException {
    BaseballGameManager newGame = new BaseballGameManager();
    newGame.start();
  }
}

// 야구 게임의 클래스 선언
// Controller
class BaseballGameManager{
    
    // Variable
    BaseballGame model;
    OutputView view;
  
    // Constructor 
    public BaseballGameManager(){}

    // Methods
    public void start() throws IllegalArgumentException {}
  
    public void loadNewGame() throws IllegalArgumentException {}
  
    public void prepareForNewGame(){}
  
    public void getUserNumberInput() throws IllegalArgumentException {}
  
    public void getUserFinishInput() throws IllegalArgumentException{}
      
    public void printRoundScore(){}
}

// Model
class BaseballGame {

  // Variables
  List<Integer> computerNumbers;
  List<Integer> userNumbers;
  List<Integer> finishNumbers;
  int strikeCount;
  int ballCount;
  int gameFinish;
  int userInputInteger;
  String userFinishInput;
  String userRoundInput;

  // Constructor
  public BaseballGame() {}

  // Methods
  public boolean checkGameFinish(){}
  
  public void setFinishNumbers(){}

  public void readLineFinishInput(){}

  public void checkUserFinishNumberLength() throws IllegalArgumentException{}

  public void finishNumberConvertStringToInt() throws IllegalArgumentException{}

  public void readLineRoundInput(){}

  public void checkUserRoundNumberLength() throws IllegalArgumentException{}

  public void roundNumberConvertStringToInt() throws IllegalArgumentException{}

  public void roundNumberConvertIntToArraylist() throws IllegalArgumentException{}

  public void resetUserRoundNumbers(){}

  public void resetComputerNumbers(){}

  public boolean checkUserNumberForDuplicates(int insertNumber){}

  public boolean checkUserNumberForZero(int insertNumber){}

  public void generateComputerNumbers() {}

  public void calculateScore(){}

  public void incrementStrikeCount() {}
  
  public void incrementBallCount() {}
  
  public void resetScores() {}
  
  public int getStrikeCount() {}
  
  public int getBallCount() {}

}

// View
class OutputView{
  public void startGameAnnouncement(){}

  public void prinfFinishAnnouncement(){}

  public void promptUserForRoundGuess() {}
  
  public void printStrike(int strikeCount) {}
  
  public void printBall(int ballCount) {}
  
  public void printNothing() {}
  
  public void printBoth(int strikeCount, int ballCount) {}

}
```