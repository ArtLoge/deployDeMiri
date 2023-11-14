package com.miris.deployDeMiri.servicio;

import com.miris.deployDeMiri.entity.User;
import com.miris.deployDeMiri.model.UserModel;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User save(UserModel model);
    User update(UserModel model);
    void delete(int id);
    User getById(int id);
}
