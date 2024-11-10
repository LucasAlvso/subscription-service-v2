package org.projarq.subscription_status_cache.domain.data_access;

import org.projarq.subscription_status_cache.adapters.AssinaturaProxy;
import org.projarq.subscription_status_cache.adapters.SubscriptionProxy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;

@Component
public class AssinaturaDataAccess
{
    public AssinaturaDataAccess(AssinaturaProxy proxy)
    {
        this.proxy = proxy;
    }

    public LocalDate getDataVigencia(long assinaturaId)
    {
        return statusParaVigencia.computeIfAbsent(assinaturaId, proxy::getStatusAssinatura);
    }

	public void atualizarStatusAssinatura(long assinaturaId, LocalDate novaDataVigencia)
	{
        statusParaVigencia.put(assinaturaId, novaDataVigencia);
	}

    private final AssinaturaProxy proxy;
    private final HashMap<Long, LocalDate> statusParaVigencia = new HashMap<>();
}
