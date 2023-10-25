# 과제1 - 숫자야구

## ❗ 기본 제약

---

- 모든 변수는 private
  - 모든 변수는 SET/GET 으로 접근 가능
- 모든 메소드는 public


## 🛠 기능목록

---

### 💻 컴퓨터 기능 - `Class Computer`
- 변수
  - `List<integer> computerNum`
- 메소드
  - `selectComputerNum()` : 3자리 숫자를 무작위로 선택한다
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
        - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용 예시 (from READ.md)
```
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```

---

### 👨‍💻 사용자 기능 `class Player`
- 변수
  - `List<Integer> playerNum`
- 메소드
  - `inputPlayerNum()` : 숫자 입력받기
    - `camp.nextstep.edu.missionutils.Console`의 readLine()을 활용한다.
      - `camp.nextstep.edu.missionutils.Console` : String 으로 반환
    - 예시
```
숫자를 입력해주세요 : 123
```

---

### ⚾ 심판 기능 `Class Umpire`

- 변수
  - `int all`
  - `int strike`
  - `String judgment`
  - `boolean coin;`
- 메소드
  - `void countAll(List<Integer> computerNum, List<Integer> playerNum)`
    - strike + ball 의 갯수
  - `void countStrike(List<Integer> computerNum,List<Integer> playerNum)`
    - strike 갯수 
  - `String Judge()`
    - 판정 결과 반환
  - `void onceAgain()`
    - 게임 재시작 여부 입력
      - 1 : 재시작
      - 2 : 종료
  - `void newGame()`
    - 게임 초기화

---

### 🃏 게임 진행 기능 `Class Application`

- 게임 시작 문구 출력

```
숫자 야구 게임을 시작합니다.
```


- 결과 출력
  - `umpire.getJudgment()`
  - 예시
```
1볼 1스트라이크
```
- 정답 & 게임 종료
```
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```
- 게임 재시작&종료 선택 `umpire.onceAgain()`
```
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
```
- 정답 맞출 때까지 반복해서 입력

## 📝 피드백

---

- 10/24
  - 모든 기능을 구현하고 테스트케이스를 통과했으나 `Application.java`에 모든 기능을 구현했기 때문에 'JAVA'를 사용해서 코딩 한 것 같지 않다.
  - 개선해야할 부분
    - 역할에 따라 class로 나누어서 객체지향적으로 구현하기
    - class마다의 기능에 대해서 테스트 케이스도 새로 시도해 보기

---
- 10/25
