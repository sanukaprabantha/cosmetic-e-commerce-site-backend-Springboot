package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")

public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/getUsers")
    public List<UserDTO> getUsers()
    {
        return userService.getAllUsers();
    }
    @PostMapping("/createUsers")
    public UserDTO saveUser(@RequestBody UserDTO userDTO)
    {
        return userService.saveUser(userDTO);
    }
    @PutMapping("/updateUsers")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }
    @DeleteMapping("/deleteUsers/{userId}")//userId is a path variable //user delete with id
    public String deleteUser(@PathVariable Integer userId){
        return userService.deleteUser(userId);
    }
}
