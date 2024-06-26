package ms2709.payservice.banking.application.port.out;

import ms2709.payservice.banking.adapter.out.persistence.entity.RegisteredBankAccountJpaEntity;
import ms2709.payservice.banking.application.port.in.FindBankAccountCommand;

/**
 * 클래스 설명
 *
 * @author 심문섭
 * @version 1.0
 *  FindBankAccountPort
 * @since 2024-05-15 오전 10:40
 */
public interface FindBankAccountPort {
    RegisteredBankAccountJpaEntity findBankAccount(FindBankAccountCommand findBankAccountCommand);
}
