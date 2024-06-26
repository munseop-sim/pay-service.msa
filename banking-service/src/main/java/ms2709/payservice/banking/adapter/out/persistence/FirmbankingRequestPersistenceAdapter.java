package ms2709.payservice.banking.adapter.out.persistence;

import ms2709.payservice.banking.adapter.out.persistence.entity.FirmbankingRequestJpaEntity;
import ms2709.payservice.banking.adapter.out.persistence.repository.FirmbankingRequestJpaEntityRepository;
import ms2709.payservice.banking.application.port.out.FindFirmbankingRequestPort;
import ms2709.payservice.banking.application.port.out.RequestFirmbankingPort;
import ms2709.payservice.banking.domain.FirmbankingRequest;
import lombok.RequiredArgsConstructor;
import ms2709.global.PersistenceAdapter;

import java.util.List;
import java.util.UUID;

/**
 * 클래스 설명
 *
 * @author 심문섭
 * @version 1.0
 *  FirmbankingRequestPersistanceAdapter
 * @since 2024-05-15 오후 12:02
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class FirmbankingRequestPersistenceAdapter implements RequestFirmbankingPort, FindFirmbankingRequestPort {

    private final FirmbankingRequestJpaEntityRepository repository;

    @Override
    public FirmbankingRequestJpaEntity createFirmbankingRequest(FirmbankingRequest.FromBankName fromBankName, FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber, FirmbankingRequest.ToBankName toBankName, FirmbankingRequest.ToBankAccountNumber toBankAccountNumber, FirmbankingRequest.MoneyAmount moneyAmount, FirmbankingRequest.FirmBankingStatus firmBankingStatus, FirmbankingRequest.FirmbankingAggregateIdentifier aggregateIdentifier) {
        return repository.save(
                new FirmbankingRequestJpaEntity(
                        fromBankName.value(),
                        fromBankAccountNumber.value(),
                        toBankName.value(),
                        toBankAccountNumber.value(),
                        moneyAmount.value(),
                        firmBankingStatus.value(),
                        UUID.randomUUID().toString(),
                        aggregateIdentifier.value()
                )
        );
    }

    @Override
    public FirmbankingRequestJpaEntity modifyFirmbankingRequest(FirmbankingRequestJpaEntity firmbankingRequestJpaEntity) {
        return repository.save(firmbankingRequestJpaEntity);
    }

    @Override
    public FirmbankingRequestJpaEntity getFirmbankingRequest(FirmbankingRequest.FirmbankingAggregateIdentifier firmbankingAggregateIdentifier) {
        List<FirmbankingRequestJpaEntity> entityList =  repository.findByAggregateIdentifier(firmbankingAggregateIdentifier.value());
        if(entityList.size() > 0) {
            return entityList.get(0);
        }
        return null;
    }

    @Override
    public FirmbankingRequestJpaEntity findFirmbankingRequest(FirmbankingRequest.FirmbankingRequestId firmbankingRequestId) {
        var id = Long.parseLong(firmbankingRequestId.value());
        return repository.findById(id).orElse(null);
    }
}
