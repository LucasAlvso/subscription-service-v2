package org.projarq.subscription_status_cache.adapters;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@FeignClient(name = "subscription-service")
public interface AssinaturaProxy
{
    @GetMapping("/servcad/assinaturas/datatermino/{assinaturaId}")
    LocalDate getStatusAssinatura(@PathVariable long assinaturaId);
}
