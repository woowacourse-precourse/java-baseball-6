# 기능 목록 단위

## ⌨️ 입력

### Number
1. 사용자가 입력할때 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 입력해야 한다.
    1. 서로 다른 3자리의 수
2. [예외] 1~9 이외에 숫자가 들어오면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
3. [예외] 3자리수에 딱 맞게 들어오지 않으면 IllegalArgumentException을 발생시킨 후애플리케이션은 종료되어야 한다.
4. [예외] 입력된 숫자 중 중복된 숫자가 있으면 IllegalArgumentException을 발생시킨 후애플리케이션은 종료되어야 한다.

### Computer

1. `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console API`를 사용한다.
    1. Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
2. 게임이 종료되었다면 게임 재시작에 대한 명령을 해야 한다.
   3. 게임이 종료됐을 때, 1을 누르면 게임 재시작
   4. 게임이 종료됐을 때, 2를 누르면 Application이 종료

## 🖥 출력

게임을 시작하면 아래 문구와 함께 시작한다.
```text
숫자 야구 게임을 시작합니다.
```

### Input 관련 출력

1. 숫자를 입력받으면 다음과 같은 입력창을 출력한다
```text
숫자를 입력해주세요 :
```
2. 게임이 종료되면 재시작, 종료를 묻는 입력창을 출력한다.
```text
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
```

### Output 관련 출력

1. 숫자를 입력받으면 다음과 같은 입력창을 출력한다
```text
숫자를 입력해주세요 :
```
2. 게임이 종료되면 재시작, 종료를 묻는 입력창을 출력한다.
```text
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
```
3. 컴퓨터와 맞는 개수에 따라 스트라이크, 볼, 낫싱을 출력한다.
```text
1볼 1스트라이크
1볼
낫싱
```