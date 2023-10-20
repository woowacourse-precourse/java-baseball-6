# 🎮 숫자 야구 게임 프로젝트 구조 🎮

## 🗂 폴더 구조

### 🛠 Interfaces
- [ ] **🔡 Input**: 🎯 입력을 위한 인터페이스
- [ ] **📤 Output**: 🎯 출력을 위한 인터페이스
- [ ] **🎲 Game**: 🎯 다양한 게임을 위한 인터페이스
- [ ] **🖼 View**: 🎯 다른 뷰 (예. Swing) 를 위한 인터페이스 (🤖 전략 패턴 이용)

### 🧰 Utils
- [ ] **🔄 Convertor**: 🎯 데이터 타입 변환을 위한 클래스
- [ ] **🛡 Validator**: 🎯 예외 처리를 위한 클래스 (🔒 싱글톤 패턴 이용)

### 🏗 Classes
- [ ] **🚀 Main**: 🎯 실행을 위한 클래스
- [ ] **⚾ BaseballGame**: 🎯 야구 게임 로직 (🎲 Game 인터페이스 구현)
- [ ] **💻 Console**: 🎯 콘솔 입력/출력 (🔡 Input, 📤 Output 인터페이스 구현)

### 🏢 Domain
- [ ] **🔴 Balls**: 🎯 볼들을 관리하는 일급 컬렉션
- [ ] **🎾 Ball**: 🎯 BallIndex와 BallNumber를 가지고 있는 클래스
- [ ] **🔢 BallIndex**: 🎯 볼의 인덱스와 예외 처리
- [ ] **🔠 BallNumber**: 🎯 볼의 번호와 예외 처리

### 🚥 Enums
- [ ] **🎉 스트라이크, 🎈 볼, ❌ 나싱**: 🎯 결과 표시를 위한 Enum
- [ ] **⏩ 실행 여부**: 🎯 게임 실행 여부를 위한 Enum

### 📦 Additional Classes
- [ ] **🎰 BallGenerator**: 🎯 랜덤 볼 생성
- [ ] **👮‍♂️ Referee**: 🎯 게임 판정
- [ ] **📜 Result**: 🎯 게임 결과 저장