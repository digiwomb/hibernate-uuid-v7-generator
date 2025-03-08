package dev.digiwomb.uuidv7

import com.fasterxml.uuid.Generators
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator
import java.io.Serializable

/**
 * A custom UUID generator for Hibernate that generates UUIDs of version 7.
 *
 * <p>This class implements {@link IdentifierGenerator} and uses the
 * {@code Generators.timeBasedEpochGenerator()} method from
 * <a href="https://github.com/cowtowncoder/java-uuid-generator">Java UUID Generator (JUG)</a>
 * to create time-ordered UUIDs v7.</p>
 *
 * <p>UUID v7 is defined in <a href="https://www.rfc-editor.org/rfc/rfc9562">RFC 9562</a>
 * and provides a sortable, time-based unique identifier.</p>
 *
 * @author digiwomb
 * @version 1.0.0
 */
class UuidV7GeneratorType : IdentifierGenerator {

    /**
     * Generates a UUID v7 as the identifier for Hibernate entities.
     *
     * @param session The Hibernate session (not used in this implementation).
     * @param obj The entity for which the ID is being generated (not used in this implementation).
     * @return A new UUID v7 as a {@link Serializable} object.
     */
    override fun generate(session: SharedSessionContractImplementor?, obj: Any?): Serializable {
        return Generators.timeBasedEpochGenerator().generate()
    }
}