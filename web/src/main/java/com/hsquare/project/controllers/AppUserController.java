package com.hsquare.project.controllers;

import com.hsquare.project.exceptions.BusinessLogicException;
import com.hsquare.project.exceptions.UserAlreadyExistException;
import com.hsquare.project.model.AppUsers;
import com.hsquare.project.request.UserRequestDto;
import com.hsquare.project.response.UserResponseDto;
import com.hsquare.project.users.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@RequiredArgsConstructor
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<AppUsers>> getAllUsers(){
        return ResponseEntity.ok().body(appUserService.getAllUsers());
    }

    @GetMapping("/user")
    public ResponseEntity<Optional<AppUsers>> getUser(Long id){
        return ResponseEntity.ok().body(appUserService.getUser(id));
    }

    //Todo: get to know this method and further explanations from Mofe

    public ResponseEntity<?> createUser(@RequestBody UserRequestDto userResponseDto) throws UserAlreadyExistException, BusinessLogicException {
        try{
            UserResponseDto responseDto = appUserService.createUser(userResponseDto);
            return ResponseEntity.ok().body(responseDto);
        }
       catch (BusinessLogicException | UserAlreadyExistException exception){
            return ResponseEntity.badRequest().body(exception);
       }


    }




}