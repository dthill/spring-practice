package pgfsd.springpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pgfsd.springpractice.services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping(value = "/edit-user",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String editUser(@RequestBody MultiValueMap<String, String> formData, RedirectAttributes redirectAttributes) {
        String userAdded = userService.updateUser(formData.getFirst("user-id"), formData.getFirst("user-name"));
        redirectAttributes.addFlashAttribute("userAdded", userAdded);
        return "redirect:users";
    }

}
