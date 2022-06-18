package com.hsquare.project.users;

import com.hsquare.project.exceptions.BusinessLogicException;
import com.hsquare.project.exceptions.UserAlreadyExistException;
import com.hsquare.project.exceptions.UserNotFoundException;
import com.hsquare.project.model.Users;
import com.hsquare.project.request.UserRequestDto;
import com.hsquare.project.response.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<Users> getUsers();

    Optional<Users> getUser(Long id);

    UserResponseDto createUser (UserRequestDto userRequestDto) throws BusinessLogicException, UserAlreadyExistException;

    Users saveUser(Users users);

    Boolean deleteUser (Long id) throws BusinessLogicException;




}
