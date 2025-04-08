package br.com.aldbio.controle_veiculos.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import br.com.aldbio.controle_veiculos.auth.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
