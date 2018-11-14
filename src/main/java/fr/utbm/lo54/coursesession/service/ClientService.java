package fr.utbm.lo54.coursesession.service;

import fr.utbm.lo54.coursesession.dao.ClientRepository;
import fr.utbm.lo54.coursesession.entity.Client;
import fr.utbm.lo54.coursesession.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements ClientMetier {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client saveClient(Client c) {
        c.setPassword(passwordEncoder.encode(c.getPassword()));
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
    public Client findOne(Long id) {
        return clientRepository.getOne(id);
    }

    @Override
    public Client findByEmail(String email){
        return clientRepository.findByEmail(email);
    }

    @Override
    public boolean clientExists(Client c) {
        return findByEmail(c.getEmail()) != null;
    }
}
