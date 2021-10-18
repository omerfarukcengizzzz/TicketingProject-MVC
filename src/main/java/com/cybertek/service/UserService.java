package com.cybertek.service;

import com.cybertek.dto.UserDTO;

import java.util.List;

public interface UserService {
    // save user
    UserDTO save(UserDTO user);

    // find user by username
    UserDTO findByID(String username);

    // return user list
    List<UserDTO> findAll();

    // delete user
    void delete(UserDTO user);
}
