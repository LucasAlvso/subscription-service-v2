package org.projarq.subscription_status_cache.adapters.controllers;

import org.projarq.subscription_status_cache.use_cases.BuscarStatusAssinatura;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssinaturaController
{
    public AssinaturaController(BuscarStatusAssinatura buscarStatusAssinatura)
    {
        this.buscarStatusAssinatura = buscarStatusAssinatura;
    }

    @GetMapping("/assinvalida/{assinaturaId}")
    public boolean getStatusAssinatura(@PathVariable long assinaturaId)
    {
        return !buscarStatusAssinatura.getStatusAssinatura(assinaturaId);
    }

    private final BuscarStatusAssinatura buscarStatusAssinatura;
}
