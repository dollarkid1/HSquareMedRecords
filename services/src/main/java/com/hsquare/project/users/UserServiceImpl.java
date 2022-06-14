package com.hsquare.project.users;

import com.hsquare.project.UserRepository;
import com.hsquare.project.exceptions.BusinessLogicException;
import com.hsquare.project.exceptions.UserAlreadyExistException;
import com.hsquare.project.exceptions.UserNotFoundException;
import com.hsquare.project.model.Users;
import com.hsquare.project.request.UserRequestDto;
import com.hsquare.project.response.UserResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    private static BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<Users> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> getUser(Long uniqueID) {
        log.info("Fetching user {}", uniqueID);
        return userRepository.findById(uniqueID);
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) throws UserAlreadyExistException {

        //checking if user's phone number already exist
        boolean userExists = userRepository.findByPhoneNumber(userRequestDto.getPhoneNumber()).isPresent();
        if (userExists){
            throw new UserAlreadyExistException("Phone number already exist");
        }

        //encoding the user's password
        String encodedPassword = bCryptPasswordEncoder.encode(userRequestDto.getPassword());
        userRequestDto.setPassword(encodedPassword);

        //saving the user in the repository
        Users newUser = new Users();
        newUser.setFirstName(userRequestDto.getFirstName());
        newUser.setLastName(userRequestDto.getLastName());
        newUser.setGender(userRequestDto.getGender());
        newUser.setPhoneNumber(userRequestDto.getPhoneNumber());
        newUser.setDob(userRequestDto.getDob());

        userRepository.save(newUser);

        return buildResponse(newUser);
    }
    private UserResponseDto buildResponse(Users appUser){
        return UserResponseDto.builder()
                .firstName(appUser.getFirstName())
                .phoneNumber(appUser.getPhoneNumber())
                .email(appUser.getEmail())
                .gender(appUser.getGender())
                .build();
    }




    @Override
    public Users saveUser(Users users) {
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) throws BusinessLogicException {
        Optional<Users> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.delete(user.get());
            return true;
        }
        throw new BusinessLogicException("User with "+ id + " does not exist");
     }
}
