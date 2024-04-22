package SNN.Group.Bank.System.module;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
public class userss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String surname;
    private String phone;
    private String password;
    @Column(name = "user_money")
    private BigInteger money;
}