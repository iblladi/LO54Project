package fr.utbm.lo54.coursesession.metier;

import fr.utbm.lo54.coursesession.entity.Client;

import java.util.List;

public interface ClientMetier {

    public List<Client> listClient();

    public Client saveClient(Client c);

    public void updateClient(Client c);

    public void deleteClient(Long id);

    public boolean clientExists(Client c);

    public Client findOne(Long id);

    public Client findByEmail(String email);

    public String searchRegistredInSession(Long id,Long id1);

}
