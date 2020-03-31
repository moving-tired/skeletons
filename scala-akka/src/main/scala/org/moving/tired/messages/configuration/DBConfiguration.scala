package org.moving.tired.messages.configuration

import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

trait DBConfiguration {
  val config: DatabaseConfig[JdbcProfile]
  val db: JdbcProfile#Backend#Database = config.db
}
