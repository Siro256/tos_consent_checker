package dev.siro256.spigotpl.toscc

import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.ChatColor.GREEN
import org.bukkit.ChatColor.RED
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinEvent : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val uuid = player.uniqueId

        if (uuid.toString() in ToSCC.agree) return

        val componentList = listOf(
            TextComponent("${GREEN}同意する").apply {
                clickEvent = ClickEvent(ClickEvent.Action.RUN_COMMAND, "/agree")
            },
            TextComponent("${RED}同意しない").apply {
                clickEvent = ClickEvent(ClickEvent.Action.RUN_COMMAND, "/disagree")
            }
        )

        ToSCC.checking.add(uuid.toString())
        player.sendMessage(ToSCC.message)

        componentList.forEach { component ->
            player.spigot().sendMessage(component)
            player.sendMessage("\n")
        }
    }

}