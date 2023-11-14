package com.miris.deployDeMiri.servicio.impl;

import com.miris.deployDeMiri.entity.User;
import com.miris.deployDeMiri.model.UserModel;
import com.miris.deployDeMiri.repository.UserRepository;
import com.miris.deployDeMiri.servicio.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(UserModel model) {
        User user = new User();
        user.setName(model.getName());
        user.setApellido(model.getApellido());
        user.setCuenta(model.getCuenta());
        user.setClave(model.getClave());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(UserModel model) {
        User user = userRepository.findById(model.getId()).orElse(null);
        user.setName(model.getName());
        user.setApellido(model.getApellido());
        user.setCuenta(model.getCuenta());
        user.setClave(model.getClave());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
