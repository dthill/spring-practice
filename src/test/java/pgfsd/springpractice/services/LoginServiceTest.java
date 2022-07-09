package pgfsd.springpractice.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pgfsd.springpractice.dto.LoginFormDto;
import pgfsd.springpractice.entities.User;
import pgfsd.springpractice.repositories.UserRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        when(userRepository.findUserByIdAndPassword(1L, "Test1234"))
                .thenReturn(new User(1L, "Bob", "Test1234"));
    }

    @Test
    void serviceLoads() {
        assertThat(loginService).isNotNull();
    }

    @Test
    void login() {
        assertThat(loginService.login(new LoginFormDto(1L, "Test1234"))).isNotNull();
        verify(userRepository, times(1)).findUserByIdAndPassword(1L, "Test1234");
    }
}