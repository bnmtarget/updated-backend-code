package bnm.bnmapi;

import bnm.bnmapi.db.UserDetailsDAO;
import bnm.bnmapi.db.UserProfileDAO;
import bnm.bnmapi.mapper.ProfileDBMapper;
import bnm.bnmapi.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepos;
    UserService(){};
    //added the line below for unit test
    UserService(UserRepository userepository){this.userrepos=userepository;};

    @Autowired
   private ProfileRepo profileRepo;
    UserService(ProfileRepo profileRepos){this.profileRepo=profileRepos;};


    //getAllGroups
    public List<UserDetailsDAO> getAll(){
        return userrepos.findAll();
    }
    public List<UserProfileDAO> getProfile(){
        return  profileRepo.findAll();
    }
    public  String createUser(Userdetails userdetails) throws Exception {
        UserDetailsDAO dao = ProfileDBMapper.convertToProfileEntity(userdetails);
        userrepos.save(dao);
        return "User created successfully";
 }

    public  String createProfile(UserProfile userProfile) throws SQLIntegrityConstraintViolationException {
        try {
            UserProfileDAO dao = ProfileMapper.convertToProfileEntity(userProfile);
            profileRepo.save(dao);
            return "Profile created successfully";

        }
        catch(Exception e)
        { System.out.println("duplicate key found");
            return "Found duplicate entry";
        }

    }

    public Optional<UserDetailsDAO> getUserByEmail(String email) throws UserNotFoundException {
        Optional<UserDetailsDAO> user= userrepos.findByEmail(email);

        if(!user.isPresent())
            throw new UserNotFoundException("user not found");
        return user;
    }
    public Optional<UserProfileDAO> getProfileByEmail(String email) throws UserNotFoundException {
        Optional<UserProfileDAO> profile= profileRepo.findByEmail(email);

        if(!profile.isPresent())
            throw new UserNotFoundException("user not found");
        return profile;
    }

    public String updateProfileByEmail(String email, UserProfile userProfile) throws UserNotFoundException {
        UserProfileDAO pdao= ProfileMapper.convertToProfileEntity(userProfile);
        Optional<UserProfileDAO> prev=profileRepo.findByEmail(email);
        if(profileRepo.findByEmail(email).isPresent()) {
           UserProfileDAO profile = prev.get();
           profile.setPreferredtimings(userProfile.getPreferredtimings());
           profile.setPreferredstores(userProfile.getPreferredstores());
           profile.setPreferreddays(userProfile.getPreferreddays());
           profile.setPreferredlocations(userProfile.getPreferredlocations());
           profileRepo.save(profile);
            return " profile updated";
        }
       throw new UserNotFoundException("User not found");
    }
}