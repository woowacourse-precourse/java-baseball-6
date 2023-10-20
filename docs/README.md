## 🚀 기능 요구 사항
> **숫자야구:** 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다. <br>

### 기본 입력
> [기능 요구 사항/입출력 요구 사항](https://github.com/jungeun5-choi/java-baseball-6/edit/main/README.md#%EC%9E%85%EC%B6%9C%EB%A0%A5-%EC%9A%94%EA%B5%AC-%EC%82%AC%ED%95%AD) 확인

- [ ] 서로 다른 3자리의 수를 입력 받는다
- [ ] 게임이 끝난 경우, 재시작(1)/종료(2) 값을 입력 받는다

### 기본 출력
> [기능 요구 사항/입출력 요구 사항](https://github.com/jungeun5-choi/java-baseball-6/edit/main/README.md#%EC%9E%85%EC%B6%9C%EB%A0%A5-%EC%9A%94%EA%B5%AC-%EC%82%AC%ED%95%AD) 확인

- [ ] 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
- [ ] 3개의 숫자를 모두 맞힐 경우 (= 종료)
- [ ] 게임 시작 문구
- [ ] 게임을 재시작, 종료 선택 문구

### 판정
- [ ] **스트라이크(strike):** 정답인 숫자가 정답과 동일한 자리에 있을 경우
- [ ] **볼(ball):** 정답인 숫자가 정답과 다른 자리에 있을 경우
- [ ] **낫싱(nothing):** 정답에 해당하는 숫자가 전혀 없는 경우

### 상대 역할(컴퓨터)
> 상대 역할은 컴퓨터가 한다.

- [ ] 1에서 9까지 **서로 다른** 임의의 수 3개를 선택 (세 개의 숫자는 서로 중복될 수 없다)

### 예외처리
- [ ] 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료

### 그 외
- [ ] 게임이 종료될 때까지(= 숫자를 맞출 때까지) 모든 과정들은 **반복**된다

<br>

## 🎯 프로그래밍 요구 사항
> 제출 직전 체크할 것!

- [ ] `JDK 17`로 설정했는지
- [ ] 프로그램 시작점이 `Application`의 `main()`인지
- [ ] `build.gradle` 변경하지 않았는지 (변경 불가능, 외부 라이브러리 또한 사용 불가능)
  - [프로그래밍 요구 사항/라이브러리](https://github.com/jungeun5-choi/java-baseball-6/edit/main/README.md#%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC) 확인
- [ ] Java 코드 컨벤션 가이드를 준수했는지
- [ ] 프로그램 종료 시 `System.exit()`를 호출하지는 않았는지 (사용 불가능)
- [ ] `ApplicationTest`의 모든 테스트가 성공했는지
  - [테스트 실행 가이드](https://github.com/jungeun5-choi/java-baseball-6/edit/main/README.md#%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%8B%A4%ED%96%89-%EA%B0%80%EC%9D%B4%EB%93%9C) 확인
- [ ] 파일, 패키지 이름을 수정하거나 이동하지는 않았는지 (변경 불가능)

<br>

## ✏️ 과제 진행 요구 사항
- [ ] `docs/README.md`에서 구현한 기능 목록 확인
- [ ] [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/main/precourse#%EC%A0%9C%EC%B6%9C-%EA%B0%80%EC%9D%B4%EB%93%9C) 확인
