package ms2709.payservice.payment.adapter.out.persistence

import ms2709.global.PersistenceAdapter
import ms2709.payservice.payment.adapter.out.persistence.entity.PaymentJpaEntity
import ms2709.payservice.payment.adapter.out.persistence.repository.PaymentJpaEntityRepository
import ms2709.payservice.payment.application.port.out.CreatePaymentPort
import ms2709.payservice.payment.domain.Payment
import java.time.LocalDateTime

/**
 *
 * 클래스 설명
 *
 * @class PaymentPersistenceAdapter
 * @author 심문섭
 * @version 1.0
 * @since 2024-06-02 오후 11:42
 */
@PersistenceAdapter
class PaymentPersistenceAdapter (
    private val repository: PaymentJpaEntityRepository,
    private val mapper:PaymentMapper
): CreatePaymentPort {
    override fun createPayment(
        requestMemberId: String,
        requestPrice: String,
        franchiseId: String,
        franchiseFeeRate: String
    ): Payment {
        val paymentJpaEntity = repository.save(
            PaymentJpaEntity(
                requestMemberId = requestMemberId,
                requestPrice = requestPrice.toInt(),
                franchiseId = franchiseId,
                franchiseFeeRate = franchiseFeeRate,
                paymentStatus = 0,
                approvedAt = LocalDateTime.now()
            )
        )
        return mapper.mapToDomainEntity(paymentJpaEntity)
    }
}