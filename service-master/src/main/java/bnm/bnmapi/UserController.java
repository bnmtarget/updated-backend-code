package bnm.bnmapi;


import bnm.bnmapi.db.UserDetailsDAO;
import bnm.bnmapi.db.UserProfileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }


    @GetMapping("/user")
    public List<UserDetailsDAO> getAll() {
        return userService.getAll();
    }


    @GetMapping("/userprofile")
    public List<UserProfileDAO> getProfile() {
        return userService.getProfile();
    }


    @GetMapping("/user/{email}")
    public Optional<UserDetailsDAO> getUserByEmail(@PathVariable("email") String email) {

        try {
            return userService.getUserByEmail(email);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());

        }

    }
    @GetMapping("/profile/{email}")
    public Optional<UserProfileDAO> getProfileByEmail(@PathVariable("email") String email) {

        try {
            return userService.getProfileByEmail(email);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());

        }

    }


    @PostMapping("/create")
    public String createUser(@RequestBody Userdetails userdetails) throws SQLIntegrityConstraintViolationException{
 try {
     userdetails.setUserId((int) (Math.random() * 100));
     userService.createUser(userdetails);
     return "user created successfully";
 }
 catch(Exception e)
 {
     return "Found duplicate entry";
 }

    }
    @PostMapping("/profile/create")
    public String createProfile(@RequestBody UserProfile userProfile) throws SQLIntegrityConstraintViolationException{
        try {
            userProfile.setUserId((int) (Math.random() * 100));
            userService.createProfile(userProfile);
            return "user created successfully";
        }
        catch(Exception e)
        {
            return "Found duplicate entry";
        }

    }

    @PutMapping("/updateprofile/{email}")
    public String updateProfileByEmail(@PathVariable("email") String email, @RequestBody UserProfile userProfile) {
        try {
            userService.updateProfileByEmail(email, userProfile);
            return "profile updated";
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}