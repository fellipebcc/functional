package br.edu.mg.unifal.service;

import br.edu.mg.unifal.domain.Address;
import br.edu.mg.unifal.domain.User;
import br.edu.mg.unifal.enumerator.Gender;
import br.edu.mg.unifal.functionalinterface.TriPredicate;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.UUID;
import java.util.function.*;

@NoArgsConstructor
public class UserService {

    /*
     *  PREDICATE
     *  Represents a predicate (boolean-valued function) of one argument.
     *  Example: Verify if the user is male
     */

    // Using traditional Java
    public Boolean isMale(User user) {
        return Gender.MALE.equals(user.getGender());
    }

    public Boolean isSameGender(User user, Gender gender) {
        return gender.equals(user.getGender());
    }

    // Using Predicate (Java 8)
    public Predicate<User> isMale8 = user -> Gender.MALE.equals(user.getGender());
    public Predicate<User> isPreferNotSay8 = user -> Gender.PREFER_NOT_SAY.equals(user.getGender());
    public BiPredicate<User, Gender> isSameGender8 = (user, gender) ->
            gender.equals(user.getGender());

    /* ------------------------------------ ## ------------------------------------ */

    /*
     *  CONSUMER
     *  Represents an operation that accepts a single input argument and returns no result.
     *  Unlike most other functional interfaces, Consumer is expected to operate via side effects.
     *  Example: Print the information of a user
     */

    // Using traditional Java
    public void printUser(User user) {
        System.out.println(user.toString());
    }

    // Using Consumer (Java 8)
    public Consumer<User> printUser8 = user -> System.out.println(user.toString());
    public BiConsumer<Gender, Address> printGenderAndAddress8 = (gender, address) -> {
        System.out.println(gender.toString());
        System.out.println(address.toString());
    };

    public Consumer<User> printGender8 = user ->
            System.out.println(user.getGender().toString());

    public Consumer<User> printAddress8 = user ->
            System.out.println(user.getAddress().toString());

    /* ------------------------------------ ## ------------------------------------ */

    /*
     *  SUPPLIER
     *  Represents a supplier of results.
     *  There is no requirement that a new or distinct result be returned each time the supplier is invoked.
     *  Example: Implement a method that provides a random uuid
     */

    // Using traditional Java
    public UUID getUUID() {
        return UUID.randomUUID();
    }

    // Using Supplier (Java 8)
    public Supplier<UUID> getUUID8 = UUID::randomUUID;

    public Supplier<LocalDate> getCurrentDate8 = LocalDate::now;

    /* ------------------------------------ ## ------------------------------------ */

    /*
     *  FUNCTION
     *  Represents a function that accepts one argument and produces a result.
     *  Example: Implement a method that calculates the age of the user
     */

    // Using traditional Java
    public int calculateAge(User user) {
        return Period.between(user.getBirthdate().toLocalDate(), LocalDate.now()).getYears();
    }

    // Using Function (Java 8)
    public Function<User, Integer> calculateAge8 = (user) ->
            Period.between(user.getBirthdate().toLocalDate(), LocalDate.now()).getYears();

    public BiFunction<LocalDate, LocalDate, Integer> calculateYearsBetweenDates = (firstDate, secondDate) -> {
        if (firstDate.isBefore(secondDate)) {
            return Period.between(firstDate, secondDate).getYears();
        }
        return Period.between(secondDate, firstDate).getYears();
    };

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
