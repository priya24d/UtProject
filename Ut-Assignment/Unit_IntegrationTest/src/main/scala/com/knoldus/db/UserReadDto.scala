package com.knoldus.db

import com.knoldus.models.User
import scala.collection.immutable.HashMap

 class UserReadDto {                       //User data

  val priyaUser: User = User("Priya","Dahiya","knoldus","priya.dahiya@knoldus.com")
  val alkaUser: User = User("Alka","Vats","knoldus","alka.vats@knoldus.com")
  val users: HashMap[String, User] = HashMap("Priya" -> priyaUser, "Alka" -> alkaUser)

  def getUserByName(name: String): Option[User] = users.get(name)
}
