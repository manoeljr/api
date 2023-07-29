package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.entities.Doctor;
import med.voll.api.registy.DataDoctor;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public ResponseEntity<List<Doctor>> list() {
        return ResponseEntity.ok().body(doctorRepository.findAll());
    }

    @PostMapping
    @Transactional
    public void add(@RequestBody @Valid DataDoctor data) {
        doctorRepository.save(new Doctor(data));
    }
}
