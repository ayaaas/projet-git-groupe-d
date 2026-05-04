package com.groupd.git_project.controller;



import com.groupd.git_project.model.Product;
//import com.groupd.git_project.service.AiDescriptionService; 
import com.groupd.git_project.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Contrôleur REST exposant les endpoints CRUD pour les produits.
 * Base URL : /api/products
 */
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    //private final AiDescriptionService aiDescriptionService;

    /** GET /api/products → Liste tous les produits */
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    /** GET /api/products/{id} → Récupère un produit par ID */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    /** POST /api/products → Crée un nouveau produit */
    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        Product created = productService.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /** PUT /api/products/{id} → Met à jour un produit */
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,
                                          @Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.update(id, product));
    }

    /** DELETE /api/products/{id} → Supprime un produit */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * POST /api/products/{id}/generate-description
     * Lance la génération IA de description pour un produit donné.
     */
    // @PostMapping("/{id}/generate-description")
    // public ResponseEntity<Product> generateDescription(@PathVariable Long id) {
    //     Product product = productService.findById(id);
    //     String description = aiDescriptionService.generateDescription(
    //             product.getNom(), product.getTags());
    //     Product updated = productService.saveDescription(id, description);
    //     return ResponseEntity.ok(updated);
    // }

    /** Gestion globale des erreurs de validation */
    @ExceptionHandler(jakarta.persistence.EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()));
    }
}