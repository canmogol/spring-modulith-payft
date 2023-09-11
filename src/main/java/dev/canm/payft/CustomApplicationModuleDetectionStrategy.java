//package dev.canm.payft;
//
//import org.springframework.modulith.ApplicationModule;
//import org.springframework.modulith.core.ApplicationModuleDetectionStrategy;
//import org.springframework.modulith.core.JavaPackage;
//
//import java.util.stream.Stream;
//
///**
// * See the "spring.factories" file in META-INF for the declaration of this class.
// */
//public class CustomApplicationModuleDetectionStrategy implements ApplicationModuleDetectionStrategy {
//    public Stream<JavaPackage> getModuleBasePackages(JavaPackage basePackage) {
//        Stream<JavaPackage> subPackagesAnnotatedWith = basePackage.getSubPackagesAnnotatedWith(ApplicationModule.class);
//        return subPackagesAnnotatedWith;
//    }
//
//}
