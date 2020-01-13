package dev.siro256.spigotpl.toscc

import org.bukkit.configuration.file.FileConfiguration

class Config internal constructor(private val plugin: ToSCC) {

    init {
        plugin.saveDefaultConfig()
    }

    fun loadConfig() {
        config = plugin.config
        return
    }

    companion object {
        private lateinit var config: FileConfiguration

        val message: String
            get() = config.getString("message")
    }
}