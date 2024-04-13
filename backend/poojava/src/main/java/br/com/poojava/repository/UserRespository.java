package br.com.poojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.poojava.models.UserModel;

public interface UserRespository extends JpaRepository<UserModel, Long>{
    UserModel findByEmail(String email);
    UserModel deleteByEmail(String email);
}
