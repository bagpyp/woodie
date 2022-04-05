package net.bagpyp.woodie.controller;

import net.bagpyp.woodie.data.model.Resident;
import net.bagpyp.woodie.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/resident")
public class ResidentController {

    // Is autowired because of the below contstructor and because it's a Bean!
    private final ResidentService residentService;

    @Autowired
    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping
    public List<Resident> getResidents() {
        return residentService.getResidents();
    }

    @PostMapping
    public Long addResident(@RequestBody Resident resident) {
        return residentService.addResidentAndReturnId(resident);
    }

    @PutMapping(path = "{residentId}")
    public void updateResident(@PathVariable("residentId") Long residentId, @RequestBody Resident resident) {
        residentService.updateResident(residentId, resident);
    }

    @DeleteMapping(path = "{residentId}")
    public void deleteResident(@PathVariable("residentId") Long residentId) {
        residentService.deleteResident(residentId);
    }
}
