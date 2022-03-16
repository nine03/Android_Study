import com.example.project3.PackageTestClass;

public class PackageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PackageTestClass testClass = new PackageTestClass();
		
		testClass.color = "노랑";
		System.out.println("나의 색상은 " + testClass.getColor());
	}
}