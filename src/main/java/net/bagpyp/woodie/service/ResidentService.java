package net.bagpyp.woodie.service;

import net.bagpyp.woodie.data.model.Resident;
import net.bagpyp.woodie.data.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // same thing as Bean or Component but mnemonic
public class ResidentService {

    private final ResidentRepository residentRepository;

    @Autowired
    public ResidentService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    public List<Resident> getResidents() {
        return residentRepository.findAll();
    }

    public Long addResidentAndReturnId(Resident resident) {
        Optional<Resident> residentOptional = residentRepository
                .findResidentByEmail(resident.getEmail());
        if (residentOptional.isPresent()) {
            throw new IllegalStateException("email taken!");
        }
        residentRepository.save(resident);
        return residentRepository.findResidentByEmail(resident.getEmail()).get().getId();
    }

    public void deleteResident(Long residentId) {
        boolean residentExists = residentRepository.existsById(residentId);
        if (!residentExists) {
            throw new IllegalStateException(
                    "resident with id " + residentId + " does not exist"
            );
        }
        residentRepository.deleteById(residentId);
    }

    @Transactional
    public void updateResident(Long residentId, Resident resident) {
        var currentResident = residentRepository.findById(residentId)
                .orElseThrow(() -> new IllegalStateException(
                        "resident with id " + residentId + " does not exist!"
                ));

        var firstName = resident.getFirstName();
        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(firstName, currentResident.getFirstName())) {
            currentResident.setFirstName(firstName);
        }

        var lastName = resident.getLastName();
        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(lastName, currentResident.getLastName())) {
            currentResident.setLastName(lastName);
        }

        var email = resident.getEmail();
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(email, currentResident.getEmail())) {
            currentResident.setEmail(email);
        }

        var rent = resident.getRent();
        if (rent != null &&
                rent > 0 &&
                !Objects.equals(rent, currentResident.getRent())) {
            currentResident.setRent(rent);
        }

        var middleInitial = resident.getMiddleInitial();
        if (middleInitial != null &&
                middleInitial > 0 &&
                !Objects.equals(middleInitial, currentResident.getMiddleInitial())) {
            currentResident.setMiddleInitial(middleInitial);
        }
    }
}
