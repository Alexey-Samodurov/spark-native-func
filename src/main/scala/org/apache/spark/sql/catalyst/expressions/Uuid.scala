package org.apache.spark.sql.catalyst.expressions

import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback
import org.apache.spark.sql.types.{DataType, StringType}
import org.apache.spark.unsafe.types.UTF8String

/**
 * A case class that generates a unique identifier (UUID) as a string.
 * This class extends the LeafExpression and CodegenFallback traits.
 *
 * The UUID generated is a random UUID provided by `java.util.UUID.randomUUID`.
 * It is represented as a UTF8 string and is non-nullable.
 *
 * Implements the following methods:
 * - `nullable`: Specifies that the result of this expression is always non-nullable (false).
 * - `eval`: Specifies the output type of this expression during evaluation, which is defined as `StringType`.
 * - `dataType`: Defines the data type of the produced value as a UTF8String containing the random UUID string.
 */
case class Uuid() extends LeafExpression with CodegenFallback {

  override def nullable: Boolean = false

  override def eval(input: InternalRow): Any =
    UTF8String.fromString(java.util.UUID.randomUUID().toString)

  override def dataType: DataType = StringType

  override def prettyName: String = "uuid"
}

