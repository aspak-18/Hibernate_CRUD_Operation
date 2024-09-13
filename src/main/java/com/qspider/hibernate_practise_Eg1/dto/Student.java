package com.qspider.hibernate_practise_Eg1.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student")
public class Student {
    @Id
    private int id;
    @Column(name="s_name",length = 20,nullable = false)
    private String name;
    private String address;
    private LocalDate dob;
}
