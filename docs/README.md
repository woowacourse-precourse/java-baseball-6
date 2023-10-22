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

## ✅  Application.java 구조 Ver.1
```java
// Main Application
public class Application {
  public static void main(String[] args) throws IllegalArgumentException {
    // TODO: 프로그램 구현
    BaseballGame Game = new BaseballGame();
    Game.Run();
  }
};

// 야구 게임의 클래스 선언
Class BaseballGame{

    // 메서드 ( Method )
    
    // 게임 실행부 
    public void Run(){};

    // 사용자의 숫자 입력을 받는 부분
    public void GetUser(){};
    
    // 컴퓨터가 자신의 랜덤 숫자 3가리를 선정하는 부분
    public void GetComputer(){};
    
    // 스트라이크 점수를 추가하는 함수
    public void AddStrike(){};
    
    // 볼 점수를 추가하는 함수
    public void AddBall(){};
    
    // 점수를 초기화 하는 함수
    public void ClearScore(){};
    
    // 두개의 숫자에 대해 점수 계산을 진행하는 함수
    public void CheckNumber(){};
    
    // 점수를 확인하고 출력 및 종료와 재시작 여부를 판단하는 코드
    public void CheckScore(){};
    
    // 게임 종료시 유저에게 1과 2를 입력받는 함수
    public void CheckEnd(){};
    
}
```

## ✅  Application.java 구조 Ver.2
```java
public class Application {
  public static void main(String[] args) throws IllegalArgumentException {
    // TODO: 프로그램 구현
    BaseballGameManager newGame = new BaseballGameManager();
    newGame.start();
  }
};

class BaseballGameManager{
    
    // 야구 게임을 시작합니다.
    public void startGame(){
    };
    
    // 유저에게 숫자를 입력받습니다.
    public void getUserNumberInput(){
    };
    
    // 게임의 재시작 여부를 입력받습니다.
    public void getGameFinishInput() {
    };


}
class BaseballGame {

    // 컴퓨터가 사용할 숫자를 저장할 리스트
    List<Integer> computerNumbers = new ArrayList<>();

    // 유저가 사용할 숫자를 저장할 리스트
    List<Integer> userNumbers = new ArrayList<>();

    // 스트라이크 갯수
    int strikeCount;

    // 볼 갯수
    int ballCount;

    // 게임 종료 여부를 확인하기 위한 정수
    int gameFinish;

    // User가 입력한 userRoundNumber가 길이가 3인지 확인합니다.
    public boolean checkUserInputlength(String userInput){
    } 
    
    // userNumber Array에 숫자를 삽입합니다.
    public void addUserNumber(int userNumber){
    }
    
    // userNumber Array를 초기화합니다.
    public void resetUserNumber(){
    }

    // 유저가 입력한 숫자에서 중복값을 확인
    public void checkUserForDuplicates() {
    }

    // 컴퓨터가 게임에 사용할 숫자를 새로 갱신합니다.
    public void generateComputerNumbers() {
    }

    // 스트라이크 갯수를 증가시킵니다.
    public void incrementStrikeCount() {
    }

    // 볼 갯수를 증가시킵니다.
    public void incrementBallCount() {
    }

    // 스트라이크와 볼 갯수를 초기화합니다.
    public void resetScores() {
    }

    // Strike의 갯수를 반환합니다.
    public int getStrikeCount() {
    }

    // Ball의 갯수를 반환합니다.
    public int getBallCount() {
    }

}


class OutputView{
    
    // 게임의 시작 문구를 출력합니다.
    public void startGameAnnouncement(){
    }
    
    // 유저에게 숫자를 입력해달라는 문구를 출력합니다.
    public void promptUserForRoundGuess() {
    }

    // 매 라운드의 숫자 야구에서 스트라이크를 출력합니다.
    public void printStrike(int strikeCount) {
    }

    // 매 라운드의 숫자 야구에서 볼을 출력합니다.
    public void printBall(int ballCount) {
    }

    // 매 라운드의 숫자 야구에서 아무 것도 출력하지 않습니다.
    public void printNothing() {
    }

    // 매 라운드의 숫자 야구에서 스트라이크와 볼을 출력합니다.
    public void printBoth(int strikeCount, int ballCount) {
    }


};
```

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