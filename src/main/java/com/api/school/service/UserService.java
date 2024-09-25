package com.api.school.service;

import com.api.school.dto.UserDto;
import com.api.school.entity.UserEntity;
import com.api.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAll(){
        return this.userRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public UserDto getById(String id){
        return this.userRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    public UserDto save(UserDto user){
        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        UserEntity entitySaved = this.userRepository.save(entity);
        return this.toDto(entitySaved);
    }

    public void delete(String id){
        UserEntity entity = this.userRepository.findById(id).orElse(null);
        assert entity != null;
        this.userRepository.delete(entity);
    }

    public UserDto update(UserDto user, String id){
        UserEntity entity = this.userRepository.findById(id).orElse(null);
        assert entity != null;
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        UserEntity entitySaved = this.userRepository.save(entity);
        return this.toDto(entitySaved);
    }

    private UserDto toDto(UserEntity entity){
        return new UserDto(entity.getId(),entity.getName(),entity.getEmail());
    }
}
