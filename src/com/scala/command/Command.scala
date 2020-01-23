package com.scala.command

import com.scala.filesystem.State

trait Command {

  // a method that changes one state to another
  def apply(state: State) : State

}

object  Command{

  def from(input:String):Command =
    new UnknownCommand
}