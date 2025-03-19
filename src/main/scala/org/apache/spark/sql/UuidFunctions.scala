package org.apache.spark.sql

import org.apache.spark.sql.catalyst.expressions.{Expression, Uuid}

/**
 * Provides utility functions for generating and working with UUIDs.
 *
 * This object contains functions that utilize expressions
 * to create columns representing UUID values.
 */
object UuidFunctions {
  private def withExpr(expr: Expression): Column = Column(expr)
  def uuid(): Column = withExpr {
    Uuid()
  }
}
