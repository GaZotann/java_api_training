package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;


public class LauncherTest {
    @Test
    void mainTest2(){
        String[] args = {"9876"};
        org.assertj.core.api.Assertions.assertThatNoException().isThrownBy(() -> new ServeurHTTP(9876).create());
    }
}
