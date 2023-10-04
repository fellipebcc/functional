package br.edu.mg.unifal.service;

import br.edu.mg.unifal.domain.User;
import br.edu.mg.unifal.enumerator.Gender;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserService {

    /*
     *  PREDICATE
     *  Represents a predicate (boolean-valued function) of one argument.
     *  Example: Verify if the user is male
     */

    // Using traditional Java
    public boolean isMale(User user) {
        return Gender.MALE.equals(user.getGender());
    }
    // Using Predicate (Java 8)


    /* ------------------------------------ ## ------------------------------------ */

    /*
     *  CONSUMER
     *  Represents an operation that accepts a single input argument and returns no result.
     *  Unlike most other functional interfaces, Consumer is expected to operate via side effects.
     *  Example: Print the information of a user
     */

    // Using traditional Java

    // Using Consumer (Java 8)


    /* ------------------------------------ ## ------------------------------------ */

    /*
     *  SUPPLIER
     *  Represents a supplier of results.
     *  There is no requirement that a new or distinct result be returned each time the supplier is invoked.
     *  Example: Implement a method that provides a random uuid
     */

    // Using traditional Java

    // Using Supplier (Java 8)


    /* ------------------------------------ ## ------------------------------------ */

    /*
     *  FUNCTION
     *  Represents a function that accepts one argument and produces a result.
     *  Example: Implement a method that calculates the age of the user
     */

    // Using traditional Java

    // Using Function (Java 8)



    /* ------------------------------------ ## ------------------------------------ */

    /*
     *  STREAM
     *  A sequence of elements supporting sequential and parallel aggregate operations.
     *  It supports methods such as: forEach, filter, and map.
     *
     *  forEach:
     *      void forEach(Consumer<? super T> action)
     *      Performs an action for each element of this stream.
     *
     *  filter:
     *      filter(Predicate<? super T> predicate)
     *      Returns a stream consisting of the elements of this stream that match the given predicate.
     *
     *  map:
     *      map(Function<? super T,? extends R> mapper)
     *      Returns a stream consisting of the results of applying the given function to the elements of this stream.
     *
     * Example: Implement three methods that:
     *  1. Prints the information of the users from a list
     *  2. Returns a list with female users
     *  3. Returns a list with the age of all users
     */

    // Using traditional Java

    // Using Stream (Java 8)


    /* ------------------------------------ ## ------------------------------------ */

}
