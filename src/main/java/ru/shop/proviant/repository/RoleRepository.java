package ru.shop.proviant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.proviant.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
