package org.projarq.subscription_status_cache.domain.model;

import java.time.LocalDate;

public record AtualizacaoStatusAssinatura(long assinaturaId, LocalDate novaDataVigencia)
{
}
