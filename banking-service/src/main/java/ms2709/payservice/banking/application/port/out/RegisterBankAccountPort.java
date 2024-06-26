package ms2709.payservice.banking.application.port.out;

import ms2709.payservice.banking.adapter.out.persistence.entity.RegisteredBankAccountJpaEntity;
import ms2709.payservice.banking.domain.RegisteredBankAccount;

/**
 * 클래스 설명
 *
 * @author 심문섭
 * @version 1.0
 *  RegisterBankAccountPort
 * @since 2024-05-13 오후 11:22
 */
public interface RegisterBankAccountPort {
    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid,
            RegisteredBankAccount.AggregateIdentifier aggregateIdentifier
    );
}
