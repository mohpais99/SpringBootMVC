package com.mastahcode.LearnSpringWeb.Repository;

import com.mastahcode.LearnSpringWeb.Model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer> {
}
