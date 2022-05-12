package com.springboottutorials.springboottutorials.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User
{
    @Id
    @SequenceGenerator(name = "boot_seq_gen",
                sequenceName = "boot_seq_gen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boot_seq_gen")
    private Long id;
    private String name;
    private String city;
    private String jobStatus;
}
