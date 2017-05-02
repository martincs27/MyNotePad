package com.tecsup.martinchavez.mynotepad.repository;

import com.orm.SugarRecord;
import com.tecsup.martinchavez.mynotepad.models.User;

import java.util.List;

/**
 * Created by Alumno on 2/5/2017.
 */

public class UserRepository {

    public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static User read(Long id){
        User user = SugarRecord.findById(User.class, id);
        return user;
    }

    public static void create(String fullname, String email, String password){
        User user = new User(fullname, email, password);
        user.save();
    }

    public static void update(String fullname, String email, String password, Long id){
        User user = SugarRecord.findById(User.class, id);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        user.save();
    }

    public static void delete(Long id){
        User user = SugarRecord.findById(User.class, id);
        user.delete();
    }

    public static User findByEmail(String email, String password){
        List<User> list = User.find(User.class,"email = ? and password = ?",email,password);
        User user = list.get(0);
        return user;
    }

}


