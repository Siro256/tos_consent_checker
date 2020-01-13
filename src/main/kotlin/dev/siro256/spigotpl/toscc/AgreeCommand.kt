package dev.siro256.spigotpl.toscc

import org.bukkit.ChatColor.GREEN
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object AgreeCommand : CommandExecutor {

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

            ToSCC.agree.add(uuidText)
            AgreeTxt().addList(uuidText)
        }

        sender.sendMessage("${GREEN}利用規約に同意したことを確認しました。")

        return true
    }
}