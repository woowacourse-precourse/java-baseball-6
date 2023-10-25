# 🌈 구현할 기능 목록

# Game Model
## 멤버 변수

### String answer
정답을 저장하는 변수
### String userInput
유저가 추측한 정답을 저장하는 변수
### int ball
정답을 비교 했을 때 ball의 개수
### int strike
정답을 비교 했을 때 strike의 개수

## 멤버 함수
### void pickRandomNumbers()

3자리 랜덤 숫자를 만들고 answer에 저장하는 함수

### void checkAnswer()
userInput과 answer을 비교하는 함수

### String getHint()
유저의 추측에 대한 힌트를 내려주는 함수

### void setUserInput(String userInput)
userInput을 파라미터 값으로 초기화하는 함수

### boolean checkNothing()
Nothing인지 확인하는 함수

### boolean checkSuccess()
성공했는지 확인하는 함수

### boolean checkHint()
힌트가 필요한지 확인하는 함수

### void addBallCount()
ball에 1을 더해주는 함수

### void addStrikeCount()
strike에 1을 더해주는 함수

# GameController
## 멤버 변수

### Game game
### GameView gameView

## 멤버 함수

### void init()
게임을 초기화 하고 진행하는 함수로
무한 loop 안에서 게임을 진행하고 성공 시 탈출,
메인 함수에서 호출

# GameView

### void printStartGame()
게임 시작 문구를 출력하는 함수

### void printExitGame()
게임 종료 문구를 출력하는 함수

### String inputNumber()
유저가 추측한 숫자를 입력받는 함수

### boolean inputRestartOption()
게임 종료 시 재시작 옵션을 입력받는 함수

### boolean checkAndPrintResult(Game game)
추측 결과를 확인하고 그에 따른 결과를 출력하는 함수

### void validateUserInput(String userInput)
유저의 숫자 입력에 대해 유효성을 검사하는 함수

### void validateRestartOption(String option)
유저의 재시작 옵션 입력에 대해 유효성을 검사하는 함수