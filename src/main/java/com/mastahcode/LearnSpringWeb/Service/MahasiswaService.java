package com.mastahcode.LearnSpringWeb.Service;

import com.mastahcode.LearnSpringWeb.Model.Mahasiswa;
import com.mastahcode.LearnSpringWeb.Repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahasiswaService {
    @Autowired
    private MahasiswaRepository mhsRepo;

    public List<Mahasiswa> listAll() {
        return mhsRepo.findAll();
    }

    public void save(Mahasiswa mhs) {
        mhsRepo.save(mhs);
    }

    public Mahasiswa get(Integer id) {
        return mhsRepo.findById(id).get();
    }

    public void delete(Integer id) {
        mhsRepo.deleteById(id);
    }
}
