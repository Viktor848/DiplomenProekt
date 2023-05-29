package com.example.DiplomenProekt.Repository;

import com.example.DiplomenProekt.Entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminsRepository extends JpaRepository<Admins, Long> {
    @Query("SELECT u FROM Admins u WHERE u.email = ?1")
    public Admins findByEmail(String email);
}