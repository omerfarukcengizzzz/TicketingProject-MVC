package com.cybertek.service;

import com.cybertek.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    RoleDTO save(RoleDTO role);
    RoleDTO findByID(Long id);
    List<RoleDTO> findAll();
    void delete(RoleDTO role);
    void deleteByID(Long id);
}
