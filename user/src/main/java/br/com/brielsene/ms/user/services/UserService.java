package br.com.brielsene.ms.user.services;

import br.com.brielsene.ms.user.dto.CreateUserDto;
import br.com.brielsene.ms.user.models.UserModel;
import br.com.brielsene.ms.user.producers.UserProducer;
import br.com.brielsene.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    @Transactional
    public UserModel createUser(UserModel userModel){
        userModel = userRepository.save(userModel);
        userProducer.publishMessageEmail(userModel);
        return userModel;
    }
}
