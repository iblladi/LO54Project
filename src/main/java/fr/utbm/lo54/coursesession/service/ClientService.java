package fr.utbm.lo54.coursesession.service;

import fr.utbm.lo54.coursesession.entity.Client;
import fr.utbm.lo54.coursesession.metier.ClientMetier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements ClientMetier {

    @Override
    public List<Client> listClient() {
        return null;
    }

    @Override
    public Client saveClient(Client c) {
        return null;
    }

    @Override
    public void updateClient(Client c) {

    }

    @Override
    public void deleteClient(Long id) {

    }

    @Override
    public boolean clientExists(Client c) {
        return false;
    }

    @Override
    public Client findOne(Long id) {
        return null;
    }
}
