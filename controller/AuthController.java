package effectivemobile.taskmanagementsystem.controller;

import effectivemobile.taskmanagementsystem.dto.auth.Register;
import effectivemobile.taskmanagementsystem.exeptions.WrongLoginPasswordExeption;
import effectivemobile.taskmanagementsystem.service.impl.AuthService;
import effectivemobile.taskmanagementsystem.utils.AuthenticationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private final AuthService authService;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    @Operation(summary = "регистрация нового пользователя", description = "регистрирует пользователя по почте и паролю и генерирует jwt token", tags={ "регистрация пользователя" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unautorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden") })
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Register register) {
        return ResponseEntity.ok(authService.register(register));
    }

    @Operation(summary = "aутентификация пользователя", description = "аутентифицирует пользователя и генерирует jwt token", tags={ "аутентификация пользователя" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unautorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden") })
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> auth(@RequestBody Register register) throws WrongLoginPasswordExeption {
        logger.trace("данные получены");
        return ResponseEntity.ok(authService.authentication(register));
    }

}
