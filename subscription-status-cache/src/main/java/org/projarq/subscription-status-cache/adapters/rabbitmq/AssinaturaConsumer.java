package org.projarq.subscription_status_cache.adapters.rabbitmq;

import org.projarq.subscription_status_cache.domain.data_access.AssinaturaDataAccess;
import org.projarq.subscription_status_cache.domain.model.AtualizacaoStatusAssinatura;
import org.projarq.subscription_status_cache.domain.model.SubscriptionStatusUpdate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.lang.NonNull;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AssinaturaConsumer
{
	public AssinaturaConsumer(AssinaturaDataAccess assinaturaDataAccess)
	{
		this.assinaturaDataAccess = assinaturaDataAccess;
	}

	@RabbitListener(queues = "#{rabbitConfig.getQueueName()}")
	public void AssinaturaListener(@Payload @NonNull AtualizacaoStatusAssinatura assinatura)
	{
		assinaturaDataAccess.atualizarStatusAssinatura(assinatura.assinaturaId(), assinatura.novaDataVigencia());
	}

	private final AssinaturaDataAccess assinaturaDataAccess;
}
