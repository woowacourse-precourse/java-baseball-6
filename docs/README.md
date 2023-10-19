# 📚 기능목록
## 👨‍🦱 사용자 정보 - Player
> 사용자와 관련된 정보 및 기능이 있는 도메인 클래스
- ballCount, strikeCount
  - 볼, 스트라이크 개수
- 정답 숫자와 비교한다. - ``compareToAnswerNumbers``
  - 예외 처리 - ``validateInputNumbers``
    - 🚫 입력된 숫자가 3자리 수가 아닌 경우
    - 🚫 입력된 숫자에 0이 포함될 경우
- 정답 숫자와 동일한지 확인한다. - ``isEqualToAnswerNumbers``
</br>

## 💻 상대방 정보 - Opponent
> 정답과 관련된 정보 및 기능이 있는 도메인 클래스
- answerNumbers
  - 1에서 9까지 서로 다른 임의의 수 3개로 구성된다.
- 정답 숫자를 랜덤하게 생성한다. - ``createAnswerNumbers``
</br>

## 🎮 게임 프로그램 - GameController
> 게임을 진행하는 컨트롤러 클래스
- 게임을 시작한다. - ``playGame``
- 반복해서 정답 숫자를 추측한다. - ``repeatguessingAnswerNumbers``
- 정답 숫자인지 확인한다. - ``checkNumbersEqualToAnswer``
- 게임 재시작 및 종료 여부를 확인한다. - ``checkForRestartOrShutDown``
  - 예외 처리 - ``validateRestartOrShutDownNum``
    - 🚫 입력된 숫자가 1이나 2가 아닌 경우
</br>

## 🖥️ 게임 입력 화면 - InputView
> 사용자의 입력을 받기위한 게임 화면을 출력하면서 입력을 받는 뷰 클래스
- 사용자에게서 숫자 입력 화면을 출력하고 값을 입력받는다. - ``readNumbers``
  - 예외 처리 - ``validateDigit``
    - 🚫 숫자가 아닌 값이 입력되었을 경우
- 사용자에게서 게임 재시작 여부를 선택하는 화면을 출력하고 값을 입력받는다. - ``readRestartOrShutDown``
  - 예외 처리 - ``validateDigit``
    - 🚫 숫자가 아닌 값이 입력되었을 경우
</br>

## 🖥️ 게임 출력 화면 - OutputView
> 게임 화면을 출력하는 뷰 클래스
- 게임 시작 화면을 출력한다. - ``printGameStartView``
- 힌트를 출력한다. - ``printHintView``
- 게임 종료 화면을 출력한다. - ``printGameEndView``