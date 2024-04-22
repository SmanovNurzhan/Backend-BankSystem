package SNN.Group.Bank.System.service;

import SNN.Group.Bank.System.module.userss;

import java.math.BigInteger;
import java.util.Optional;

public interface UserService {
    public userss saveUser(userss user);
    public userss findByPhoneAndPassword(String phone, String password);
    public userss findByPhone(String phone);
}
