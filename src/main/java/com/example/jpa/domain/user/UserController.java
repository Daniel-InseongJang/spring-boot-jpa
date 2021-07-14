package com.example.jpa.domain.user;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "회원", tags = {"User 회원"})
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;

    @ApiOperation("회원 리스트 조회")
    @GetMapping("")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
