package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.entities.Doctor;
import med.voll.api.records.DataDoctorCreate;
import med.voll.api.records.DataDoctorList;
import med.voll.api.records.DataDoctorUpdate;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public Page<DataDoctorList> list(Pageable paginacao) {
        return doctorRepository.findAllByAtivoTrue(paginacao).map(DataDoctorList::new);
    }

    @PostMapping
    @Transactional
    public void add(@RequestBody @Valid DataDoctorCreate data) {
        doctorRepository.save(new Doctor(data));
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataDoctorUpdate dados) {
        var doctor = doctorRepository.getReferenceById(dados.id());
        doctor.updateInformation(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.delete();
    }
}
