package pgfsd.springpractice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pgfsd.springpractice.entities.User;
import pgfsd.springpractice.repositories.UserRepository;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String updateUser(String idInput, String name) {
        Long id = null;
        try {
            id = Long.parseLong(idInput);
        } catch (NumberFormatException e) {
            return "Id not valid format.";
        }
        User user = userRepository.findUserById(id);
        if (user == null) {
            return "Id not valid no existing user found.";
        }
        user.setUsername(name);
        userRepository.save(user);
        return "User updated successfully.";
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

}
