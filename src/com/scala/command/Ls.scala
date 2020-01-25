package com.scala.command
import com.scala.files.DirEntry
import com.scala.filesystem.State

/**
 * @author sahilgogna on 2020-01-24
 */
 class Ls extends Command {

  def createNiceOutput(contents: List[DirEntry]):String = {
    if(contents.isEmpty) ""
    else {
      val entry = contents.head
      entry.name + "[" + entry.getType + "]" + "\n" + createNiceOutput(contents.tail)
    }
  }

  override def apply(state: State): State = {
    val contents = state.wd.contents
    val niceOutput = createNiceOutput(contents)
    state.setMessage(niceOutput)
  }
  
  
}
