package hu.balintzoltan.vereczki.keretrendszer_beadando.dao;

import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Mufaj;
import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Zene;

import java.util.Collection;
import java.util.UUID;

public interface ZeneDAO {
    void createZene(Zene zene);
    Zene getZeneById(String id);
    Collection<Zene> getAllZene();
    Collection<Zene> getZeneByMufaj(Mufaj mufaj);
    void updateZene(Zene zene);
    void removeZene(Zene zene);
}
