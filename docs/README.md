1. 게임이 시작되면서 컴퓨터가 임의의 숫자 생성
- 임의의 숫자는 서로 다른 수로 이루어진 3자리의 수
2. 사용자의 입력을 받아 해당 입력에 대한 결과 출력
- 사용자의 입력은 서로 다른 수로 이루어진 3자리의 수. 아니면 IllegalArgumentException
- 결과는 스트라이크, 볼, 낫싱
3. 숫자를 모두 맞히면 게임을 종료하고 재시작 묻기
4. 재시작이면 위의 과정 반복

GameModel
- int randomNumber
- boolean isSuccess

GameController
- boolean isRetry = true;
- isRetry가 true일 동안 run 실행
- runGame
  - makeGame: randomNumber 할당. 
  - handleGuess : 사용자 입력 받기, 입력에 대한 결과 반환하기 (3스트라이크이면 isSuccess=true)
- askRetry
  - 사용자 입력 받기
InputView, OutputView