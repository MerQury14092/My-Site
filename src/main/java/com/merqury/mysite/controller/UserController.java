package com.merqury.mysite.controller;

import com.merqury.mysite.models.api.Response;
import com.merqury.mysite.models.auth.User;
import com.merqury.mysite.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;
    public UserController(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/token")
    public Response getToken(@PathParam("") String username,
                           @PathParam("") String password){
        String token = userService.getToken(username, password);
        return token==null?(new Response(400, "Bad credentials")):(new Response(200, token));
    }

    @GetMapping("/whois")
    public Response getUsername(@PathParam("") String token){
        User user = userService.getByToken(token);

        if(user == null)
            return Response.NOT_FOUND;

        return new Response(200, user.getUsername());
    }

    @PostMapping("/registration")
    public Response registration(@RequestBody User user){
        boolean register = userService.register(user.getUsername(), user.getPassword());
        return register? Response.OK:(new Response(400, "user already exists"));
    }

    @DeleteMapping("/user")
    public Response deleteUser(@PathParam("") String token){
        User user = userService.getByToken(token);

        if(user == null)
            return Response.UNAUTHORIZED;
        if(!user.getToken().equals(token))
            return Response.FORBIDDEN;
        userService.deleteUserById(user.getId());
        return Response.OK;
    }

    @PutMapping("/user")
    public Response changePassword(@RequestBody User user, @PathParam("") String token){
        User usr = userService.getByToken(token);

        if(usr == null)
            return Response.UNAUTHORIZED;
        if(!usr.getUsername().equals(user.getUsername()))
            return Response.FORBIDDEN;

        userService.changeUserPassword(user.getUsername(), user.getPassword());
        return Response.OK;
    }
}
