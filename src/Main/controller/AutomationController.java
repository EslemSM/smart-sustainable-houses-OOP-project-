package Main.controller;

import java.time.LocalTime;
import Main.security.User;

public interface AutomationController {

    void tick(LocalTime systemTime, User currentUser);

}
