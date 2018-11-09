package fr.utbm.lo54.coursesession.service;

import fr.utbm.lo54.coursesession.dao.ClientRepository;
import fr.utbm.lo54.coursesession.entity.Client;
import fr.utbm.lo54.coursesession.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements ClientMetier {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client saveClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public void updateClient(Client c) {
        saveClient(c);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public boolean clientExists(Client c) {
        return false;
    }

    @Override
    public Client findOne(Long id) {
        return clientRepository.getOne(id);
    }
}
