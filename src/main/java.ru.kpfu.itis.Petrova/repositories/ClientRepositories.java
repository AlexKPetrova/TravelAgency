package repositories;

import models.Client;

import java.util.List;

public interface ClientRepositories {

    Client find(Integer id);

    List<Client> findAll();

    void save(Client client);

    void update(Client client);

    public Client findByHumanId(Integer id);
}
