
## ⚙️ Architecture

- **Service (Client)**  
  마이크로서비스 애플리케이션. 로그 발생 시 gRPC 요청을 통해 중앙 서버로 로그 전송  

- **Central Log Server (gRPC Server)**  
  gRPC 요청을 수신하고 로그를 수집하는 역할  
  현재는 `System.out` 출력 상태, 이후 Kafka Publish 기능 예정  

- **Kafka / Elasticsearch (Storage & Processing)**  
  로그를 토픽별(info/warn/error)로 분류 및 저장  
  Elasticsearch 연동 시 검색 및 분석 기능 제공  

- **WebFlux / SSE (Consumer & UI)**  
  Kafka Consumer를 통해 로그 스트림 구독  
  WebFlux + SSE 기반 실시간 로그 스트리밍 API 제공  

---

## 🚀 Current Status

- `.proto` 작성 및 gRPC 코드 생성 완료  
- gRPC 서버 (`LogServiceImpl`, `GrpcServerConfig`) 실행 상태  
- gRPC 클라이언트 테스트 (`LogClientTest`)를 통한 end-to-end 통신 검증 완료  
- 서버에서 클라이언트 요청 수신 → 로그 출력 → 응답 반환 흐름 검증 완료  

---

## 🔮 Next Steps

- Kafka 연동: 로그를 토픽별로 publish (`info-logs`, `warn-logs`, `error-logs`)  
- WebFlux 연동: SSE 기반 실시간 로그 스트리밍 API 구현  
- UI 구현: 브라우저에서 로그 실시간 조회 기능  


- ## ./gradlew bootRun -> 중앙 로그 서버 실행 이후 테스트 코드 실행 

