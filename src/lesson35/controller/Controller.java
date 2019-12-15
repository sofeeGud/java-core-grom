package lesson35.controller;

import lesson35.model.Authorization;
import lesson35.model.UserType;

public class Controller {

    protected Authorization authorization;

    protected boolean isAccess(UserType userType) {
        if (authorization.checkIn()) {
            if (userType == UserType.ADMIN && !authorization.isAdmin()) {
                System.err.println("You can not using this function");
                return false;
            }

            return true;
        }
        System.err.println("You must be logged");
        return false;

    }
}
