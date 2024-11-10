package org.projarq.subscription_status_cache.use_cases;

import org.projarq.subscription_status_cache.domain.data_access.AssinaturaDataAccess;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BuscarStatusAssinatura
{
    public BuscarStatusAssinatura(AssinaturaDataAccess assinaturaDataAccess)
    {
        this.assinaturaDataAccess = assinaturaDataAccess;
    }

    public boolean getStatusAssinatura(long assinaturaId)
    {
        return assinaturaDataAccess.getDataVigencia(assinaturaId).isAfter(LocalDate.now());
    }

    private final AssinaturaDataAccess assinaturaDataAccess;
}
