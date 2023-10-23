## 프로그램 흐름
 ![1주차 흐름도](https://github.com/SeWooooong/CodingTest_Practice/assets/49395754/b7ea482b-2ab5-4141-94bc-0bd6f0f8296a)

## 구현할 기능 목록 정리
### Game
- class Game
  - 게임을 하기 위한 데이터들을 저장합니다.
- void computerNumberGeneration()
  - 컴퓨터의 랜덤한 숫자를 생성합니다.
- void calculateResult()
  - 유저의 수와 컴퓨터의 수를 비교하는 메서드 입니다.

### Controller
- void playGame()
  - 게임을 실행 시킵니다.
- void gameIsOver()
  - 게임을 그만 할 건지를 조사합니다.
- void modifyModel()
  - 유저의 숫자를 입력합니다.
  - 스트라이크와 볼의 숫자를 0으로 초기화 합니다.

### GameView
- void startGame()
  - 게임 시작을 출력합니다.
- String getUserInput()
  - 유저의 숫자를 입력 받습니다.
- boolean showResult()
  - 결과를 출력합니다.
  - 결과에 따라 리턴하는 boolean 값을 다르게해 게임에 종료를 선택할 수 있게 합니다.
- boolean playAgain()
  - 게임을 다시 시작할지 조사합니다.

### ErrorHandler
- void checkErrorUserNumber
  - userNumber의 에러를 획인합니다.
  - 숫자가 3자리를 넘어가거나 숫자가 아닐 경우 에러가 발생합니다.
- void checkErrorAgainNumber
  - againNumber의 에러를 확인합니다.
  - 1이나 2가 아니거나 숫자가 아닐경우 에러가 발생합니다.