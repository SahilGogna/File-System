package com.scala.command
import com.scala.filesystem.State

/**
 * @author sahilgogna on 2020-01-22
 */
class UnknownCommand extends Command {
  override def apply(state: State): State =
    state.setMessage("Command not found!")

}
