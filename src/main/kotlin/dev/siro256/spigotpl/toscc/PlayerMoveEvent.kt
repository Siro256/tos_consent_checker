package dev.siro256.spigotpl.toscc

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

class PlayerMoveEvent : Listener {

    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        val uuid = event.player.uniqueId
        if (uuid.toString() !in ToSCC.checking) return

        event.isCancelled = true

        if (uuid.toString() !in ToSCC.moveMessageSent) {
            event.player.sendMessage("${ChatColor.RED}規約に同意していないため移動できません。")
            ToSCC.moveMessageSent.add(uuid.toString())
        }
    }

}