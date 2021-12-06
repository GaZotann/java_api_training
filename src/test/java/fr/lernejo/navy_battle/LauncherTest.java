package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;


public class LauncherTest {
    private final Launcher launcher = new Launcher();
    @Test
    void mainTest1(){
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Launcher.main(new String[] {})).withMessage("Il manque des arguments");
    }
    @Test
    void mainTest2(){
        org.assertj.core.api.Assertions.assertThatNoException().isThrownBy(() -> Launcher.main(new String[] {"9786"}));
    }
    /*@Test
    void mainTest3(){
        String[] args = {"9876"};
        org.assertj.core.api.Assertions.assertThatNoException().isThrownBy(() -> new ServeurHTTP(9876).create());
    }*/
}
