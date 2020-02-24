Требуемое ПО для сборки и запуска приложения:
1. jvm
2. kafka
3. maven

Инструкция по запуску приложения:

1. git clone https://github.com/mkonyukhov/gate.git
2. cd gate
3. mvn clean
4. mvn install
5. java -jar target/gate-1.0.0.jar --server.port=GATE_SERVER_PORT --spring.kafka.out-topic-name=OUT_TOPIC_NAME --spring.kafka.bootstrap-servers=KAFKA_BROKERS