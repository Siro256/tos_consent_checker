package dev.siro256.spigotpl.toscc

import org.bukkit.ChatColor.*
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class ToSCC: JavaPlugin() {

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
        val checking =  ArrayList<String>()
        val moveMessageSent = ArrayList<String>()
        val chatMessageSent = ArrayList<String>()
    }
}