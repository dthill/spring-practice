package pgfsd.springpractice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pgfsd.springpractice.dto.LoginFormDto;
import pgfsd.springpractice.entities.User;
import pgfsd.springpractice.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
public class LoginService {

    private UserRepository userRepository;
    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User login(LoginFormDto user){
        return userRepository.findUserByIdAndPassword(user.getId(), user.getPassword());
    }
}
