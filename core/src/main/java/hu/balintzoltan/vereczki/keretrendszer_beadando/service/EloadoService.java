package hu.balintzoltan.vereczki.keretrendszer_beadando.service;

import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Eloado;
import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Mufaj;

import java.util.Collection;
import java.util.UUID;

public interface EloadoService {
    void createEloado(Eloado eloado);
    Eloado getEloadoById(UUID id);
    Collection<Eloado> getAllEloado();
    Collection<Eloado> getEloadoByMufaj(Mufaj mufaj);
    void updateEloado(Eloado eloado);
    void removeEloado(Eloado eloado);
}
