package ms2709.member.adapter.`in`.web

import ms2709.member.application.port.`in`.FindMembershipCommand
import ms2709.member.application.port.`in`.FindMembershipUseCase
import ms2709.member.domain.Membership
import ms2709.member.global.WebAdapter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

/**
 *
 * 멤버십 조회를 위한 컨트롤러
 *
 * @class FindMembershipController
 * @author 심문섭
 * @version 1.0
 * @since 2024-04-29 10:39 PM
 */
@WebAdapter
@RequestMapping("/membership")
class FindMembershipController(
    private val findMembershipUseCase: FindMembershipUseCase
) {
    @GetMapping("/find/{membershipId}")
    fun findMembership(@PathVariable membershipId: String):Membership {
        return FindMembershipCommand(membershipId).run {
            findMembershipUseCase.findMembership(this)
        }
    }
}