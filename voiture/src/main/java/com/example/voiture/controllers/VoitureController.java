package com.example.voiture.controllers;

import com.example.voiture.entities.Voiture;
import com.example.voiture.repositories.VoitureRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class VoitureController {

    @Autowired
    private VoitureRepository voitureRepository;

    // GET : liste de toutes les voitures
    @GetMapping("/voitures")
    public List<Voiture> findAll() {
        return voitureRepository.findAll();
    }

    // GET : trouver une voiture par ID
    @GetMapping("/voiture/{id}")
    public Voiture findById(@PathVariable Long id) throws Exception {
        return voitureRepository.findById(id)
                .orElseThrow(() -> new Exception("Voiture non trouvée"));
    }

    // POST : ajouter une voiture
    @PostMapping("/voiture")
    public Voiture save(@RequestBody Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    // DELETE : supprimer une voiture par ID
    @DeleteMapping("/voiture/{id}")
    public void delete(@PathVariable Long id) {
        voitureRepository.deleteById(id);
    }
}
