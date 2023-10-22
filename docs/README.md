## 🚀 기능 요구 사항

- [✓] Application :  main () 게임 실행
- [✓] Computer : 컴퓨터가 생성하는 3자리 랜덤 수
- [✓] InitGame : 플레이어로부터 숫자를 입력받는 클래스
- [✓] Check: 일치하는 숫자를 확인하고 볼과 스트라이크를 구별
- [✓] Restart: 게임이 종료되었을 때, ‘재시작:1, 게임 종료 : 2 ‘ 구현

## 🎯 프로그래밍 요구 사항

- [✓] JDK 17 버전에서 실행
- [✓] `ApplicationTest`의 모든 테스트 성공
    - `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료
- [✓] `Randoms` 및 `Console` API를 사용
- [✓] `pickNumberInRange()`를 활용
- [✓] `readLine()`를 입력
- [ ] Java 코드 컨벤션 준수
- [ ] `./gradlew clean test` 실행할 때 통과
    ```
    BUILD SUCCESSFUL in 0s
    ```