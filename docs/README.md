# 🎯미션

> 1부터 9까지의 서로 다른 수들로 이루어진 3자리의 숫자를 맞추는 게임

<br/>

## 🚀 프로그램 기능 흐름

1. 프로그램을 시작하면, 컴퓨터는 서로 다른 임의의 3자리의 숫자를 생성한다.
2. `숫자 야구 게임을 시작합니다.` 라는 게임 시작 문구를 출력하여 게임을 시작한다.
3. `숫자를 입력해주세요 : ` 라는 문구를 출력하여 사용자에게 세 자리 숫자를 입력받는다.
4. 사용자에게 입력받은 값에 대해 (3자리의 숫자)포맷이 맞는지 `validation` 유효성 체크를 해준다.
    1. 만약, 사용자가 잘못된 값을 입력했을 경우 `IllegalArgumentException`을 발생시킨다.
    2. `IllegalArgumentException` 이 발생하면 애플리케이션은 종료된다.
5. 입력한 수가 정답을 맞췄는지 채점한다.
    1. 같은 수가 같은 자리에 있으면 `스트라이크`
    2. 같은 수가 다른 자리에 있으면 `볼`
    3. 같은 수가 전혀 없으면 힌트를 출력한다.
        1. 힌트는 `낫싱`이다.
6. 입력한 수에 대한 채점결과를 출력한다.
    1. 3개의 숫자를 모두 맞힐 경우, `3개의 숫자를 모두 맞히셨습니다! 게임 종료` 정답 문구를 출력한다.
    2. 3개의 숫자를 모두 맞힐 경우, 진행하던 게임을 종료한다.
    3. `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` 지속여부 문구를 출력한다.
    4. 게임을 다시 시작하거나 완전히 종료할 지 사용자에게 값을 입력받는다.
        1. 1을 선택했을 때, 1번으로 돌아가 게임을 다시 시작한다.
        2. 2를 선택했을 때, (4-2)`IllegalArgumentException` 을 발생시켜 게임을 종료시킨다.
7. 3 ~ 6번의 과정을 반복하며 사용자는 정답을 맞춘다.

<br/>

## 📖 기능 목록

> 1. 중복되지 않는 3자리 숫자 생성하는 기능 : `Computer.newNumber()`
> 2. 게임을 실행하는 기능 : `BaseballGame.run()`
> 3. 게임을 시작하는 기능 : `BaseballGame.start()`
> 4. 게임 상황에 따라 사용자에게 적절한 문구를 출력하는 기능 : `Message.java`
> 5. 게임을 종료하는 기능 : `BaseballGame.exit()`
> 6. 사용자에게 힌트를 주는 기능 : `Hint.nothing()`
> 7. 예상치 못한 값을 입력받았을 때 예외를 발생시켜 게임을 종료시키는 기능 : `Validator.java`
> 8. 사용자가 입력한 값에 대해 유효성을 체크하는 기능 : `Validator.java`
> 9. 정답 체크하는 기능 : `AnswerChecker.java`
> 10. 사용자에게 입력받는 기능 : `Input.java`
> 11. 사용자에게 출력하는 기능 : `Output.java`

<br/>

## 📂 프로젝트 구조

```markdown
📦java-baseball
┣ 📂 docs
┃ ┣ 📝 README.md
┣ ...
┣ 📂src.java.baseball
┃ ┣ 📂constant
┃ ┃ ┗ 📜StringError.java
┃ ┃
┃ ┣ 📂controller
┃ ┃ ┗ 📜BaseballGame.java
┃ ┃
┃ ┣ 📂domain
┃ ┃ ┣ 📜AnswerChecker.java
┃ ┃ ┣ 📜Computer.java
┃ ┃ ┣ 📜Hint.java
┃ ┃ ┣ 📜Message.java
┃ ┃ ┗ 📜Validator.java
┃ ┃
┃ ┣ 📂io
┃ ┃ ┣ 📜Input.java
┃ ┃ ┗ 📜Output.java
┃ ┃
┃ ┣ 📂type
┃ ┃ ┗ 📜ReStartFlag.java
┃ ┗ 📜Application.java
┃ ┗ ...
┣ ...
┗ 📝README.md
```

