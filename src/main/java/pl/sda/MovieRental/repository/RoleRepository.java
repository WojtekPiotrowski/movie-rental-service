package pl.sda.MovieRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.MovieRental.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
