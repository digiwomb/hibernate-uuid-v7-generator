package dev.digiwomb.uuidv7

import org.hibernate.annotations.IdGeneratorType

/**
 * Annotation to mark a field as a UUID v7 identifier.
 *
 * <p>This annotation applies the {@link UuidV7GeneratorType} as the ID generator for
 * Hibernate entities. The generator produces UUIDs of version 7, which are time-based
 * and sortable.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * @Entity
 * class ExampleEntity {
 *
 *     @Id
 *     @UuidV7Generator
 *     @GeneratedValue
 *     var id: UUID? = null
 * }
 * }
 * </pre>
 *
 * @see UuidV7GeneratorType
 * @author digiwomb
 * @version 1.0.0
 */
@IdGeneratorType(UuidV7GeneratorType::class)
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class UuidV7Generator
