미션 - 숫자야구 기능
=================

주요 도메인
---------

### 랜덤 숫자 생성기
#### 기능
> - ```make```: 랜덤한 야구숫자 생성
---

### 야구숫자
숫자야구게임에서 사용되는 숫자조합 데이터 클래스

#### 기능
> - ```validate```: 생성 시 입력값 유효성 평가
>   - ```validateType```: 입력값 타입 검증(숫자)
>   - ```validateSize```: 입력값의 길이 검증
> - ```calculateResult```: 사용자 정답 입력에 따른 결과 계산
>   - ```countStrike```: 스트라이크 갯수 계산
>     - ```isStrike```: 입력값 중 특정 값 하나가 스트라이크인지 확인
>   - ```countStrikeAndBall```: 스트라이크와 볼 을 합한 갯수 계산
---

### 게임 결과
게임 결과를 나타내는 데이터 클래스

#### 기능
> - ```isCompleted```: 게임 성공 시 ```true``` 반환
> - ```isNothing```: 스트라이크와 볼 모두 없으면 ```true``` 반환
---

---


## 주요 객체
### 게임 컨트롤러
사용자와 게임 서비스 간 연결제어 객체

#### 기능
> - ``run``: 게임 실행
---

### 게임 서비스
게임 서비스 흐름제어 객체

#### 기능
> - ```init```: 게임 시작에 필요한 세팅 초기화
> - ```calculateResult```: 게임 데이터를 받아서 그에 따른 게임 결과 반환
---

### 게임 뷰
게임 프로그램 입출력 제어 객체

#### 기능
> - ```conveyUserInput```: 사용자 입력값 반환
> - ```printGameStartAnnouncement```: 게임 시작 안내문구 출력
> - ```printAnnouncementForInputAnswer```: 게임 답안 입력 안내문구 출력
> - ```printAnnouncementForRestart```: 게임 재시작 여부 입력 안내문구 출력
> - ```printGameResult```: 게임 결과 출력

### 모델
데이터 전달 제어 객체

#### 기능
> - ```setAttribute```: 데이터 저장하기
> - ```getAttribute```: 데이터 불러오기
---

---


## 프로그램 구조

### 클래스 다이어그램
> <img src="https://github.com/Haaae/java-baseball-6/blob/Haaae/docs/class-diagram.png?raw=true">