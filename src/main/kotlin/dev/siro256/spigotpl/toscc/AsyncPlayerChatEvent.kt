package dev.siro256.spigotpl.toscc

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class AsyncPlayerChatEvent : Listener {

    @EventHandler
    fun onAsyncPlayerChat(event: AsyncPlayerChatEvent) {
        val uuid = event.player.uniqueId

        ToSCC.checking.forEach { event.recipients -= Bukkit.getPlayer(it) }

        if (ToSCC.agree.contains(uuid.toString())) return

        event.isCancelled = true

        if (uuid.toString() !in ToSCC.chatMessageSent) {
            event.player.sendMessage("${ChatColor.RED}規約に同意していないため発言できません。")
            ToSCC.chatMessageSent.add(uuid.toString())
        }
    }
}