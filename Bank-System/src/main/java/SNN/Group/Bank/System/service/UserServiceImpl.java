package SNN.Group.Bank.System.service;

import SNN.Group.Bank.System.module.userss;
import SNN.Group.Bank.System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public userss saveUser(userss user) {
        return userRepository.save(user);
    }

    @Override
    public userss findByPhoneAndPassword(String phone, String password) {
        return userRepository.findByPhoneAndPassword(phone,password);
    }

    @Override
    public userss findByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }
}
