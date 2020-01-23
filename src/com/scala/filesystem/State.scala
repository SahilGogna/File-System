package com.scala.filesystem

import com.scala.files.Directory

/**
 * @author sahilgogna on  2020-01-22
 * this class will hold root directory and the working directory of our file system
 */
class State (val root: Directory, val wd:Directory,  val output:String){

  def show:Unit = {
    println(output )
    print(State.SHELL_TOKEN)
  }

  def setMessage(message:String):State =
    State(root,wd,message)

}

object State{
  val SHELL_TOKEN = "$  "

  // factory method to create a new state
  def apply(root:Directory, wd:Directory, output:String ="") : State =
    new State(root,wd,output)
}
