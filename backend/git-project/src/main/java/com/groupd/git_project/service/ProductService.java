package com.groupd.git_project.service;

import com.groupd.git_project.model.Product;
import com.groupd.git_project.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service métier pour la gestion des produits.
 * Contient la logique applicative séparée du contrôleur.
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /** Récupère tous les produits */
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /** Récupère un produit par son ID */
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Produit introuvable avec l'id : " + id));
    }

    /** Crée un nouveau produit */
    public Product create(Product product) {
        return productRepository.save(product);
    }

    /** Met à jour un produit existant */
    public Product update(Long id, Product updatedProduct) {
        Product existing = findById(id);
        existing.setNom(updatedProduct.getNom());
        existing.setCategorie(updatedProduct.getCategorie());
        existing.setPrix(updatedProduct.getPrix());
        existing.setTags(updatedProduct.getTags());
        return productRepository.save(existing);
    }

    /** Supprime un produit */
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Produit introuvable avec l'id : " + id);
        }
        productRepository.deleteById(id);
    }

    /** Sauvegarde la description IA générée */
    public Product saveDescription(Long id, String description) {
        Product product = findById(id);
        product.setDescriptionIa(description);
        return productRepository.save(product);
    }
}
