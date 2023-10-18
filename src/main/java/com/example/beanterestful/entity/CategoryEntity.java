package com.example.beanterestful.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Category")

@Builder
@Entity

public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Category_id;

    private String Category_name;

    @OneToMany(mappedBy = "CategoryEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoryEntity> CategoryEntityList = new ArrayList<CategoryEntity>();

}
