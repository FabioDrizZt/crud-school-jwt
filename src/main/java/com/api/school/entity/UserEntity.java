package com.api.school.entity;

import com.api.school.util.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="users")
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String email;

    private String password;
    private Role role;
}
