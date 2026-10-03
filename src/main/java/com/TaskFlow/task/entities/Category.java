package com.TaskFlow.task.entities;

import com.TaskFlow.task.entities.Enum.Categories;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Category")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id;

    @Column(nullable = false)
    private Categories name;

    @OneToOne
    @JoinColumn(name="task_id", unique = true)
    @JsonIgnore
    private Task task;
}
