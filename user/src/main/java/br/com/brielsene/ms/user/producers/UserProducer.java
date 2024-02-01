package br.com.brielsene.ms.user.producers;

import br.com.brielsene.ms.user.dto.EmailDto;
import br.com.brielsene.ms.user.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")//exchange do tipo default: chave routing key é o mesmo nome
    private String routingKey;

    public void publishMessageEmail(UserModel userModel){
        var emailDto = new EmailDto();
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setUserId(userModel.getUserId());
        emailDto.setText(userModel.getName()+", seja bem vindo!");
        emailDto.setSubject("Cadastro realizado com sucesso");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);

    }


}
