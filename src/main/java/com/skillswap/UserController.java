package com.skillswap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

 @Autowired
private UserRepository userRepository;

@Autowired
private EmailService emailService;

@Autowired
private ConnectionRepository connectionRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // Skill swap matching
    @GetMapping("/swap")
    public List<User> findSwapMatch(@RequestParam String skill,
                                    @RequestParam String want){

        return userRepository.findBySkillAndWantToLearn(want, skill);
    }

  @PostMapping("/connect")
public String connectUsers(@RequestBody ConnectRequest request){

    // send email
    emailService.sendEmail(
        request.getToEmail(),
        request.getFromName(),
        request.getFromEmail()
    );

    // save connection in database
    Connection connection = new Connection();
    connection.setSenderEmail(request.getFromEmail());
    connection.setReceiverEmail(request.getToEmail());
    connection.setStatus("PENDING");

    connectionRepository.save(connection);

    return "Connection request sent";
}

@GetMapping("/requests")
public List<Connection> getRequests(@RequestParam String email){

return connectionRepository.findByReceiverEmail(email);

}

}