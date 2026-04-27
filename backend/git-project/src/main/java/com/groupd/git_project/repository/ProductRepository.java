package com.groupd.git_project.repository;

import com.groupd.git_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository JPA pour les opérations CRUD sur les produits.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /** Recherche par catégorie (insensible à la casse) */
    List<Product> findByCategorieIgnoreCase(String categorie);

    /** Recherche par nom contenant une chaîne */
    List<Product> findByNomContainingIgnoreCase(String nom);

    /** Produits dont le prix est inférieur ou égal à un maximum */
    List<Product> findByPrixLessThanEqual(Double prixMax);
}
