package dev.siro256.spigotpl.toscc

import org.bukkit.ChatColor
import org.bukkit.ChatColor.RESET
import org.bukkit.ChatColor.YELLOW

class MessageReplacer {

    fun replace(): String {
        var message = Config.message

        while (message.contains(Regex("[\$][{].+}"))) {
            ChatColor.values()
                .filter { color -> "\${${color.name}}" in message }
                .forEach { color -> message = message.replace("\${${color.name}}", color.toString()) }
        }

        message += "$RESET \n${YELLOW}同意する場合は「同意する」を、同意しない場合は「同意しない」をクリックしてください。${RESET} \n "

        return message
    }
}