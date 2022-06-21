package com.hsquare.project.users;

import com.hsquare.project.exceptions.BusinessLogicException;
import com.hsquare.project.exceptions.UserAlreadyExistException;
import com.hsquare.project.model.AppUsers;
import com.hsquare.project.request.UserRequestDto;
import com.hsquare.project.response.UserResponseDto;

import java.util.List;
import java.util.Optional;

public interface AppUserService {

    List<AppUsers> getAllUsers();

    Optional<AppUsers> getUser(Long id);

    UserResponseDto createUser (UserRequestDto userRequestDto) throws BusinessLogicException, UserAlreadyExistException;

    AppUsers saveUser(AppUsers appUsers);

    Boolean deleteUser (Long id) throws BusinessLogicException;




}
