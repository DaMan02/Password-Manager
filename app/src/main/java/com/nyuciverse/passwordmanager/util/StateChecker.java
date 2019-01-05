package com.nyuciverse.passwordmanager.util;

/**
 * Created by Manjeet Dayal on 08-08-2018.
 */

public class StateChecker {

    private static boolean firstTimeRun = true;
    private static boolean loggedIn = false;
    private static boolean passcodeSet = false;

    public static boolean isFirstTimeRun() {
        return firstTimeRun;
    }

    public static void setFirstTimeRun(boolean firstTimeRun) {
        StateChecker.firstTimeRun = firstTimeRun;
    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        StateChecker.loggedIn = loggedIn;
    }

    public static boolean isPasscodeSet() {
        return passcodeSet;
    }

    public static void setPasscodeSet(boolean passcodeSet) {
        StateChecker.passcodeSet = passcodeSet;
    }
}