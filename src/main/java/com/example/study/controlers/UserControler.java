package com.example.study.controlers;

import com.example.study.dao.UserDAO;
import com.example.study.models.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserControler {

    private UserDAO userDAO;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user) {
        userDAO.save(user);
    }
    @GetMapping()

        public ResponseEntity<List<User>> getAllUsers() {
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("custom Header","custom Value");
        return new ResponseEntity<>(userDAO.findAll(),httpHeaders,HttpStatus.ACCEPTED);
    }

    @GetMapping ("{id}")
    public User findUserById (@PathVariable ("id") int userId) {
       Optional<User> byId = userDAO.findById(userId);
       User user = byId.get();
       return user;
    }

    @DeleteMapping()
    public List<User> deleteUser (@RequestParam ("id") int userId) {
        userDAO.deleteById(userId);
        return userDAO.findAll();
    }
}
