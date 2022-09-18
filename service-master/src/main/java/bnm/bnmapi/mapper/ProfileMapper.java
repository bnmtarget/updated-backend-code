package bnm.bnmapi.mapper;

import bnm.bnmapi.UserProfile;
import bnm.bnmapi.Userdetails;
import bnm.bnmapi.db.UserDetailsDAO;
import bnm.bnmapi.db.UserProfileDAO;

public class ProfileMapper {

    public static UserProfileDAO convertToProfileEntity(UserProfile userProfile) {
        UserProfileDAO profileDAO = new UserProfileDAO();
        profileDAO.setUserId(userProfile.getUserId());
        profileDAO.setAddress(userProfile.getAddress());
        profileDAO.setGender(userProfile.getGender());
        profileDAO.setName(userProfile.getName());
        profileDAO.setMobile_no(userProfile.getMobile_no());
        profileDAO.setPreferreddays(userProfile.getPreferreddays());
        profileDAO.setEmail(userProfile.getEmail());
        profileDAO.setPreferredlocations(userProfile.getPreferredlocations());
        profileDAO.setPreferredstores(userProfile.getPreferredstores());
        profileDAO.setPreferredtimings(userProfile.getPreferredtimings());
        return profileDAO;
    }
}
