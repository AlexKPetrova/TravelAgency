package service;

import models.Client;


import java.util.List;

public interface ClientService {

    Client find(Integer id);

    List<Client> findAll();

    void save(Client client);

    void update(Client client);

    public Client findByHumanId(Integer id);
}
