package SNN.Group.Bank.System.repository;

import SNN.Group.Bank.System.module.userss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<userss,Integer> {
    public userss findByPhoneAndPassword(String phone, String password);
    public userss findByPhone(String phone);

}

