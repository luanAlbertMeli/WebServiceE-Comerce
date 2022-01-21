package com.example.curso.DTO;

import com.example.curso.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String name;
    private String email;
    private String phone;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private LocalDate dateCreated;

    public static User convert(UserDTO dto){
        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .password(dto.getPassword())
                .dateCreated(dto.getDateCreated())
                .build();
        return user;
    }

    public static UserDTO convert(User user){
       return UserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .dateCreated(user.getDateCreated())
                .build();
    }
    public static List<UserDTO> convert(List<User> user){
        return user.stream().map(u -> convert(u)).collect(Collectors.toList());
    }
}
