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
        val uuid = event.player.uniqueId

        if (uuid.toString() in ToSCC.agree) return

        val component1 = TextComponent("${GREEN}同意する")
        val component2 = TextComponent("${RED}同意しない")
        component1.clickEvent = ClickEvent(ClickEvent.Action.RUN_COMMAND, "/agree")
        component2.clickEvent = ClickEvent(ClickEvent.Action.RUN_COMMAND, "/disagree")

        ToSCC.checking.add(uuid.toString())
        event.player.sendMessage(ToSCC.message)
        event.player.spigot().sendMessage(component1)
        event.player.sendMessage("\n")
        event.player.spigot().sendMessage(component2)
        event.player.sendMessage("\n")

        return
    }
}