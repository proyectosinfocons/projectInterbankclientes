package com.example.projectInterbankclientes.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Integer idUser;

    @NotNull
    @JsonIncludeProperties(value = {"idRole", "nameRole"})
    private RoleDTO role;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String username;

    //@JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 10, max = 60)
    private String password;

    @NotNull
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean enabled;
}
