package producer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import producer.broker.producer.TopicProducer;
import lombok.RequiredArgsConstructor;
import producer.model.PedidoData;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final TopicProducer topicProducer;

    @PostMapping(path = "/salvar-pedido")
    public ResponseEntity<String> SalvarPedido(@RequestBody PedidoData pedido) {
        topicProducer.send(pedido);
        return ResponseEntity.ok("Pedido enviado com sucesso.");
    }

}
