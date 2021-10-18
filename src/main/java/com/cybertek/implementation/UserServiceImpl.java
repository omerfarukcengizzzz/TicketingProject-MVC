package com.cybertek.implementation;

import com.cybertek.dto.UserDTO;
import com.cybertek.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String > implements UserService {
    @Override
    public UserDTO save(UserDTO obj) {
        return super.save(obj.getUserName(), obj);
    }

    @Override
    public UserDTO findByID(String id) {
        return super.findByID(id);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(String id) {
        super.deleteByID(id);
    }

    @Override
    public void delete(UserDTO obj) {
        super.delete(obj);
    }
}
