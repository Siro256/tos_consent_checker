package dev.siro256.spigotpl.toscc

import org.bukkit.ChatColor.*
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object AgreeCommand: CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command?, label: String?, args: Array<out String>?): Boolean {
        val player = sender as Player

        if (!ToSCC.checking.contains(player.uniqueId.toString())) return true

        ToSCC.checking.remove(player.uniqueId.toString())
        ToSCC.moveMessageSent.remove(player.uniqueId.toString())
        ToSCC.chatMessageSent.remove(player.uniqueId.toString())
        ToSCC.agree.add(player.uniqueId.toString())
        AgreeTxt().addList(player.uniqueId.toString())
        sender.sendMessage("${GREEN}利用規約に同意したことを確認しました。")

        return true
    }
}