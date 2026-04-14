class CompareUtil {
    public static <T> boolean isEqual(T a, T b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.equals(b);
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(CompareUtil.isEqual(10, 10));
        System.out.println(CompareUtil.isEqual("Hello", "Hello"));
        System.out.println(CompareUtil.isEqual(10.5, 20.5));
    }
}