package org.projarq.domain.entities;

import java.time.LocalDate;

public record AtualizacaoStatusAssinatura(long assinaturaId, LocalDate novaDataVigencia)
{
}
