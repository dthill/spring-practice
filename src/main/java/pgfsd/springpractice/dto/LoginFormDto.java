package pgfsd.springpractice.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginFormDto {

    @Min(1)
    private Long id;
    @Size(min = 1)
    private String password;

    public LoginFormDto() {
    }

    public LoginFormDto(Long id) {
        this.id = id;
    }

    public LoginFormDto(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
