package dev.siro256.spigotpl.toscc

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object DisagreeCommand: CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command?, label: String?, args: Array<out String>?): Boolean {
        val sender = sender as Player

        if (!ToSCC.checking.contains(sender.uniqueId.toString())) return true

        ToSCC.checking.remove(sender.uniqueId.toString())
        ToSCC.moveMessageSent.remove(sender.uniqueId.toString())
        ToSCC.chatMessageSent.remove(sender.uniqueId.toString())
        sender.kickPlayer("利用規約に同意しなかったため、サーバーからキックされました。")

        return true
    }
}