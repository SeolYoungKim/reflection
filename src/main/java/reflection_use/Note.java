package reflection_use;

public class Note {

    public static String A = "A";

    private String b = "B";

    private void c() {
        System.out.println("C");
    }

    public int sum(int left, int right) {
        return left + right;
    }

    public Note() {
    }

    public Note(String b) {
        this.b = b;
    }
}
