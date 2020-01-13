package dev.siro256.spigotpl.toscc

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object DisagreeCommand : CommandExecutor {

    override fun onCommand(
        sender: CommandSender,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        val player = sender as? Player ?: return true
        val uuid = player.uniqueId

        if (uuid.toString() !in ToSCC.checking) return true

        uuid.toString().also { uuidText ->
            ToSCC.checking -= uuidText
            ToSCC.moveMessageSent -= uuidText
            ToSCC.chatMessageSent -= uuidText
        }

        player.kickPlayer("利用規約に同意しなかったため、サーバーからキックされました。")

        return true
    }
}