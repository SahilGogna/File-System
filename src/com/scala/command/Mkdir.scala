package com.scala.command
import com.scala.files.{DirEntry, Directory}
import com.scala.filesystem.State

/**
 * @author sahilgogna on 2020-01-24
 */
class Mkdir(name:String) extends CreateEntry(name) {
  override def createSpecificEntry(state: State): DirEntry =
    Directory.empty(state.wd.path, name )
}
