package service;

import model.Eloado;
import model.Mufaj;

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
