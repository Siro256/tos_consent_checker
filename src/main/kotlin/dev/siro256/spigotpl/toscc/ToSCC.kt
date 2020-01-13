package dev.siro256.spigotpl.toscc

import org.bukkit.ChatColor.GREEN
import org.bukkit.ChatColor.RED
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class ToSCC : JavaPlugin() {

    init {
        instance = this
    }

    override fun onEnable() {
        Config(this).loadConfig()

        if (!File("${dataFolder}/agree.txt").exists()) {
            Files.createFile(Paths.get("${dataFolder}/agree.txt"))
        }

        message = MessageReplacer().replace()
        agree = AgreeTxt().toList()

        mapOf(
            "agree" to AgreeCommand,
            "disagree" to DisagreeCommand
        ).forEach { (commandName, executor) -> getCommand(commandName).executor = executor }

        listOf(
            PlayerJoinEvent(),
            PlayerMoveEvent(),
            AsyncPlayerChatEvent()
        ).forEach { server.pluginManager.registerEvents(it, this) }

        server.consoleSender.sendMessage("${GREEN}ToSCCを起動しました")
    }

    override fun onDisable() {
        server.consoleSender.sendMessage("${RED}ToSCCを停止しました")
    }

    companion object {
        lateinit var instance: ToSCC
        lateinit var message: String
        lateinit var agree: ArrayList<String>
        val checking = mutableListOf<String>()
        val moveMessageSent = mutableListOf<String>()
        val chatMessageSent = mutableListOf<String>()
    }
}