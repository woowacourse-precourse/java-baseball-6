## 🚀 기능 요구 사항

### 기능 목록

1. **게임 초기화**
    - 게임 시작 시, 숫자 야구 게임을 시작합니다. 라는 문구를 출력한다.
    - 컴퓨터가 1부터 9까지의 서로 다른 임의의 숫자 3개를 선택한다.
2. **입력**
3. **입력 검증**
4. **힌트 생성**
5. **결과 출력**
6. **게임 종료/재시작**

## 🎯 프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를
  준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

### 라이브러리

- 'camp.nextstep.edu.missionutils'
    - 'Randoms' : Random 값 추출
        - 'pickNumberInRange()'
    - 'Console' : 사용자 입력
        - 'readline()'

## ✏️ 과제 진행 요구 사항

- 미션은 [java-baseball-6](https://github.com/woowacourse-precourse/java-baseball-6) 저장소를 Fork & Clone해
  시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse)
  문서를 참고한다.
