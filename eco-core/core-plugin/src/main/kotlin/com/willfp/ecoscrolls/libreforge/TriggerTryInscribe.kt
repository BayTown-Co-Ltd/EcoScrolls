package com.willfp.ecoscrolls.libreforge

import com.willfp.ecoscrolls.scrolls.event.ScrollTryInscribeEvent
import com.willfp.libreforge.toDispatcher
import com.willfp.libreforge.triggers.Trigger
import com.willfp.libreforge.triggers.TriggerData
import com.willfp.libreforge.triggers.TriggerParameter
import org.bukkit.event.EventHandler

object TriggerTryInscribe : Trigger("try_inscribe") {
    override val parameters = setOf(
        TriggerParameter.ITEM,
        TriggerParameter.PLAYER,
        TriggerParameter.EVENT
    )

    @EventHandler
    fun handle(event: ScrollTryInscribeEvent) {
        this.dispatch(
            event.player.toDispatcher(),
            TriggerData(
                player = event.player,
                item = event.itemStack,
                event = event
            )
        )
    }
}
