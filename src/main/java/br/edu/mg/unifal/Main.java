package br.edu.mg.unifal;

import br.edu.mg.unifal.enumerator.Gender;
import br.edu.mg.unifal.factory.UserAssembler;
import br.edu.mg.unifal.service.UserService;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        UserService service = new UserService();
//        System.out.println(service.isMale8
//                .or(service.isPreferNotSay8)
//                .test(UserAssembler.assemble().get(0)));
//        System.out.println(service.isSameGender8
//                .test(UserAssembler.assemble().get(1), Gender.FEMALE));
//        service.printUser(UserAssembler.assemble().get(9));
//        service.printUser8.accept(UserAssembler.assemble().get(8));
//        service.printGenderAndAddress8.accept(Gender.MALE,
//                UserAssembler.assemble().get(0).getAddress());
//        service.printGender8.andThen(service.printAddress8)
//                .accept(UserAssembler.assemble().get(0));
//        System.out.println(service.getUUID().toString());
//        System.out.println(service.getCurrentDate8.get());
//        System.out.println(service.calculateAge(UserAssembler.assemble().get(10)));
//        System.out.println(service.calculateAge8
//                        .andThen(service.calculateDouble8)
//                .apply(UserAssembler.assemble().get(9)));
//        System.out.println(service.calculateYearsBetweenDates
//                .apply(LocalDate.now(), LocalDate.now().minusYears(25)));
//        System.out.println(service.calculateYearsBetweenDates
//                .apply(LocalDate.now().minusYears(25), LocalDate.now()));
//        service.printUser(UserAssembler.assemble());
//        service.printUser(service.onlyFemaleUsers(UserAssembler.assemble()));
//        service.createAgeList(UserAssembler.assemble());
//        service.printAllAges(UserAssembler.assemble());
        service.testMatch(UserAssembler.assemble());
    }

}
