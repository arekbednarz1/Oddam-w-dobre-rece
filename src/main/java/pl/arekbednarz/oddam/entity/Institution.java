package pl.arekbednarz.oddam.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "institution")
@Getter
@Setter
@ToString
public class Institution {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        private String name;

        private String description;

    }


