package com.loja.compras.domain;

import com.loja.compras.graphql.dto.CompraResumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    CompraRepository repository;

    public Compra findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Compra> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Compra save(Compra compra) {
        return repository.save(compra);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Compra> findAllByCliente(Cliente cliente) {
        return repository.findAllByCliente(cliente.getId());
    }

    public List<CompraResumo> findAllComprasRelatorio() {
        return repository.findAllComprasRelatorio();
    }
}
