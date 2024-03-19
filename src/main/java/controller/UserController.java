package controller;

import DTO.UserCreateDTO;
import DTO.UserDTO;
import DTO.UserUpdateDTO;
import jakarta.validation.Valid;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired UserService userService;

    @GetMapping
    public List<UserDTO> index(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserDTO show(@PathVariable long id){
        return userService.getUserById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@Valid @RequestBody UserCreateDTO dto){
        return userService.createUser(dto);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO update(@RequestBody @Valid UserUpdateDTO dto,long id){
        return userService.updateUser(dto,id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable long id){
        userService.deleteUser(id);
    }

}
