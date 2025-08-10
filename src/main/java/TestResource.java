

public class TestResource {
    public static void main(String[] args) {
        if (TestResource.class.getResource("/main/view/login.fxml") != null) {
            System.out.println("✅ Found login.fxml");
        } else {
            System.out.println("❌ login.fxml NOT found");
        }
    }
}
