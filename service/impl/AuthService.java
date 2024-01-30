package effectivemobile.taskmanagementsystem.service.impl;

import effectivemobile.taskmanagementsystem.utils.AuthenticationResponse;
import effectivemobile.taskmanagementsystem.dto.auth.Register;
import effectivemobile.taskmanagementsystem.dto.user.User;
import effectivemobile.taskmanagementsystem.entity.UserEntity;
import effectivemobile.taskmanagementsystem.exeptions.WrongLoginPasswordExeption;
import effectivemobile.taskmanagementsystem.mapper.UserConvertor;
import effectivemobile.taskmanagementsystem.service.repository.UserRepo;
import effectivemobile.taskmanagementsystem.utils.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final JwtTokenService tokenService;

    private final UserConvertor userConvertor;

    private final AuthenticationManager manager;


    public AuthenticationResponse register(Register register) {
        logger.info("register data " + register);
        User user = User.builder()
                .email(register.getEmail())
                .password(passwordEncoder.encode(register.getPassword()))
                .build();
        UserEntity entity = userConvertor.converToEntity(user);
        userRepo.save(entity);
        logger.info("saving completed");
        String token = tokenService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .build();

    }

    public AuthenticationResponse authentication(Register register) throws WrongLoginPasswordExeption {
        logger.info("authentication data "+ register);
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(register.getEmail(),
                        register.getPassword())
        );
        UserEntity userEntity = userRepo.findUserByEmail(register.getEmail());
        User user = userConvertor.convertToDto(userEntity);
        String token = tokenService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .build();

    }
}
