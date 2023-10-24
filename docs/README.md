# 우테코 프리코스 1주차

## ⚾️ 숫자 야구

### ✅ 0점 방지 기본 규칙
- [x] java version 17로 설정
- [x] `./gradlew clean test` BUILD SUCCESSFUL 확인


### ✅ 기능 요구 사항
- [x] 게임 시작 문구 출력하기
- [x] 서로 다른 3자리 수 입력받기
- [x] 3개의 숫자를 모두 맞힐 경우 게임종료하기
- [x] 게임 종료 시 재시작, 종료 구분하는 1, 2 수 입력받기
- [x] 입력값에 대한 결과 문장 출력하기 (낫싱, 볼, 스트라이크)
- [x] 정답 숫자 3자리 랜덤으로 생성하기 (1에서 9까지 서로 다른 임의의 수 3개)
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생


### ✅ 프로그래밍 요구사항
- [x] Java 코드 컨벤션 준수해서 리팩토링
> **`돌다리도 두들겨보자!` 제출 전 확인 리스트 🪨👊🏻**
> [x] JDK 17를 사용한다.
> [x] Application의 main()에서 시작하도록 설계했다.
> [x] build.gradle 파일을 변경하지 않았다.
> [x] 외부 라이브러리 사용하지 않았다.
> [x] System.exit() 사용하지 않았다.
> [x] ApplicationTest의 모든 테스트가 성공한다.
> [x] 패키지 이름을 수정하거나 이동하지 않았다.
> [x] camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현했다.
>   [x] camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()
>   [x] camp.nextstep.edu.missionutils.Console의 readLine()
 

### ✅ 과제 진행 요구사항
- [x] java-baseball-6 저장소를 Fork & Clone
- [x] docs/README.md에 구현할 기능 목록을 정리해 추가
- [x] 완료 후 Pull Request 생성
- [x] 우아한테크코스 지원 플랫폼에 소감 작성 후 제출
- [x] 제출한 후 결과 확인, 통과하지 못했다면 수정해 재제출

### ✅ 추가 학습 목표
- [x] Google Java Style Guide 정독 및 적용 
- [x] MVC 패턴 학습 및 적용
```text
├─ controller
│  └─ GameController
├─ model
│  └─ Game
├─ service
│  ├─ GameService [게임 전체 흐름 주요 로직]
│  └─ HintService [게임 중 힌트 관련 주요 로직]
├─ view
│  ├─ StartView [게임 시작시 문구 출력]
│  ├─ HintView [게임 진행중 힌트 출력]
│  └─ EndView [게임 종료시 문구 출력]
└─ Application
```
