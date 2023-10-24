# 미션 - 숫자 야구 게임⚾️

## Class 별 요구사항

#### 1. User

- [기능] userGuessNumber를 전달하기 위한 set 메서드를 구현한다.
- [예외] 4자리 이상의 수가 입력될 경우 IllegalArgumentException이 발생해야 한다.
- [예외] 입력으로 0이 들어올 경우 IllegalArgumentException이 발생해야 한다.
- [예외] 입력된 숫자 중 중복된 숫자가 존재할 경우 IllegalArgumentException이 발생해야 한다.

#### 2. Computer

- [기능] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`API를 사용해 값을 저장한다.
- [기능] `Randoms` API에서 이전에 입력한 숫자를 입력할 경우 다시 입력하도록 요청한다.
- [기능] computerNumber을 저장하고 전달하기 위한 get, set 메서드를 구현한다.

#### 3. Game
- [기능] 게임의 상태를 관리하고 시작하는 기능을 구현하여야 한다.
- [기능] user로부터 에러를 캐치하였을 때 Application이 종료되어야 한다.
- [기능] 입력된 userNumberGuess를 computerNumber와 매칭하여 GameResult를 반환한다.
- [기능] GameResult는 3 스트라이크일 경우 게임이 종료됨을 판단한다.
- [기능] GameResult가 종료되었다면 게임 재시작에 대한 명령을 시작해야 한다.
- [기능] 게임을 종료하였을 때 1을 누르면 게임이 재시작되어야 한다.
- [기능] 게임을 종료하였을 때 2를 누르면 Application이 종료되어야 한다.

