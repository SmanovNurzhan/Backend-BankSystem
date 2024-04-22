package SNN.Group.Bank.System.controller;
import SNN.Group.Bank.System.module.UserLogin;
import SNN.Group.Bank.System.module.Phone;
import SNN.Group.Bank.System.module.userss;
import SNN.Group.Bank.System.service.UserService;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin
public class UserController {
    private UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody userss user){
        userService.saveUser(user);
        return "New User is added";
    }

    @PostMapping("/login")
    public ResponseEntity<?> check(@RequestBody UserLogin userLogin) {
        String phone=userLogin.getPhone();
        String password=userLogin.getPassword();
        userss result = userService.findByPhoneAndPassword(phone, password);
        System.out.println(result);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/balance")
    public ResponseEntity<?> getBalance(@RequestBody Phone phone) {
        userss result = userService.findByPhone(phone.getPhone());
        if (result != null) {
            BigInteger money = result.getMoney();
            if(money==null){
                JSONObject jsonObject2=new JSONObject();
                jsonObject2.put("money", 0);
                return ResponseEntity.ok(jsonObject2.toString());
            }else {
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("money", money);
                return  ResponseEntity.ok(jsonObject.toString());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
