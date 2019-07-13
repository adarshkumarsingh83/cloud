package com.espark.adarsh.service;

import com.espark.adarsh.bean.MessageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class MessageServiceImpl implements MessageService{

    private  final Logger logger=LoggerFactory.getLogger(getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    Environment environment;

    @Value("${app.exchange}")
    private String exchange;

    @Value("${app.queue}")
    private String queue;

    @Value("${app.routing.key}")
    private String routingKey;


    @Override
    public void send(MessageBean message) {
        logger.info("label='send ' {}",message);
        if (!StringUtils.isEmpty(message)) {
            rabbitTemplate.convertAndSend(exchange, routingKey, message);
        }
    }

    @Override
    public MessageBean receive() {
        MessageBean message = (MessageBean) rabbitTemplate.receiveAndConvert(queue);
        if (message==null) {
            message=  new MessageBean("admin","welcome to espark message is empty");
        }
        logger.info("label='receive ' {}",message);
        return message;
    }
}
