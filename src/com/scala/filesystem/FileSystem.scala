package com.scala.filesystem

import java.util.Scanner

import com.scala.command.Command
import com.scala.files.Directory

// App is the utility class in scala library that already extends main method in its constructor
object FileSystem extends App {

  // root directory
  val root = Directory.ROOT
  // empty state
  var state = State(root,root )
  val scanner = new Scanner(System.in)

  while (true){
    state.show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
  }
}
