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
- void modifyUserNumber()
  - 입력 받은 유저 숫자를 토대로 유저 숫자를 업데이트 합니다.

### GameView
- void startGame()
  - 게임 시작을 출력합니다.
- int getUserInput()
  - 유저의 숫자를 입력 받습니다.
- void showResult()
  - 결과를 출력합니다.
- boolean playAgain()
  - 게임을 다시 시작할지 조사합니다.