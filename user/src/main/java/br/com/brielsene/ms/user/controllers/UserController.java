package br.com.brielsene.ms.user.controllers;

import br.com.brielsene.ms.user.dto.CreateUserDto;
import br.com.brielsene.ms.user.models.UserModel;
import br.com.brielsene.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserModel> createUser(@RequestBody @Valid CreateUserDto createUserDto){
        var userModel = new UserModel();
        BeanUtils.copyProperties(createUserDto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userModel));
    }
}
