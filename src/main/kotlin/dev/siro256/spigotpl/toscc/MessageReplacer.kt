package dev.siro256.spigotpl.toscc

import org.bukkit.ChatColor.*

class MessageReplacer {

    fun replace(): String {
        var message = Config.message

        while (message.contains(Regex("[\$][{].+}"))) {
            if (message.contains("\${AQUA}")) {
                message = message.replace("\${AQUA}", "$AQUA")
            } else if (message.contains("\${BLACK}")) {
                message = message.replace("\${BLACK}", "$BLACK")
            } else if (message.contains("\${BLUE}")) {
                message = message.replace("\${BLUE}", "$BLUE")
            } else if (message.contains("\${BOLD}")) {
                message = message.replace("\${BOLD}", "$BOLD")
            } else if (message.contains("\${DARK_AQUA}")) {
                message = message.replace("\${DARK_AQUA}", "$DARK_AQUA")
            } else if (message.contains("\${DARK_BLUE}")) {
                message = message.replace("\${DARK_BLUE}", "$DARK_BLUE")
            } else if (message.contains("\${DARK_GRAY}")) {
                message = message.replace("\${DARK_GRAY}", "$DARK_GRAY")
            } else if (message.contains("\${DARK_GREEN}")) {
                message = message.replace("\${DARK_GREEN}", "$DARK_GREEN")
            } else if (message.contains("\${DARK_PURPLE}")) {
                message = message.replace("\${DARK_PURPLE}", "$DARK_PURPLE")
            } else if (message.contains("\${DARK_RED}")) {
                message = message.replace("\${DARK_RED}", "$DARK_RED")
            } else if (message.contains("\${GOLD}")) {
                message = message.replace("\${GOLD}", "$GOLD")
            } else if (message.contains("\${GRAY}")) {
                message = message.replace("\${GRAY}", "$GRAY")
            } else if (message.contains("\${GREEN}")) {
                message = message.replace("\${GREEN}", "$GREEN")
            } else if (message.contains("\${ITALIC}")) {
                message = message.replace("\${ITALIC}", "$ITALIC")
            } else if (message.contains("\${LIGHT_PURPLE}")) {
                message = message.replace("\${LIGHT_PURPLE}", "$LIGHT_PURPLE")
            } else if (message.contains("\${MAGIC}")) {
                message = message.replace("\${MAGIC}", "$MAGIC")
            } else if (message.contains("\${RED}")) {
                message = message.replace("\${RED}", "$RED")
            } else if (message.contains("\${RESET}")) {
                message = message.replace("\${RESET}", "$RESET")
            } else if (message.contains("\${STRIKETHROUGH}")) {
                message = message.replace("\${STRIKETHROUGH}", "$STRIKETHROUGH")
            } else if (message.contains("\${UNDERLINE}")) {
                message = message.replace("\${UNDERLINE}", "$UNDERLINE")
            } else if (message.contains("\${WHITE}")) {
                message = message.replace("\${YELLOW}", "$YELLOW")
            } else {
                message = message.replace(Regex("[\$][{].+}"), "[PLUGIN_MESSAGE: INVALID_BRACES]")
            }
        }

        message += "$RESET \n${YELLOW}同意する場合は「同意する」を、同意しない場合は「同意しない」をクリックしてください。${RESET} \n "

        return message
    }
}