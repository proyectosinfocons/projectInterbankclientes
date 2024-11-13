package com.example.projectInterbankclientes.controller;

import com.example.projectInterbankclientes.dto.RoleDTO;
import com.example.projectInterbankclientes.model.Role;
import com.example.projectInterbankclientes.service.IRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    //@Autowired
    private final IRoleService service;// = new RoleService();

    @Qualifier("roleMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<RoleDTO>>  readAll() throws Exception{
        List<RoleDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
        /*
        List<RoleRecord> list = service.readAll().stream().map(e ->
            new RoleRecord(e.getIdRole(), e.getName(), e.getDescription(), e.isEnabled())
        ).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
         */
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Role obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    /*@GetMapping("/response/{id}")
    public ResponseEntity<ResponseDTO<RoleDTO>> readByIdResponse(@PathVariable("id") Integer id) throws Exception{
        Role obj = service.readById(id);
        RoleDTO dto = convertToDto(obj);
        ResponseDTO<RoleDTO> res = new ResponseDTO<>();
        res.setData(List.of(dto));
        res.setStatus(200);
        res.setMessage("OK");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<RoleDTO> create(@Valid @RequestBody RoleDTO dto) throws Exception {
        Role obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody RoleDTO dto) throws Exception {
        dto.setIdRole(id);
        Role obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private RoleDTO convertToDto(Role obj){
        return mapper.map(obj, RoleDTO.class);
    }

    private Role convertToEntity(RoleDTO dto){
        return mapper.map(dto, Role.class);
    }
}
