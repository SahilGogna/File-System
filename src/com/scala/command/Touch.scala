package com.scala.command
import com.scala.files.{DirEntry, File}
import com.scala.filesystem.State

/**
 * @author sahilgogna on 2020-01-25
 */
class Touch(name:String) extends CreateEntry(name){
  override def createSpecificEntry(state: State): DirEntry =
    File.empty(state.wd.path, name)
}
