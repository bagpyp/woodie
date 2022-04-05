package net.bagpyp.woodie;

import net.bagpyp.woodie.data.model.Resident;
import net.bagpyp.woodie.service.ResidentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WoodieApplicationTest {

    @Autowired
    private ResidentService residentService;

    @Test
    void contextLoads() {
        List<Resident> residents = residentService.getResidents();
        assertEquals(3, residents.toArray().length);
    }
}