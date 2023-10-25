# 기능

## 요구사항
### 로직
- [ ] 1부터 9까지 서로 다른 3자리 수를 생성한다.
    - [ ] `camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()`를 활용하여 랜덤 숫자를 생성한다.
    - [ ] 3자리 숫자가 중복되면 안된다.
- [ ] 게임이 시작되면 "숫자 야구 게임을 시작합니다." 라는 문구를 출력한다.

### 입력
- [ ] 사용자의 입력은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- [ ] 게임이 종료되면 사용자로 부터 1 또는 2의 입력값을 받는다.
  - [ ] 1: 게임 새로 시작
  - [ ] 2: 게임 종료
- [ ] 잘못입력하면 `IllegalArgumentException`를 발생시키고 애플리케이션을 종료시킨다.
  - [ ] System.exit()를 호출하지 않는다.

### 기타
- [ ] 테스트가 모두 성공해야한다.

# 커밋 컨벤션

`feat`: 기능구현

`refactor`: 리팩토링

`docs`: 문서 관련 작업