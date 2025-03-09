# Hibernate UUIDv7 Generator

This is a Hibernate ID generator library that generates UUIDv7 according to the [UUIDv7 specification](https://datatracker.ietf.org/doc/html/rfc9562). It can be used as a replacement for Hibernate’s default UUID generators.

## Why Use UUIDv7?

UUIDv7 combines the best features of traditional UUIDs and sequential IDs. Here are some key benefits:

- **Better Performance in Databases**  
  UUIDv7 is time-ordered, which improves index locality in databases, reducing fragmentation and increasing query efficiency.
  
- **Globally Unique**  
  Unlike sequential IDs (such as auto-incremented integers), UUIDv7 ensures uniqueness across distributed systems without requiring a central authority.
  
- **More Human-Readable and Debuggable**  
  Since UUIDv7 includes a timestamp component, it’s easier to sort and debug data compared to random UUIDs (UUIDv4).
  
- **Safer for Sharding and Replication**  
  UUIDv7 allows for efficient sharding in distributed databases, as records are naturally sorted by creation time.

## Installation

The library can be integrated via JitPack. Details for various build tools can be found on [JitPack](https://jitpack.io/#digiwomb/hibernate-uuid-v7-generator).

## Usage

The library provides the `@UuidV7Generator` annotation, which can be used in Hibernate entities to automatically generate a UUIDv7 as a primary key.

### Example

```kotlin
import jakarta.persistence.*
import uuidv7.UuidV7Generator
import java.util.UUID

@Entity
class User(

    @Id
    @GeneratedValue
    @UuidV7Generator
    var id: UUID? = null,

    @Column(nullable = false)
    var name: String
)
```

In this example, each new `User` object will automatically receive a UUIDv7 as its `id`.

## License

This library is licensed under the MIT License. See [LICENSE](https://github.com/digiwomb/hibernate-uuid-v7-generator/blob/main/LICENSE) for more details.
