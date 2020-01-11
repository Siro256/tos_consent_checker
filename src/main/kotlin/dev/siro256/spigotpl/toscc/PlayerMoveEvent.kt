package dev.siro256.spigotpl.toscc

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

class PlayerMoveEvent: Listener {

    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        if (!ToSCC.checking.contains(event.player.uniqueId.toString())) return

        event.isCancelled = true
        if (!ToSCC.moveMessageSent.contains(event.player.uniqueId.toString())) {
            event.player.sendMessage("${ChatColor.RED}規約に同意していないため移動できません。")
            ToSCC.moveMessageSent.add(event.player.uniqueId.toString())
        }
    }
}