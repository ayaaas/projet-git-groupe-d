package com.groupd.git_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Entité représentant un produit dans le catalogue.
 * Gère le nom, la catégorie, le prix et les tags pour la génération IA.
 */
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du produit est obligatoire")
    @Size(min = 2, max = 100, message = "Le nom doit contenir entre 2 et 100 caractères")
    @Column(nullable = false)
    private String nom;

    @NotBlank(message = "La catégorie est obligatoire")
    @Column(nullable = false)
    private String categorie;

    @NotNull(message = "Le prix est obligatoire")
    @DecimalMin(value = "0.0", inclusive = false, message = "Le prix doit être positif")
    @Column(nullable = false)
    private Double prix;

    /**
     * Tags séparés par des virgules, utilisés comme mots-clés pour la génération IA.
     * Exemple : "bio, sans gluten, artisanal"
     */
    @ElementCollection
    @CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "tag")
    private List<String> tags;

    /** Description générée par l'IA (nullable — générée à la demande) */
    @Column(columnDefinition = "TEXT")
    private String descriptionIa;
}