package hu.balintzoltan.vereczki.keretrendszer_beadando.dao;

import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.NoMatchingId;
import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Mufaj;
import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Zene;

import java.util.Collection;
import java.util.UUID;

public interface ZeneDAO {
    void createZene(Zene zene);
    Zene getZeneById(String id) throws NoMatchingId;
    Collection<Zene> getAllZene();
    Collection<Zene> getZeneByMufaj(Mufaj mufaj);
    void updateZene(Zene zene) throws NoMatchingId;
    void removeZene(Zene zene) throws NoMatchingId;
}
