package dev.siro256.spigotpl.toscc

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class AsyncPlayerChatEvent: Listener {

    @EventHandler
    fun onAsyncPlayerChat(event: AsyncPlayerChatEvent) {
        ToSCC.checking.forEach { event.recipients.remove(Bukkit.getPlayer(it)) }
        if (ToSCC.agree.contains(event.player.uniqueId.toString())) return

        event.isCancelled = true
        if (!ToSCC.chatMessageSent.contains(event.player.uniqueId.toString())) {
            event.player.sendMessage("${ChatColor.RED}規約に同意していないため発言できません。")
            ToSCC.chatMessageSent.add(event.player.uniqueId.toString())
        }
    }
}