package com.scala.command
import com.scala.filesystem.State

/**
 * @author sahilgogna on 2020-01-25
 */
class Pwd extends Command {
  override def apply(state: State): State =
    state.setMessage(state.wd.path)
}
