package net.bagpyp.woodie.config;

import net.bagpyp.woodie.data.model.Resident;
import net.bagpyp.woodie.data.repository.ResidentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ResidentConfig {

    @Bean
    CommandLineRunner commandLineRunner(ResidentRepository repository) {
        return args -> {
            var robbie = Resident.builder()
                    .firstName("Robert")
                    .middleInitial('T')
                    .lastName("Cunningham")
                    .email("rtc@bagpyp.net")
                    .birthDate(LocalDate.of(1992, Month.FEBRUARY, 25))
                    .rent(1000.00F)
                    .build();
            var kermit = new Resident(
                    "Kermit",
                    'T',
                    "Frog",
                    "kermie_420@example.com",
                    LocalDate.of(1992, Month.MARCH, 30),
                    1000.00F
            );
            var carmen = new Resident(
                    "Carmen",
                    'S',
                    "Diego",
                    "whereami@example.com",
                    LocalDate.of(1992, Month.OCTOBER, 1),
                    1000.00F
            );

            repository.saveAll(
                    List.of(
                            robbie,
                            kermit,
                            carmen
                    )
            );
        };
    }
}
