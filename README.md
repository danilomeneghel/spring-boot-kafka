# Spring Boot Kafka

Projeto de envio de messageria utilizando Kafka e Java.

## Características

- Messageria
- Producer
- Consumer
- API RESTful

## Requisitos

- Java JDK 11
- Apache Maven >= 3.6.3 (Opcional)
- Docker (Opcional)

## Tecnologias

- Java
- Maven
- Spring
- Docker

## Instalação

```
$ git clone https://github.com/danilomeneghel/spring-boot-kafka.git

$ cd spring-boot-kafka
```

## Kafka

Primeiro rode o Kafka.<br>
Caso não tenha o Kafka instalado, execute o seguinte comando via Docker:

```
docker network create app-tier --driver bridge
docker run -d --name zookeeper-server --network app-tier -e ALLOW_ANONYMOUS_LOGIN=yes bitnami/zookeeper:3.8.0
docker run -d --name kafka-server --network app-tier -p 9092:9092 -e ALLOW_PLAINTEXT_LISTENER=yes -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper-server:2181 -e KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://127.0.0.1:9092 -e KAFKA_CFG_LISTENERS=PLAINTEXT://0.0.0.0:9092 bitnami/kafka:3.3.2
docker run -it --rm --network app-tier -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper-server:2181 bitnami/kafka:3.3.2 kafka-topics.sh --list --bootstrap-server kafka-server:9092
```

## Maven

Para carregar o projeto producer, digite no terminal:

```
$ cd spring-boot-kafka-producer
$ ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

Para carregar o projeto consumer, digite no terminal:

```
$ cd spring-boot-kafka-consumer
$ ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

Aguarde carregar todo o serviço web. <br>

## Docker (Opcional)

Para rodar o projeto via Docker-Compose, basta executar o comando:

```
$ docker-compose up
```

Aguarde baixar as dependências e carregar todo o projeto, esse processo é demorado. <br>
Caso conclua e não rode pela primeira vez, tente novamente executando o mesmo comando. <br>

Para encerrar tudo digite:

```
$ docker-compose down
```

## Teste da Messageria

Para testar a aplicação abra o Postman e insira os seguintes dados:<br>

POST<br>
http://localhost:8081/kafka/salvar-pedido

```
{
    "codigo": "111",
    "nomeProduto": "xxxxxxx",
    "valor": "11.11"
}
```

Após o envio retornará a seguinte mensagem: <br>

```
Pedido enviado com sucesso.
```

E no console:<br>

```
Evento Recebido = PedidoData(codigo=111, nomeProduto=xxxxxxx, valor=11.11)
```

## Licença

Projeto licenciado sob <a href="LICENSE">The MIT License (MIT)</a>.<br><br>


Desenvolvido por<br>
Danilo Meneghel<br>
danilo.meneghel@gmail.com<br>
http://danilomeneghel.github.io/<br>
