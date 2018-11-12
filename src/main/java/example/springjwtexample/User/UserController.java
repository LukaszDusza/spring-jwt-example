package example.springjwtexample.User;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("sign")
    public void signUp(@RequestBody UserApp userApp) {
        userApp.setPassword(bCryptPasswordEncoder.encode(userApp.getPassword()));
        userRepository.save(userApp);
    }

    @PostMapping("login")
    public void echo (@AuthenticationPrincipal final UserDetails user) { }

}
