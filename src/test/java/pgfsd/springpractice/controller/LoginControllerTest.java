package pgfsd.springpractice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pgfsd.springpractice.dto.LoginFormDto;
import pgfsd.springpractice.entities.User;
import pgfsd.springpractice.services.LoginService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginService loginService;

    @Test
    void getLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login")).andExpect(status().isOk())
                .andExpect(content().string(containsString("Login")));
    }

    @Test
    void loginSuccess() throws Exception {
        LoginFormDto validLoginForm = new LoginFormDto(1L, "Test1234");
        User loggedUser = new User(1L, "Bob", "Test1234");
        LoginFormDto invalidLoginForm = new LoginFormDto(1L, "wrong-password");
        when(loginService.login(any(LoginFormDto.class))).thenReturn(loggedUser);
        MockHttpServletRequest request = mockMvc
                .perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(validLoginForm)))
                .andExpect(status().is3xxRedirection()).andReturn().getRequest();
        assertThat(request.getSession(false)).isNotNull();
        assertThat(request.getSession().getAttribute("loggedUser")).isNotNull();
    }

    @Test
    void loginFailure() throws Exception {
        LoginFormDto invalidLoginForm = new LoginFormDto(1L, "wrong-password");
        when(loginService.login(any(LoginFormDto.class))).thenReturn(null);
        MockHttpServletRequest request = mockMvc
                .perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(invalidLoginForm)))
                .andExpect(status().isOk())
                .andReturn().getRequest();
        assertThat(request.getSession(false)).isNull();
    }

    @Test
    void logout() throws Exception {
        MockHttpServletRequest request = mockMvc
                .perform(MockMvcRequestBuilders.get("/logout"))
                .andExpect(status().isOk())
                .andReturn().getRequest();
        assertThat(request.getSession(false)).isNull();

    }
}