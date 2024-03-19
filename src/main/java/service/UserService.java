package service;

import DTO.UserCreateDTO;
import DTO.UserDTO;
import DTO.UserUpdateDTO;
import exception.ResourceNotFoundException;
import mapper.UserMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired UserRepository userRepository;

    @Autowired UserMapper userMapper;

    public List<UserDTO> getAllUsers(){
        var users = userRepository.findAll();
        return users.stream()
                .map(userMapper::map)
                .toList();
    }
    public UserDTO getUserById(long id){
var user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
return userMapper.map(user);
    }
    public UserDTO createUser(UserCreateDTO dto){
        var user = userMapper.map(dto);
        userRepository.save(user);
        return userMapper.map(user);
    }
    public UserDTO updateUser(UserUpdateDTO dto,long id){
        var user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
        userMapper.update(dto,user);
        userRepository.save(user);
        return userMapper.map(user);
    }
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
}
