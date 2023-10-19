# 사용자 플로우 정리
- 사용자가 보이는 부분은 검은색, 보이지 않고 프로그램이 실행되는 부분은 파란색으로 정리


![IMG_0B5956E8EC42-1](https://user-images.githubusercontent.com/115435784/276511717-1cdecc86-dc8c-4502-aadb-a312fb2a2a10.jpeg)

# 기능 목록
### 입력
- [x] 숫자 맞추기 위한 입력 (**nextstep의 Console API 사용**)
- [x] 게임 재시작, 종료를 선택하기 위한 입력

### 출력
- [x] 게임 시작 문구
- [x] 숫자 입력 요구 문구
- [x] 스트라이크, 볼, 낫싱 판별 문구
- [x] 3 스트라이크 일 때 문구
- [x] 게임 재시작, 종료 선택 문구

### 기능
- [x] 숫자 랜덤 생성 (**nextstep Randoms API 사용**)
- [x] 결과 비교
- [x] 게임 재시작 여부 확인

### 검증
**검증 실패 시 IllegalArgumentException 예외 발생 후 프로그램 중료**
- 게임 입력 검증
    - [x] 세 자리 수를 입력했는지 검증
    - [x] 숫자만 입력했는지 검증
- 결과 선택 검증
    - [x] 1 혹은 2가 아닐 경우 검증

### 클래스 관계도
<img width="797" alt="스크린샷 2023-10-19 오후 7 36 02" src="https://user-images.githubusercontent.com/115435784/276581647-2beebd74-1bde-4ed4-b2e4-b3ff85112cb2.png">
