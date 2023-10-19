# 미션 - 숫자야구 기능

## 주요 도메인

### 랜덤 숫자 생성기

### 입력값과 정답 비교기
- 입력값과 정답 비교하여 결과 반환

### 야구숫자
- 숫자야구게임에서 사용되는 야구공.
- field member
  - List<Integer>. fixed size = 3.
- method
  - equals: override하여 순서와 값이 모두 같으면 true

### Game Controller
- 책임: 사용자와 게임 서비스 간 연결제어

### Game Service
- 책임: 게임 서비스 흐름제어
