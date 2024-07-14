public class DigitalLock {
    private String password;

    public DigitalLock(String password) {
        this.password = password;
    }

    public boolean unlock(String inputPassword) {
        return password.equals(inputPassword);
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (unlock(oldPassword)) {
            password = newPassword;
            return true;
        } else {
            return false;
        }
    }
}
