package br.edu.mg.unifal.service;

import br.edu.mg.unifal.domain.Address;
import br.edu.mg.unifal.domain.User;
import br.edu.mg.unifal.enumerator.Gender;
import br.edu.mg.unifal.functionalinterface.TriPredicate;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.*;
import java.util.stream.Collectors;

@NoArgsConstructor
public class UserService {

    /**
     *
     * Predicate → boolean fun(T t);
     * Consumer → void fun(T t);
     * Supplier → T fun();
     * Function → T fun(U u);
     *
     */

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

    public Function<User, Boolean> isMaleUsingFunction = user ->
            Gender.MALE.equals(user.getGender());
    public Predicate<User> isPreferNotSay8 = user -> Gender.PREFER_NOT_SAY.equals(user.getGender());
    public BiPredicate<User, Gender> isSameGender8 = (user, gender) ->
            gender.equals(user.getGender());

    public Predicate<User> isFemale = user -> Gender.FEMALE.equals(user.getGender());

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

    public Function<Integer, Integer> calculateDouble8 = value -> value * 2;

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
     *      T filter(Predicate<? super T> predicate)
     *      Returns a stream consisting of the elements of this stream that match the given predicate.
     *
     *  map:
     *      T map(Function<? super T,? extends R> mapper)
     *      Returns a stream consisting of the results of applying the given function to the elements of this stream.
     *
     * Example: Implement three methods that:
     *  1. Prints the information of the users from a list
     *  2. Returns a list with female users
     *  3. Returns a list with the age of all users
     */

    // Using traditional Java
    public void printUser(List<User> users) {
//        for (User user : users) {
//            System.out.println(user.toString());
//        }
//        for (int i = 0; i < users.size(); i++) {
//            System.out.println(users.get(i).toString());
//        }
        users.stream().forEach(printUser8);
    }

    public List<User> onlyFemaleUsers(List<User> users) {
//        List<User> femaleUsers = new ArrayList<>();
//        for (User user : users) {
//            if (user.getGender().equals(Gender.FEMALE)) {
//                femaleUsers.add(user);
//            }
//        }
//        return femaleUsers;
        return users.stream().filter(isFemale).collect(Collectors.toList());
    }

    public List<Integer> createAgeList(List<User> users) {
//        List<Integer> ages = new ArrayList<>();
//        for (User user : users) {
//            ages.add(
//                    Period.between(user.getBirthdate().toLocalDate(), LocalDate.now())
//                            .getYears()
//            );
//        }
//        return ages;
        return users.stream().map(user -> Period.between(user.getBirthdate().toLocalDate(), LocalDate.now())
                .getYears()).collect(Collectors.toList());
    }

    // Using Stream (Java 8)

    public void printAllAges(List<User> users) {
        // Printem no console (terminal) a idade de todos os usuários
        // do sexo masculino com idade superior a 30 anos

        // Opção A
//        users.stream().filter(isMale8)
//                .map(user -> Period.between(user.getBirthdate().toLocalDate(), LocalDate.now())
//                        .getYears())
//                .filter(age -> age > 30)
//                .forEach(age -> System.out.println(age));

        // Opção B
        users.stream().filter(user ->
                user.getGender().equals(Gender.MALE)
                && Period.between(user.getBirthdate().toLocalDate(), LocalDate.now()).getYears() > 30
        ).forEach(user ->
                System.out.println(
                        Period.between(user.getBirthdate().toLocalDate(), LocalDate.now())
                                .getYears())
        );

    }

    public void testMatch(List<User> users) {
        boolean testAnymatch =
                users.stream().anyMatch(user ->
                        Gender.PREFER_NOT_SAY.equals(user.getGender()));
        boolean allLegal =
                users.stream().allMatch(user ->
                        Period.between(
                                user.getBirthdate().toLocalDate(), LocalDate.now()).getYears() >= 18
                );
        System.out.println("Exist 'PREFER NOT SAY' on database: " + testAnymatch);
        System.out.println("All users are legal? " + allLegal);
    }


    /* ------------------------------------ ## ------------------------------------ */

}
