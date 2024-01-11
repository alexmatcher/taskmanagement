package effectivemobile.taskmanagementsystem.controller;

import effectivemobile.taskmanagementsystem.dto.auth.Register;
import effectivemobile.taskmanagementsystem.exeptions.MailDuplicationExeption;
import effectivemobile.taskmanagementsystem.service.impl.UserServiceImpl;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin(value = "http://localhost:8080")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Validated Register register) {
        try {
            if (userService.registerUser(register)) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }

        } catch (MailDuplicationExeption e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email is used");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
