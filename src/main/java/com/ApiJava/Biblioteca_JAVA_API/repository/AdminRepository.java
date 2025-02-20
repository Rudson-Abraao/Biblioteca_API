package com.ApiJava.Biblioteca_JAVA_API.repository;

import com.ApiJava.Biblioteca_JAVA_API.model.Admin;
import com.ApiJava.Biblioteca_JAVA_API.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
