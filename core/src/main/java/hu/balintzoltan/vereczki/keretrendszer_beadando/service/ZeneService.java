package hu.balintzoltan.vereczki.keretrendszer_beadando.service;

import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Mufaj;
import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Zene;

import java.util.Collection;
import java.util.UUID;

public interface ZeneService {
    void createZene(Zene zene);
    Zene getZeneById(UUID id);
    Collection<Zene> getAllZene();
    Collection<Zene> getZeneByMufaj(Mufaj mufaj);
    void updateZene(Zene zene);
    void removeZene(Zene zene);
}
