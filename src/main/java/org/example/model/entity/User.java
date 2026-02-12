package org.example.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public record User(
    @Id
    String id,
    String name,
    String email,
    String address,
    String nationalityCode,
    String hobby
) {
    public User withName(String newName) {
        return new User(this.id, newName, this.email, this.address, this.nationalityCode, this.hobby);
    }

    public User withEmail(String newEmail) {
        return new User(this.id, this.name, newEmail, this.address, this.nationalityCode, this.hobby);
    }
}
