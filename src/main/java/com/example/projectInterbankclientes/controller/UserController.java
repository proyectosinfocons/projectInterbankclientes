package com.example.projectInterbankclientes.controller;

import com.example.projectInterbankclientes.dto.UserDTO;
import com.example.projectInterbankclientes.model.User;
import com.example.projectInterbankclientes.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    //@Autowired
    private final IUserService service;// = new UserService();

    @Qualifier("userMapper")
    private final ModelMapper mapper;

    private final PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<List<UserDTO>>  readAll() throws Exception{
        List<UserDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
        /*
        List<UserRecord> list = service.readAll().stream().map(e ->
            new UserRecord(e.getIdUser(), e.getName(), e.getDescription(), e.isEnabled())
        ).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
         */
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> readById(@PathVariable("id") Integer id) throws Exception{
        User obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    /*@GetMapping("/response/{id}")
    public ResponseEntity<ResponseDTO<UserDTO>> readByIdResponse(@PathVariable("id") Integer id) throws Exception{
        User obj = service.readById(id);
        UserDTO dto = convertToDto(obj);
        ResponseDTO<UserDTO> res = new ResponseDTO<>();
        res.setData(List.of(dto));
        res.setStatus(200);
        res.setMessage("OK");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<UserDTO> create( @RequestBody UserDTO dto) throws Exception {
        logger.info("Creating new user: ");
        String encryptedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encryptedPassword);
        User obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update( @PathVariable("id") Integer id, @RequestBody UserDTO dto) throws Exception {
        dto.setIdUser(id);
        User obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private UserDTO convertToDto(User obj){

        return mapper.map(obj, UserDTO.class);
    }

    private User convertToEntity(UserDTO dto){
        return mapper.map(dto, User.class);
    }
}
