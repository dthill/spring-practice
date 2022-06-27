package pgfsd.springpractice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pgfsd.springpractice.entities.User;
import pgfsd.springpractice.repositories.UserRepository;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public String updateUser(String idInput, String name){
        Long id = null;
        try {
            id = Long.parseLong(idInput);
        } catch (NumberFormatException e){
            return "Id not valid format.";
        }
        User user = userRepository.findUserById(id);
        if(user == null){
            return "Id not valid no existing user found.";
        }
        user.setName(name);
        userRepository.save(user);
        return "User updated successfully.";
    }

}
