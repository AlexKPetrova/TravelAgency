package service;

import models.Client;
import repositories.ClientRepositories;
import repositories.ClientRepositoriesImpl;

import java.util.List;

public class ClientServiceImpl implements ClientService{

    private static ClientRepositories clientRepositories = new ClientRepositoriesImpl();

    @Override
    public Client find(Integer id) {
        return clientRepositories.find(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepositories.findAll();
    }

    @Override
    public void save(Client client) {
        clientRepositories.save(client);
    }

    @Override
    public void update(Client client) {
        clientRepositories.update(client);
    }

    @Override
    public Client findByHumanId(Integer id) {
        return clientRepositories.findByHumanId(id);
    }
}
