# 숫자야구 기능목록

- 컴퓨터와 사용자가 게임을 플레이한다.
- 컴퓨터는 랜덤으로 범위내에 있는 숫자 3개를 선정하고 보유한다.
- 사용자는 콘솔을 통해 숫자 3개를 입력하고 추론의 결과를 제공 받는다.
  - 이때, 추론의 결과는 게임 관리자가 제공한다.
- 게임 관리자는 사용자의 추론의 결과를 제공할 뿐만 아니라, 전반적인 게임의 흐름을 관리한다.

## 1. Computer

- `setRandomNumList()`: 컴퓨터는 범위 내의 서로 다른 숫자 3개를 생성한다.
- `getNumList()`: 숫자 리스트를 반환한다.

## 2. User

- GuessVo 필드를 가지고 있다.

## 3. GameManager

- `gameStart()`: 안내 메시지를 보여주며 게임이 시작된다.
- `readUserGuess()`: 사용자로부터 3개의 숫자를 입력받고 `GuessVo`인스턴스를 반환한다.
- `validateUserGuess()`: `GuessVo`인스턴스를 보고 검증하고, 실패시 `IllegalArgumentException`를 발생시킨다.
- `checkUserGuess()`: 사용자의 추론을 실제 컴퓨터가 가지고 있는 값을 비교하여 `ResultGuessVo` 인스턴스를 변환한다.
- `printResultGuess()`: `ResultGuessVo` 인스턴스의 값을 바탕으로 ?볼 ?스트라이크 또는 낫싱을 출력한다.
- `isFinished()`: `ResultGuessVo` 인스턴스를 보고 3스트라이크인지 판단한다.
- `printEndAndRestartMessage()`: 게임 종료 메시지와 재시작 메시지를 출력한다.
- `validateUserRestart()`: 사용자로부터 입력 받은 재시작 값을 검증하고, 실패시 `IllegalArgumentException`를 발생시킨다.

## 4. ResultGuessVo

- 볼의 개수를 의미하는 필드와 스트라이크의 개수를 의미하는 필드 2가지를 가진다.

## 5. GuessVo

- 사용자에게 입력받은 숫자 3개를 List로 저장한다.
