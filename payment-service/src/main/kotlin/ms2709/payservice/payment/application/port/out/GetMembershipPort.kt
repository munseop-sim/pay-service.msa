package ms2709.payservice.payment.application.port.out

/**
 *
 * 클래스 설명
 *
 *  CreatePaymentPort
 * @author 심문섭
 * @version 1.0
 * @since 2024-06-02 오후 11:25
 */
interface GetMembershipPort {
    fun getMembership(membershipId:String):MembershipStatus
}