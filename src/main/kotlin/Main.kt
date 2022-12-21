package org.example

import javassist.bytecode.stackmap.TypeData.ClassName
import org.sikuli.basics.Settings
import org.sikuli.script.*
import java.net.URL
import java.nio.file.Paths
import kotlin.text.*
import org.example.images.*

fun open(appName: String, waitTime: Int = 3, windowNo: Int = 0): Region {
    val app = App(appName)
    app.open(waitTime)
    app.focus()
    return app.window(windowNo)
}


fun main(args: Array<String>) {
    println("Hello World!")
//    val s = Screen()
    val path = Paths.get("").toAbsolutePath().toString()
    val jarPath: String = ClassName::class.java.getProtectionDomain()
        .getCodeSource()
        .getLocation()
        .toURI()
        .getPath()
    println("Working Directory = $path")
    println("Jar Dir = ${jarPath}")
    if (!ImagePath.add("images")) {
        ImagePath.add("../images");
    }

    Settings.DelayBeforeMouseDown = 0.05
    Settings.DelayBeforeDrag = 0.1
    Settings.DelayBeforeDrop = 0.1
    Settings.MoveMouseDelay = 0.0F
    Settings.TypeDelay = 0.0
    Settings.ClickDelay = 0.0

//    s.write("#w2.#M+#ENTER.#M-#w1.hello world#W250.#D3.#ENTER.")
//    val avatar = Pattern("avatar.png").similar(0.80)
//    val edit_icon = Pattern("edit_icon.png").targetOffset(4, 2)
//    val search_bar = Pattern("search_bar.png").similar(0.90)
    val s = open("Google Chrome")
    var m = s.wait(avatar, 10.0)
    s.click(m)
    m = s.wait(edit_icon)
    s.click(m)
//    s.wait(search_bar)
    s.click(search_bar)
    s.write("hello world#ENTER.")
    s.write("#m+a#m-#m+c#m-#w1.#BACK.")
    s.keyDown(Key.CMD)
    Thread.sleep(500)
    s.keyDown(Key.ENTER)
    s.keyUp(Key.ENTER)
    s.keyUp(Key.CMD)
//    s.write("#M+#w1.#ENTER.#M-")
    s.write("#w1.#m+v#m-#w1.#D3.")
    s.click(close_icon)
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")
}
