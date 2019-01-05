package com.nyuciverse.passwordmanager.interfaces;
import com.nyuciverse.passwordmanager.enums.KeyboardButtonEnum;

public interface KeyboardButtonClickedListener {


    public void onKeyboardClick(KeyboardButtonEnum keyboardButtonEnum);


    public void onRippleAnimationEnd();

}
