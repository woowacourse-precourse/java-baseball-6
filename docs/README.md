# 1. Application.java

- 로직이 시작되는 지점 - RunGame 클래스의 run()을 호출함

<br>

# 2. StaticValue.java

1. 게임에 사용되는 문구들 및 값을 String 상수로 저장함

2. `answer` : 컴퓨터가 임의로 생성한 숫자를 저장하는 정수배열

3. `keyNum` : 사용자가 추측해서 입력한 숫자를 저장하는 정수배열

<br>

# 3. RunGame.java

#### ✅ startGame()

- 게임 시작 알림, `숫자 야구 게임을 시작합니다` 출력

#### ✅ createRandomNumbers()

- api 사용해서 난수 생성함

#### ✅ runningGame()

- run() 안에 있는 게임 실행하는 부분 코드 따로 분리함

- 게임 끝나고 1, 2 받을 때 게임을 다시시작하는 경우와 이어지게 하기 위함

#### ✅ inputNumbers()

- `숫자를 입력해주세요 :` 출력

- 값을 입력받고(scanner 사용) `keyNum` 변수에 값 저장

- Scanner를 사용해서 받았던 입력을 console api 사용하는 걸로 바꿈

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생

#### ✅ returnResult()

- `keyNum` `answer` 배열을 순회/비교함

- 위 경우 제외하고는 while으로 계속 돌아야됨

- 볼인경우

- 스트라이크인경우

- 낫싱인경우

#### ✅ finishGame()

- `3개의 숫자를 모두 맞히셨습니다! 게임 종료` 문구 출력

- `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` 문구 출력하고

- input값을 받아서
  
  - 1의 경우 : main 을 다시시작
  
  - 2의 경우 : main 종료

<br>

# 4. Calculate.java

1. `divideNumber()` : 나누기한 값을 정수형으로 반환

2. `multiplyNumber()` : 곱하기한 값을 정수형으로 반환

<br>

#### p.s. 커밋규칙 & 주의사항

```markdown
# feat : 기능 추가
# fix : 버그 수정
# docs : 문서 수정
# test : 테스트 코드 추가
# refactor : 코드 리팩토링
# style : 코드 의미에 영향을 주지 않는 변경사항
# chore : 빌드 부분 혹은 패키지 매니저 수정사항
# cicd : CI/CD 관련 설정
```
