package com.cybertek.implementation;

import com.cybertek.dto.TaskDTO;
import com.cybertek.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO obj) {
        return super.save(obj.getId(), obj);
    }

    @Override
    public TaskDTO findByID(Long id) {
        return null;
    }

    @Override
    public List<TaskDTO> findAll() {
        return null;
    }

    @Override
    public void update(TaskDTO obj) {

    }

    @Override
    public void deleteByID(Long id) {

    }

    @Override
    public void delete(TaskDTO obj) {

    }
}
