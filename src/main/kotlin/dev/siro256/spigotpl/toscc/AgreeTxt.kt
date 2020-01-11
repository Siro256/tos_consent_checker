package dev.siro256.spigotpl.toscc

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.util.*
import kotlin.collections.ArrayList

class AgreeTxt {

    fun toList(): ArrayList<String> {
        val scanner = Scanner(File("${ToSCC.instance.dataFolder}/agree.txt"))
        val list = ArrayList<String>()

        while (scanner.hasNext()) { list.add(scanner.next()) }
        scanner.close()

        return list
    }

    fun addList(uuid: String) {
        output.append(uuid)
        val output = BufferedWriter(FileWriter(File("${ToSCC.instance.dataFolder}/agree.txt"), true))
        output.close()

        return
    }
}