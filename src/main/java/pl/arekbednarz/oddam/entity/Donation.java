package pl.arekbednarz.oddam.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donation")
@ToString
@Getter
@Setter
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Podaj liczbę worków")
    private Integer quantity;

    @ManyToMany
    @JoinTable(name = "donation_category",
            joinColumns = @JoinColumn(name = "donation_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))


    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    @NotNull(message = "Wybierz instytucję")
    private Institution institution;


    @NotBlank(message = "Podaj nazwę ulicy")
    private String street;

    @NotBlank
    private String city;


    private String zipCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate pickUpDate;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;

    private String pickUpComment;




}
