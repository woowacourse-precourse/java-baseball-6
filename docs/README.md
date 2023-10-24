# 과제1 - 숫자야구

## 📝 기능목록

---

### 💻 컴퓨터 기능 - `Class Computer`

- 3자리 숫자를 무작위로 선택한다 : `selectComputerNum()`
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
        - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용 예시

```
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```

- 게임 시작마다 새로 숫자 선택

---

### 🃏 게임 진행자(심판) 기능 `Class Umpire`

- 게임 시작 문구 출력 : `startGame()`

```
숫자 야구 게임을 시작합니다.
```

- 게임 진행 : `playGame()`
    - 숫자 판단
        - `countStrike()` : strike 개수 탐색
        - `countAll()` : ball + strike 탐색
        - `countAll() - countStrike()` : ball의 개수
    - 결과 출력
    - 정답 & 게임 종료
        - 사용자 - 게임 재시작&종료 선택 `onceAgain()`
        - `3개의 숫자를 모두 맞히셨습니다! 게임 종료
          게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`

---

### 👨‍💻 사용자 기능 `class Player`

- 숫자 입력 : `inputPlayerNum()`
- `camp.nextstep.edu.missionutils.Console`의 readLine()을 활용한다.
    - String 으로 반환

```
숫자를 입력해주세요 : 123
```

```
- 게임 진행자 - 게임 진행
- 정답 맞출 때까지 반복해서 입력
```

- 게임 재시작 & 종료 선택 : `OnceAgain()`
    - 1 : 재시작
    - 2 : 게임 종료